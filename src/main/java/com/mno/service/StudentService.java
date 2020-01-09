package com.mno.service;

import com.mno.bean.vo.StudentChengjiVo;
import com.mno.bean.vo.StudentStuInfoVo;
import com.mno.model.Student;

import java.util.List;

public interface StudentService {
    Student getOneById(int id);

    StudentStuInfoVo getOneByUserId(int userid);

    StudentChengjiVo chengji(int userId);
    List<Integer> getRenByChengji();
}
