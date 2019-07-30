package com.tttlive.basic.simpletimer.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author qiaoqiao
 * @DATE   2019-07-20
 */
@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "time") val time: Long,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "sleeptime") val sleepTime: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}