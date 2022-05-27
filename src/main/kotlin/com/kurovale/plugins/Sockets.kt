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
        val generalUsConnections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
        val generalEsConnections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
        val gamesConnections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
        val moviesEsConnections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
        val booksEsConnections = Collections.synchronizedSet<ChatConnection?>(LinkedHashSet())
            webSocket("/general-english") {
                val username = call.request.queryParameters["username"]
                val thisConnection = ChatConnection(this, username)
                generalUsConnections += thisConnection
                try {
                    for (frame in incoming) {
                        frame as? Frame.Text ?: continue
                        val receivedText = frame.readText()
                        if (receivedText == "") {
                            continue
                        }
                        messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.GENERAL_US)
                        val textWithUserName = "[${thisConnection.username}]: $receivedText"
                        generalUsConnections.forEach {
                            it.session.send(textWithUserName)
                        }
                    }
                } finally {
                    generalUsConnections -= thisConnection
                }
            }
        webSocket("/general-spanish") {
            val username = call.request.queryParameters["username"]
            val thisConnection = ChatConnection(this, username)
            generalEsConnections += thisConnection
            try {
                for (frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    if (receivedText == "") {
                        continue
                    }
                    messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.GENERAL_ES)
                    val textWithUserName = "[${thisConnection.username}]: $receivedText"
                    generalEsConnections.forEach {
                        it.session.send(textWithUserName)
                    }
                }
            } finally {
                generalEsConnections -= thisConnection
            }
        }
        webSocket("/games") {
            val username = call.request.queryParameters["username"]
            val thisConnection = ChatConnection(this, username)
            gamesConnections += thisConnection
            try {
                for (frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    if (receivedText == "") {
                        continue
                    }
                    messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.GAMES)
                    val textWithUserName = "[${thisConnection.username}]: $receivedText"
                    gamesConnections.forEach {
                        it.session.send(textWithUserName)
                    }
                }
            } finally {
                gamesConnections -= thisConnection
            }
        }
        webSocket("/movies") {
            val username = call.request.queryParameters["username"]
            val thisConnection = ChatConnection(this, username)
            moviesEsConnections += thisConnection
            try {
                for (frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    if (receivedText == "") {
                        continue
                    }
                    messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.MOVIES)
                    val textWithUserName = "[${thisConnection.username}]: $receivedText"
                    moviesEsConnections.forEach {
                        it.session.send(textWithUserName)
                    }
                }
            } finally {
                moviesEsConnections -= thisConnection
            }
        }
        webSocket("/books") {
            val username = call.request.queryParameters["username"]
            val thisConnection = ChatConnection(this, username)
            booksEsConnections += thisConnection
            try {
                for (frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    if (receivedText == "") {
                        continue
                    }
                    messageDAO.storeMessage(thisConnection.username, receivedText, MessageSection.BOOKS)
                    val textWithUserName = "[${thisConnection.username}]: $receivedText"
                    booksEsConnections.forEach {
                        it.session.send(textWithUserName)
                    }
                }
            } finally {
                booksEsConnections -= thisConnection
            }
        }
    }
}
