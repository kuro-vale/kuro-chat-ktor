package com.kurovale.plugins

import io.ktor.server.websocket.*
import java.time.Duration
import io.ktor.server.application.*

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
}
