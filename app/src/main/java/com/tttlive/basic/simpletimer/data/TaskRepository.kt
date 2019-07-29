package com.tttlive.basic.simpletimer.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * @author txw
 * @DATE   2019-07-20
 */
class TaskRepository private constructor(
    private val taskDao: TaskDao
) {
    suspend fun createTask(name: String, time: Long, count: Int, sleepTime: Long) {
        withContext(IO) {
            val task = Task(name, time, count, sleepTime)
            taskDao.insertTask(task)
        }
    }

    suspend fun removeTask(task: Task) {
        withContext(IO) {
            taskDao.deleteTask(task)
        }
    }

    suspend fun updateTask(task: Task) {
        withContext(IO) {
            taskDao.updateTash(task)
        }
    }

    fun getTasks() = taskDao.getTasks()

    fun getTaskForId(id: Long) {
        taskDao.getTaskForId(id)
    }

    fun getTaskForName(name: String) {
        taskDao.getTaskForName(name)
    }

    companion object {
        @Volatile
        private var instance: TaskRepository? = null

        fun getInstance(taskDao: TaskDao) =
            instance ?: synchronized(this) {
                instance ?: TaskRepository(taskDao).also { instance = it }
            }
    }
}