package io.vinter.thirdkotlintask.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "student")
class Student{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "fio")
    var fio: String? = null

    @ColumnInfo(name = "date")
    var date: String? = null

    constructor(fio: String?, date: String?) {
        this.fio = fio
        this.date = date
    }
}