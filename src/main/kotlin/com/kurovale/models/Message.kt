package com.kurovale.models

import org.jetbrains.exposed.sql.Table

data class Message(val username: String?, val body: String, val section: MessageSection)

object Messages : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", length = 50).nullable()
    val body = varchar("body", length = 255)
    val section = customEnumeration(
        "section",
        "TEXT CHECK( section IN ('GENERAL_US','GENERAL_ES','GAMES', 'MOVIES', 'BOOKS') )",
        { value -> MessageSection.valueOf(value as String) },
        { it.name })

    override val primaryKey = PrimaryKey(id)
}
