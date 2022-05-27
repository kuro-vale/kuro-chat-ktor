package com.kurovale.dao

import com.kurovale.models.Message
import com.kurovale.models.MessageSection

interface MessageDAOFacade {
    suspend fun getAllMessagesBySection(section: MessageSection): List<Message>
    suspend fun storeMessage(username: String?, body: String, section: MessageSection): Message?
}