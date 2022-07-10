package com.example.baseapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val description: String
)

val Pokemon.imageFileName: String
    get() = String.format("pokemon_%03d", id)