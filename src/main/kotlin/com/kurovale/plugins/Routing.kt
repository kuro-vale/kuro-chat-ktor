package com.kurovale.plugins

import com.kurovale.routes.authRouting
import com.kurovale.routes.chatRouting
import com.kurovale.routes.httpStatusRouting
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*

fun Application.configureRouting() {
    
    routing {
        static("/static") {
            resources("static")
        }
        get("/") {
            var authenticated = false
            if (call.sessions.get<UserSession>() != null) {
               authenticated = true
            }
            call.respond(FreeMarkerContent("index.ftl", mapOf("authenticated" to authenticated)))
        }
        authRouting()
        httpStatusRouting()
        chatRouting()
    }
}
