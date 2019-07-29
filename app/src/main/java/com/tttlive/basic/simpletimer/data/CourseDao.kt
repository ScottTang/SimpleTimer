package com.tttlive.basic.simpletimer.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author txw
 * @DATE   2019-07-20
 */
@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getCourses(): LiveData<List<Course>>

    @Query("SELECT * FROM courses WHERE id = :id")
    fun getCourseForId(id: Long): LiveData<Course>

    @Insert
    fun insertCourse(course: Course): Long

    @Delete
    fun deleteCourse(course: Course)

    @Update
    fun updateCourse(course: Course)
}