package com.tttlive.basic.simpletimer.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author txw
 * @DATE   2019-07-20
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getTasks(): LiveData<LiveData<Task>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getTaskForId(id: Long): LiveData<Task>

    @Query("SELECT * FROM tasks WHERE name LIKE :name ORDER BY name ASC")
    fun getTaskForName(name: String): LiveData<List<Task>>

    @Insert
    fun insertTask(task: Task): Long

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTash(task: Task)
}