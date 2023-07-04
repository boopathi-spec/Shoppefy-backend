package com.productDept.productApi.Service;

import com.productDept.productApi.model.Department;
import com.productDept.productApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {


    Department addDepartment(Department department);

    List<Department> getAllDepartment();
    Department findByDeptName(String departmentName);


}
