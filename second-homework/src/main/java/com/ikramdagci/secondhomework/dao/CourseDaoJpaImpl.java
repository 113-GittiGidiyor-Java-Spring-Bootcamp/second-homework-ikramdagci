package com.ikramdagci.secondhomework.dao;

import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.model.Instructor;
import com.ikramdagci.secondhomework.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CourseDaoJpaImpl implements CourseDao {

    private EntityManager entityManager;

    public CourseDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return  entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Course c WHERE c.id = :id", Course.class).setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Course course) {
        entityManager.remove(course);
    }

    @Override
    public Course update(Course course) {
        return entityManager.merge(course);
    }
}
