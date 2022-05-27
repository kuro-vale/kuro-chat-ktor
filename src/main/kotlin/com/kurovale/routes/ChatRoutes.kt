package com.kurovale.routes

import com.kurovale.models.MessageSection
import com.kurovale.dao.messageDAO
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
            val messages = messageDAO.getAllMessagesBySection(MessageSection.GENERAL_US)
            call.respond(FreeMarkerContent("chats/general-english.ftl", mapOf("authenticated" to true, "username" to userSession?.name, "messages" to messages)))
        }
        get("/general-spanish") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            val messages = messageDAO.getAllMessagesBySection(MessageSection.GENERAL_ES)
            call.respond(FreeMarkerContent("chats/general-spanish.ftl", mapOf("authenticated" to true, "username" to userSession?.name, "messages" to messages)))
        }
        get("/games") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            val messages = messageDAO.getAllMessagesBySection(MessageSection.GAMES)
            call.respond(FreeMarkerContent("chats/games.ftl", mapOf("authenticated" to true, "username" to userSession?.name, "messages" to messages)))
        }
        get("/movies") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            val messages = messageDAO.getAllMessagesBySection(MessageSection.MOVIES)
            call.respond(FreeMarkerContent("chats/movies.ftl", mapOf("authenticated" to true, "username" to userSession?.name, "messages" to messages)))
        }
        get("/books") {
            val userSession = call.principal<UserSession>()
            call.sessions.set(userSession?.copy())
            val messages = messageDAO.getAllMessagesBySection(MessageSection.BOOKS)
            call.respond(FreeMarkerContent("chats/books.ftl", mapOf("authenticated" to true, "username" to userSession?.name, "messages" to messages)))
        }
    }
}