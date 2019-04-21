package io.vinter.thirdkotlintask.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.vinter.thirdkotlintask.R
import io.vinter.thirdkotlintask.entity.Student

class StudentsRecyclerAdapter(private val students: List<Student>): RecyclerView.Adapter<StudentsRecyclerAdapter.StudentsViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): StudentsViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val itemView = inflater.inflate(R.layout.item_student, viewGroup, false)
        return StudentsRecyclerAdapter.StudentsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(viewHolder: StudentsViewHolder, pos: Int) {
        viewHolder.id.text = students[pos].id.toString()
        viewHolder.fio.text = students[pos].fio
        viewHolder.date.text = students[pos].date
    }

    class StudentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById(R.id.item_id) as TextView
        val fio = itemView.findViewById(R.id.item_fio) as TextView
        val date = itemView.findViewById(R.id.item_date) as TextView
    }
}