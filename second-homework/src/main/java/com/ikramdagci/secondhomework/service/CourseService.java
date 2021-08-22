package com.ikramdagci.secondhomework.service;

import com.ikramdagci.secondhomework.dao.data.access.definition.CourseDao;
import com.ikramdagci.secondhomework.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseDao.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseDao.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return courseDao.update(course);
    }
}
