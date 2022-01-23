package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Because we are uninstalling the AppModule
 * The Hilt will produce dependency graph using this
 * TestAppModule
 *
 * And here we provide all the Mock Classes which stimulate the real ones.
 */
@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    /**
     * `inMemoryDatabaseBuilder` creates a Mock Room Database
     * Which keep the data in the Memory
     * Instead of the Drives
     *
     * `inMemoryDatabaseBuilder` doesn't need a Name of the Database
     */
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java,
        ).build()
    }

    /**
     * The DAO is being imported by the Database of the ROOM
     * That's why we can have it
     */
    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(
                repository = repository
            ),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository = repository)
        )
    }


}