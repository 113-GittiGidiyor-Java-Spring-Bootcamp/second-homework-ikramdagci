package com.ikramdagci.secondhomework.dao;

import com.ikramdagci.secondhomework.exception.StaffNotFoundException;
import com.ikramdagci.secondhomework.model.Address;
import com.ikramdagci.secondhomework.model.Course;
import com.ikramdagci.secondhomework.model.Gender;
import com.ikramdagci.secondhomework.model.Student;
import com.ikramdagci.secondhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public class StudentDaoJpaImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Address findAddressById(Long id) {
        return findById(id).getAddress();
    }

    @Override
    public List<Student> findAll() {
        return  entityManager.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student findById(Long id) {
        Student foundStudent = null;
        try {
            foundStudent = entityManager.find(Student.class, id);
            if (foundStudent == null) {
                throw new StaffNotFoundException(id);
            }
        }catch (RuntimeException | StaffNotFoundException e) {
            e.printStackTrace();
        }
        return foundStudent;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteFromDatabase(Student student) {
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id", Student.class).setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Student update(Student student) {
       return entityManager.merge(student);
    }

    @Override
    public LocalDate findBirthDateById(Long id) {
        return  findById(id).getBirthDate();
    }

    @Override
    public Gender findGenderById(Long id) {
        return findById(id).getGender();
    }

    @Override
    public Set<Course> findCourses(Long id) {
        return findById(id).getCourses();
    }
}
