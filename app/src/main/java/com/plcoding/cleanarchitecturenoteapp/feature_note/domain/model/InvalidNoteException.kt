package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model

import java.lang.Exception

/**
 * This class is generally for catching any exception while inserting the note to the
 * database
 */

class InvalidNoteException(message : String) : Exception(message) {

}