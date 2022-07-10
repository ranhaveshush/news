package com.example.baseapp.data.serializer

import java.io.InputStream

interface JsonSerializer<T> {
    fun <T> decodeFromStream(stream: InputStream): T
}