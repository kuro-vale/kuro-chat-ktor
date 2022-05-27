package com.kurovale.plugins

import com.kurovale.models.MessageSection
import com.kurovale.dao.messageDAO
import com.kurovale.models.ChatConnection
import io.ktor.server.websocket.*
import java.time.Duration
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.websocket.*
import java.util.Collections

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    routing {
        val connections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
            webSocket("/general-english") {
                val username = call.request.queryParameters["username"]
                val thisConnection = ChatConnection(this, username)
                connections += thisConnection
                try {
                    for (frame in incoming) {
                        frame as? Frame.Text ?: continue
                        val receivedText = frame.readText()
                        if (receivedText == "") {
                            continue
                        }
                        messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.GENERAL_US)
                        val textWithUserName = "[${thisConnection.username}]: $receivedText"
                        connections.forEach {
                            it.session.send(textWithUserName)
                        }
                    }
                } finally {
                    connections -= thisConnection
                }
            }
    }
}
