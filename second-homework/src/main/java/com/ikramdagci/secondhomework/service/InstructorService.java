package com.ikramdagci.secondhomework.service;


import com.ikramdagci.secondhomework.dao.InstructorDao;
import com.ikramdagci.secondhomework.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {

    private final InstructorDao instructorDao;

    public InstructorService(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDao.findAll();
    }

    @Override
    public Instructor findById(Long id) {
        return instructorDao.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorDao.save(instructor);
    }

    @Override
    public void deleteById(Long id) {
        instructorDao.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorDao.update(instructor);
    }
}
