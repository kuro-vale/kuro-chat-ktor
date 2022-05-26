package com.kurovale.plugins

import com.kurovale.dao.userDAO
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
                val user = userDAO.getUser(credentials.name)
                if (credentials.password == user?.password) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
            challenge {
                call.respondRedirect("/401")
            }
        }
        session<UserSession>("auth-session") {
            validate { session ->
                session
            }
            challenge {
                call.respondRedirect("auth/login")
            }
        }
    }
}
