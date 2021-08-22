package com.ikramdagci.secondhomework.dao;

import com.ikramdagci.secondhomework.dao.data.access.definition.InstructorDao;
import com.ikramdagci.secondhomework.model.Address;
import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.model.Instructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InstructorDaoJpaImpl implements InstructorDao {

    private final EntityManager entityManager;

    public InstructorDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("select i from Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(Long id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Instructor i WHERE i.id = :id", Instructor.class).setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    public Address findAddressById(Long id) {
        return entityManager.find(Address.class,id);
    }

    @Override
    public Set<Course> findInstructedCourses(Long instructorId) {
        return entityManager.createQuery("select c from Course c where course_instructor_id = :course_instructor_id",Course.class).getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public String findPhoneNumberById(Long instructorId) {
        return entityManager.find(Instructor.class,instructorId).getPhoneNumber();
    }
}
