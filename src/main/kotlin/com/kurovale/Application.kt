package com.kurovale

import com.kurovale.dao.DatabaseFactory
import io.ktor.server.application.*
import com.kurovale.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val jdbcURL = environment.config.property("ktor.database.DATABASE_URL").getString()
    DatabaseFactory.init(jdbcURL)
    configureRouting()
    configureSockets()
    configureTemplating()
    configureSecurity()
}
