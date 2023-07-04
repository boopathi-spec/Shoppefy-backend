package com.productDept.productApi.Serviceimpl;

import com.productDept.productApi.Repository.DepartmentRepository;
import com.productDept.productApi.Repository.ProductRepository;
import com.productDept.productApi.Service.DeptService;
import com.productDept.productApi.model.Department;
import com.productDept.productApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {
    @Autowired
   DepartmentRepository departmentRepository;







   @Override
    public Department findByDeptName(String departmentName) {
        return  departmentRepository.findByDeptName(departmentName);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartment(){

        return departmentRepository.findAll();
    }


}
