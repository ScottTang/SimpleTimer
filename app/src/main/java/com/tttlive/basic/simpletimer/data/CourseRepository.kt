package com.tttlive.basic.simpletimer.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * @author txw
 * @DATE   2019-07-20
 */
class CourseRepository private constructor(
    private val courseDao: CourseDao
) {
    suspend fun createCourse(name: String, content: String) {
        withContext(IO) {
            val course = Course(name, content)
            courseDao.insertCourse(course)
        }
    }

    suspend fun removeCourse(course: Course) {
        withContext(IO) {
            courseDao.deleteCourse(course)
        }
    }

    suspend fun updateCourse(course: Course) {
        withContext(IO) {
            courseDao.updateCourse(course)
        }
    }

    fun getCourses() = courseDao.getCourses()

    companion object {
        @Volatile
        private var instance: CourseRepository? = null

        fun getInstance(courseDao: CourseDao) =
            instance ?: synchronized(this) {
                instance ?: CourseRepository(courseDao).also { instance = it }
            }
    }
}