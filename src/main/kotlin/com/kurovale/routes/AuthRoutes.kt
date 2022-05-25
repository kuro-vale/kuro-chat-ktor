package com.kurovale.routes

import com.kurovale.dao.userDAO
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.authRouting() {
    route("/auth") {
        get("register") {
            call.respond(FreeMarkerContent("register.ftl", model = null))
        }
        post("register") {
            val formParameters = call.receiveParameters()
            val username = formParameters.getOrFail("username")
            val password = formParameters.getOrFail("password")
            userDAO.storeUser(username, password)
            call.respondRedirect("/auth/profile")
        }
        get("profile") {
            // todo
        }
        get("login") {
            // todo
        }
        post("login") {
            // todo
        }
        post("logout") {
            //todo
        }
        post("profile") {
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val username = formParameters.getOrFail("username")
                    // todo
                }
                "delete" -> {
                    // todo
                }
            }
        }
    }
}