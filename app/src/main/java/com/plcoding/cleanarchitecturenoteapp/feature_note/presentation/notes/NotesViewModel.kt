package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase
)  : ViewModel() {



    override fun onCleared() {
        super.onCleared()
    }
}