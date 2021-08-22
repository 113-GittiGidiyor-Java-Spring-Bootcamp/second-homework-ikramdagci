package com.ikramdagci.secondhomework.repository;

import com.ikramdg.model.Course;
import com.ikramdg.model.Instructor;

import java.util.Set;

public interface InstructorRepository extends com.ikramdg.repository.BaseSchoolStaffRepository<Instructor> {

    Set<Course> findInstructedCourses(Long instructorId);
    String findPhoneNumberById(Long instructorId);


}
