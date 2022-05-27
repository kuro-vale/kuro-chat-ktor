package com.kurovale.dao

import com.kurovale.models.Message

interface MessageDAOFacade {
    suspend fun getAllMessagesBySection(section: MessageSection): List<Message>
    suspend fun storeMessage(username: String?, body: String, section: MessageSection): Message?
}