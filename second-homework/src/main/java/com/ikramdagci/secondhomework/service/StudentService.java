package com.ikramdagci.secondhomework.service;

import com.ikramdagci.secondhomework.dao.data.access.definition.StudentDao;
import com.ikramdagci.secondhomework.model.Address;
import com.ikramdagci.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements BaseService<Student> {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Address findAddressById(Long id) {
        return findById(id).getAddress();
    }

    @Override
    public List<Student> findAll() {
        return  studentDao.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public Student save(Student object) {
        return studentDao.save(object);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return studentDao.update(student);
    }

}
