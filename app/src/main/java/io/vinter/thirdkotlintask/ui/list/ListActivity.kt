package io.vinter.thirdkotlintask.ui.list

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.vinter.thirdkotlintask.R
import io.vinter.thirdkotlintask.database.AppDatabase
import io.vinter.thirdkotlintask.utils.StudentsRecyclerAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val db = Room.databaseBuilder<AppDatabase>(this, AppDatabase::class.java, "studentDB")
                .allowMainThreadQueries()
                .build()

        students_recycler.layoutManager = LinearLayoutManager(this)
        students_recycler.adapter = StudentsRecyclerAdapter(db.studentDAO().students)
    }
}
