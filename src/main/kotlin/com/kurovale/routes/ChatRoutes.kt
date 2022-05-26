package com.kurovale.routes

import com.kurovale.plugins.UserSession
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

fun Route.chatRouting() {
    authenticate("auth-session") {
        get("/general-english") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            call.respond(FreeMarkerContent("general-english.ftl", mapOf("authenticated" to true)))
        }
    }
}