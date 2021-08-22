package com.ikramdagci.secondhomework.dao.data.access.definition;

import com.ikramdagci.secondhomework.model.Student;
import com.ikramdagci.secondhomework.repository.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends BaseDao<Student>, StudentRepository {
}
