package com.example.baseapp.data.json

import kotlinx.serialization.json.Json

val format = Json {
    ignoreUnknownKeys = true
}