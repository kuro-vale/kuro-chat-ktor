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
import org.jetbrains.exposed.exceptions.ExposedSQLException

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
            try {
                userDAO.storeUser(username, password)
            } catch (e: ExposedSQLException) {
                call.respondRedirect("/403")
            }
            call.sessions.set(UserSession(name = username))
            call.respondRedirect("/profile")
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
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            call.respond(FreeMarkerContent("profile.ftl", mapOf("user" to userSession?.name, "authenticated" to true)))
        }
        post("profile") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            val user = userSession?.name?.let { it1 -> userDAO.getUser(it1) }
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val newUsername = formParameters.getOrFail("username")
                    user?.id?.let { it1 -> userDAO.editUser(it1, newUsername) }
                    val updatedUser = userDAO.getUser(newUsername)
                    call.sessions.set(updatedUser?.username?.let { it1 -> UserSession(it1) })
                    call.respondRedirect("/")
                }
                "delete" -> {
                    user?.id?.let { it1 -> userDAO.deleteUser(it1) }
                    call.sessions.clear<UserSession>()
                    call.respondRedirect("/")
                }
            }
        }
    }
}