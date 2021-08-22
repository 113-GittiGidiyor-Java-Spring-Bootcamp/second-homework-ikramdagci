package com.ikramdagci.secondhomework.repository;


import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.model.Gender;
import com.ikramdagci.secondhomework.model.Student;

import java.time.LocalDate;
import java.util.Set;

public interface StudentRepository extends BaseSchoolStaffRepository<Student> {

    LocalDate findBirthDateById(Long id);
    Gender findGenderById(Long id);
    Set<Course> findCourses(Long id);

}
