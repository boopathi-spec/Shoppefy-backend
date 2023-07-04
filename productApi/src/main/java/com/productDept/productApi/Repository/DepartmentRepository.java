package com.productDept.productApi.Repository;

import com.productDept.productApi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    Department findByDeptName(String departmentName);
}
