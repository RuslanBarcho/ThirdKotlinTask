package io.vinter.thirdkotlintask.ui.main

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.vinter.thirdkotlintask.R
import io.vinter.thirdkotlintask.database.AppDatabase
import io.vinter.thirdkotlintask.entity.Student
import io.vinter.thirdkotlintask.ui.list.ListActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder<AppDatabase>(this, AppDatabase::class.java, "studentDB")
                .allowMainThreadQueries()
                .build()
        db.studentDAO().nukeTable()

        for (i in 1..5){
            db.studentDAO().insertAll(Student(resources.getStringArray(R.array.students).random(), getDate()))
        }
        view_data.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        edit_last.setOnClickListener {
            val student = db.studentDAO().getLastRecord()
            student.fio = "Иванов Иван Иванович"
            db.studentDAO().update(student)
        }
        add_record.setOnClickListener {
            db.studentDAO().insertAll(Student(resources.getStringArray(R.array.students).random(), getDate()))
        }

    }

    private fun getDate(): String{
        val dateFormatter = SimpleDateFormat("hh:mm:ss")
        dateFormatter.isLenient = false
        val today = Date()
        return dateFormatter.format(today)
    }
}
