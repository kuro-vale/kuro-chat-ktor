package com.kurovale.dao

import com.kurovale.dao.DatabaseFactory.dbQuery
import com.kurovale.models.Message
import com.kurovale.models.MessageSection
import com.kurovale.models.Messages
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class MessageDAOFacadeImpl : MessageDAOFacade {
    private fun resultRowToMessage(row: ResultRow) = Message(
        username = row[Messages.username],
        body = row[Messages.body],
        section = row[Messages.section]
    )

    override suspend fun getAllMessagesBySection(section: MessageSection): List<Message> = dbQuery {
        Messages
            .select {Messages.section eq section}
            .map(::resultRowToMessage)
    }

    override suspend fun storeMessage(username: String?, body: String, section: MessageSection): Message? = dbQuery {
        val insertStatement = Messages.insert {
            it[Messages.username] = username
            it[Messages.body] = body
            it[Messages.section] = section
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToMessage)
    }
}

val messageDAO: MessageDAOFacade = MessageDAOFacadeImpl()