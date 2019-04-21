package io.vinter.thirdkotlintask.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.vinter.thirdkotlintask.entity.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun studentDAO(): StudentDAO
}