package com.eleadmin.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.test.entity.Student;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-03-01 21:28:30
 */
public interface StudentService extends IService<Student> {

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> findAllStudents();

    /**
     * 删除学生
     * @param id
     * @return
     */
    public void deleteStudent(int id);

    /**
     * 更新学生信息
     * @param student
     */
    boolean updateStudent(Student student);

    boolean addStudent(Student student);
}
