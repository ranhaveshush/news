package com.example.baseapp.data

interface Transformer<T, R> {
    fun transform(t: T): R

    fun transform(list: List<T>): List<R> = list.map {
        transform(it)
    }
}