package com.kurovale.models

import org.jetbrains.exposed.sql.Table

data class User(val id: Int, val username: String)

object Users: Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 50)
    val password = varchar("password", 255)

    override val primaryKey = PrimaryKey(id)
}
