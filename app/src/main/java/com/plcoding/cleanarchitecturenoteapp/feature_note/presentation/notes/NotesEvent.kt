package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils.NoteOrder

/**
 * This is the class to cover all the events of the UI with the composable
 * UI events
 */

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNotes(val note: Note) : NotesEvent()
    object RestoreNotes : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}