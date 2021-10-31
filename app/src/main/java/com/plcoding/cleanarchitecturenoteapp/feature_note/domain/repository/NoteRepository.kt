package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * Interfaces usually belongs to the Domain layer
 * and their implementation lies at the Data Layer
 */

interface NoteRepository {

    fun getNotes() : Flow<List<Note>>

    suspend fun getNoteById(id : Int) : Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}