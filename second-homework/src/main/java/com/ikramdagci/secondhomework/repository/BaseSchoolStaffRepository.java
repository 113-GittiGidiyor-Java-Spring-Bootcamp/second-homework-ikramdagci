package com.ikramdagci.secondhomework.repository;

import com.ikramdagci.secondhomework.model.Address;
import com.ikramdagci.secondhomework.model.BaseSchoolStaff;


public interface BaseSchoolStaffRepository<S extends BaseSchoolStaff> extends  CrudRepository<S>{

    Address findAddressById(Long id);

}
