package com.example.baseapp.data.file

interface FileDataSource<T> {
    suspend fun readFile(): List<T>
}