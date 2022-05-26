package com.kurovale.plugins

import io.ktor.server.sessions.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*

data class UserSession(val name: String) : Principal
fun Application.configureSecurity() {
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Authentication) {
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials ->
                if (credentials.name == "kurovale" && credentials.password == "admin123") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
        session<UserSession>("auth-session") {
            validate { session ->
                if (session.name == "kurovale") {
                    session
                } else {
                    null
                }
            }
            challenge {
                call.respondRedirect("auth/login")
            }
        }
    }
}
