package com.example.baseapp.ui

interface UiStateTransformer<Data, UiState> {
    fun transform(data: Data): UiState

    fun transform(list: List<Data>): List<UiState> {
        return list.map { data ->
            transform(data)
        }
    }
}