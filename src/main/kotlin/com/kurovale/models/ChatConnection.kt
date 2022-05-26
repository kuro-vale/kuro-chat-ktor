package com.kurovale.models

import io.ktor.websocket.*

class ChatConnection(val session: DefaultWebSocketSession, val username: String?)