package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

import com.google.common.truth.Truth.assertThat
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.FakeRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesUseCaseTest {

    // Step 1: We define the dependencies here
    // Then our class that is the Use cases
    private lateinit var getNotesUseCase: GetNotesUseCase
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        getNotesUseCase = GetNotesUseCase(fakeRepository)

        // Step 2: Populate the List to mock the SQL database
        // Which already have some data present
        val noteToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed{ index, c ->
            noteToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timeStamp = index.toLong(),
                    color = index
                )
            )
        }

        // Shuffling the list to check if the Our business logic returns the
        // Sorted List or not.
        noteToInsert.shuffle()
        runBlocking {
            noteToInsert.forEach {
                fakeRepository.insertNote(it)
            }
        }
    }

    // Step 3: Test the various parts of your program.
    /**
     * How we write the function declaration is something like this.
     * fun whatWeAreDoing_whatWeExpectedTheOutputShouldBe()
     */

    /** For Testing the Title */
    @Test
    fun `order notes by title ascending, correct order`(){
        runBlocking {
         val allNotes = getNotesUseCase(NoteOrder.Title(OrderType.Ascending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isLessThan(allNotes[i + 1].title)
            }
        }
    }

    @Test
    fun `order notes by title descending, correct order`(){
        runBlocking {
            val allNotes = getNotesUseCase(NoteOrder.Title(OrderType.Descending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isGreaterThan(allNotes[i + 1].title)
            }
        }
    }

    /** For testing the dates */
    @Test
    fun `order notes by date ascending, correct order`(){
        runBlocking {
            val allNotes = getNotesUseCase(NoteOrder.Date(OrderType.Ascending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isLessThan(allNotes[i + 1].title)
            }
        }
    }

    @Test
    fun `order notes by date descending, correct order`(){
        runBlocking {
            val allNotes = getNotesUseCase(NoteOrder.Date(OrderType.Descending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isGreaterThan(allNotes[i + 1].title)
            }
        }
    }

    /** For Testing the color Int */
    @Test
    fun `order notes by color ascending, correct order`(){
        runBlocking {
            val allNotes = getNotesUseCase(NoteOrder.Color(OrderType.Ascending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isLessThan(allNotes[i + 1].title)
            }
        }
    }

    @Test
    fun `order notes by color descending, correct order`(){
        runBlocking {
            val allNotes = getNotesUseCase(NoteOrder.Color(OrderType.Descending)).first()

            for (i in 0..allNotes.size - 2){
                assertThat(allNotes[i].title).isGreaterThan(allNotes[i + 1].title)
            }
        }
    }
}