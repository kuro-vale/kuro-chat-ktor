package com.kurovale.dao

import com.kurovale.models.Messages
import com.kurovale.models.Users
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        val driverClassName = "org.sqlite.JDBC"
        val database = Database.connect("jdbc:sqlite:./data.db", driverClassName)
        transaction(database) {
            SchemaUtils.create(Users)
            SchemaUtils.create(Messages)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}