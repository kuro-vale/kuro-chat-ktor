package com.kurovale.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    
    routing {
        static("/static") {
            resources("static")
        }
        get("/") {
            call.respond(FreeMarkerContent("index.ftl", model = null))
        }
    }
}
