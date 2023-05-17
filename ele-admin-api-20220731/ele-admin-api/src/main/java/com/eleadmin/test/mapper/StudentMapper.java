package com.eleadmin.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.test.entity.Student;
import com.eleadmin.test.param.StudentParam;
import com.eleadmin.test.service.StudentService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-03-01 22:26:37
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询所有学生信息
     */
    List<Student> findAllStudents();

    /**
     * 删除学生信息
     * @param id
     */
    void deleteStudent(int id);

    /**
     * 更新学生信息
     * @param student
     */
    void updateStudent(Student student);

    void addStudent(Student student);
}
