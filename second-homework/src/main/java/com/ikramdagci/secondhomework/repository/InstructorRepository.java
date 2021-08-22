package com.ikramdagci.secondhomework.repository;


import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.model.Instructor;

import java.util.Set;

public interface InstructorRepository extends BaseSchoolStaffRepository<Instructor> {

    Set<Course> findInstructedCourses(Long instructorId);
    String findPhoneNumberById(Long instructorId);


}
