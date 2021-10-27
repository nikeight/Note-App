package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils

sealed class NoteOrder(
    val orderType: OrderType
) {
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)

    /**
     * Creating our own copy function
     * (i.e is being provided by the data class by default
     *      but we can't use data class here as it will leads to
     *      some name conflicts error and other stuff)
     */

    fun copy(orderType: OrderType): NoteOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Title(orderType)
        }
    }
}