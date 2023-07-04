package com.productDept.productApi.Controller;

import com.productDept.productApi.Service.DeptService;
import com.productDept.productApi.model.Department;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api/department")
public class DeptController {
    public DeptController() {
    }

    @Autowired
    DeptService deptServe;

    @GetMapping("/findProduct")
   public List<Department> findalldept(){
       List<Department> deptlist = new ArrayList<>();

       deptlist = deptServe.getAllDepartment();
       return deptlist;
   }


}
