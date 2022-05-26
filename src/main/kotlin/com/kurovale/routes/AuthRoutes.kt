package com.kurovale.routes

import com.kurovale.dao.userDAO
import com.kurovale.plugins.UserSession
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.server.util.*

fun Route.authRouting() {
    route("/auth") {
        get("register") {
            var authenticated = false
            if (call.sessions.get<UserSession>() != null) {
                authenticated = true
            }
            call.respond(FreeMarkerContent("register.ftl", mapOf("authenticated" to authenticated)))
        }
        post("register") {
            val formParameters = call.receiveParameters()
            val username = formParameters.getOrFail("username")
            val password = formParameters.getOrFail("password")
            userDAO.storeUser(username, password)
            call.respondRedirect("/auth/profile")
        }
        get("login") {
            var authenticated = false
            if (call.sessions.get<UserSession>() != null) {
                authenticated = true
            }
            call.respond(FreeMarkerContent("login.ftl", mapOf("authenticated" to authenticated)))
        }
        authenticate("auth-form") {
            post("login") {
                val username = call.principal<UserIdPrincipal>()?.name.toString()
                call.sessions.set(UserSession(name = username))
                call.respondRedirect("/profile")
            }
        }
        post("logout") {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/auth/login")
        }
    }
    authenticate("auth-session") {
        get("profile") {
            // todo
        }
        get("/hello") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            call.respondText("Hello ${userSession?.name}")
        }
        post("profile") {
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
//                    val username = formParameters.getOrFail("username")
                    // todo
                }
                "delete" -> {
                    // todo
                }
            }
        }
    }
}