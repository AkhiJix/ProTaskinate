package com.akhijix.protaskinate.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
    // use shortcut dbcallback for a sample callback class

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insertTask(Task("Buy Groceries", isImportant = true))
                dao.insertTask(Task("Wash the Dishes"))
                dao.insertTask(Task("Do the Laundry"))
                dao.insertTask(Task("PrepareFood", isCompleted = true))
                dao.insertTask(Task("Call mom"))
                dao.insertTask(Task("Visit grandma", isCompleted = true))
                dao.insertTask(Task("Repair my Bike"))
                dao.insertTask(Task("Call Ambani"))
            }
        }
    }
}