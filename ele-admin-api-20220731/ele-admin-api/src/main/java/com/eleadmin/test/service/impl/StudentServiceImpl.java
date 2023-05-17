package com.eleadmin.test.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.test.mapper.StudentMapper;
import com.eleadmin.test.service.StudentService;
import com.eleadmin.test.entity.Student;
import com.eleadmin.test.param.StudentParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-03-01 22:26:37
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        studentMapper.updateStudent(student);
        System.out.println(student.getName());
        return true;
    }

    @Override
    public boolean addStudent(Student student) {
        System.out.println(student.getName());
        studentMapper.addStudent(student);
        return true;
    }

}
