package com.kurovale.plugins

import freemarker.cache.*
import freemarker.core.HTMLOutputFormat
import io.ktor.server.freemarker.*
import io.ktor.server.application.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
        defaultEncoding = "UTF-8"
    }
}
