package com.udacity.notepad.data

import android.content.Context

import java.util.concurrent.Executor
import java.util.concurrent.Executors

object DataStore {
  private val EXEC: Executor = Executors.newSingleThreadExecutor()

  lateinit var notes: NoteDatabase

  fun init(context: Context) {
    notes = NoteDatabase(context)
  }

  fun execute(fn: () -> Unit) {
    execute(Runnable {
      fn.invoke()
    })
  }

  private fun execute(runnable: Runnable) {
    EXEC.execute(runnable)
  }

}
