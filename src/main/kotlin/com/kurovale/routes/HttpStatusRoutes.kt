package com.kurovale.routes

import com.kurovale.plugins.UserSession
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Route.httpStatusRouting() {
    get("401") {
        var authenticated = false
        if (call.sessions.get<UserSession>() != null) {
            authenticated = true
        }
        call.respond(FreeMarkerContent("401.ftl", mapOf("authenticated" to authenticated)))
    }
    get("403") {
        var authenticated = false
        if (call.sessions.get<UserSession>() != null) {
            authenticated = true
        }
        call.respond(FreeMarkerContent("403.ftl", mapOf("authenticated" to authenticated)))
    }
}