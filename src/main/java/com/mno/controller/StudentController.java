package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.bean.vo.StudentStuInfoVo;
import com.mno.service.FactoryService;
import com.mno.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class StudentController extends BaseServlet {
    StudentService studentService= FactoryService.getStudentService();
    public JsonResult stuInfo(HttpServletRequest req, HttpServletResponse resp){
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        StudentStuInfoVo student=studentService.getOneByUserId(userId);
        List<StudentStuInfoVo> list = new ArrayList<>();
        list.add(student);
        return new JsonResult(list);
    }

}
