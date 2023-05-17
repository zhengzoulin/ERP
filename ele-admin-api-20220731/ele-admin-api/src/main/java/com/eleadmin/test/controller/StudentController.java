package com.eleadmin.test.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.test.service.StudentService;
import com.eleadmin.test.entity.Student;
import com.eleadmin.test.param.StudentParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-03-01 22:26:37
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/test/student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
        studentService.deleteStudent(id);
    }

    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/updateStudent")
    public ApiResult<?> updateStudent(@RequestBody Student student){
        if (studentService.updateStudent(student)){
            return success("更新成功");
        }
        return fail("更新失败");

    }
    @PreAuthorize("hasAuthority('sys:dict:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @PutMapping("/addStudent")
    public ApiResult<?> addStudent(@RequestBody Student student){
        System.out.println(student.getStudentid());
        if (studentService.addStudent(student)){
            return success("新增成功");
        }
        return fail("新增失败");

    }



}
