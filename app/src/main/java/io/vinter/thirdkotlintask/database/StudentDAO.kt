package io.vinter.thirdkotlintask.database

import android.arch.persistence.room.*
import io.vinter.thirdkotlintask.entity.Student

@Dao
interface StudentDAO {
    @get:Query("SELECT * FROM student")
    val students: List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg students: Student)

    @Delete
    fun delete(student: Student)

    @Update
    fun update(student: Student)

    @Query("DELETE FROM student")
    fun nukeTable()

    @Query("SELECT * FROM student WHERE ID = (SELECT MAX(id) FROM student)")
    fun getLastRecord(): Student
}