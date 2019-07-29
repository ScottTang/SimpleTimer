package com.tttlive.basic.simpletimer.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author txw
 * @DATE   2019-07-20
 */
@Entity(tableName = "courses")
data class Course(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "content") val content: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val courseId: Long = 0
}