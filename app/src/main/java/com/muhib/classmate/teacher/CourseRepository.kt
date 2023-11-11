package com.muhib.classmate.teacher

class CourseRepository {
    fun getAllCourse(): List<Course> {
        return listOf(
            Course(code = "CSE 250", title = "Android Project", time = "8: 00 am", place = "Lab 303", status = "Active"),
            Course(code = "CSE 251", title = "Android Project", time = "8: 00 am", place = "Lab 303", status = "Active"),
            Course(code = "CSE 252", title = "Android Project", time = "8: 00 am", place = "Lab 303", status = "Active"),
            Course(code = "CSE 253", title = "Android Project", time = "8: 00 am", place = "Lab 303", status = "Active"),
        )
    }
}