package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddEditNoteViewModel(
    private val noteUseCase: NoteUseCase
) : ViewModel() {



    override fun onCleared() {
        super.onCleared()
    }
}