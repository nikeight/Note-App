package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

/**
 * Instead of passing all the usecases we can just pass this class
 * at the view-model and for separate features we can use separate data class of the use cases
 */
data class NoteUseCase(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase
)