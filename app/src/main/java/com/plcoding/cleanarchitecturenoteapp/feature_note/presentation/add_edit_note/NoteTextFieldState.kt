package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note


/**
 * We are not saving the state of the title because
 * Changing the title frequently can leads to the re compose of the whole Composable
 * And we don't want that affects the performance
 */

data class NoteTextFieldState(

    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = false
)