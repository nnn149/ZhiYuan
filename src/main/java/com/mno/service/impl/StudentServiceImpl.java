package com.mno.service.impl;

import com.mno.bean.vo.StudentChengjiVo;
import com.mno.bean.vo.StudentStuInfoVo;
import com.mno.dao.FactoryDao;
import com.mno.dao.StudentDao;
import com.mno.dao.UserDao;
import com.mno.model.Student;
import com.mno.model.User;
import com.mno.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao= FactoryDao.getStudentDao();
    UserDao userDao=FactoryDao.getUserDao();
    @Override
    public Student getOneById(int id) {
        return null;
    }

    @Override
    public StudentStuInfoVo getOneByUserId(int userid) {
        Student student=studentDao.getOneByUserId(userid);
        StudentStuInfoVo studentStuInfoVo=new StudentStuInfoVo();
        studentStuInfoVo.setId(student.getId());
        studentStuInfoVo.setMathScore(student.getMathScore());
        studentStuInfoVo.setEnglishScore(student.getEnglishScore());
        studentStuInfoVo.setMajorScore(student.getMajorScore());
        studentStuInfoVo.setTotalScore(student.getTotalScore());
        studentStuInfoVo.setRank(student.getRank());
        studentStuInfoVo.setCounter(student.getCounter());
        studentStuInfoVo.setUserId(student.getUserId());
        studentStuInfoVo.setInsertTime(student.getInsertTime());
        studentStuInfoVo.setUpdateTime(student.getUpdateTime());
        User user=userDao.getOneById(userid);
        studentStuInfoVo.setNickname(user.getNickname());
        return studentStuInfoVo;
    }

    @Override
    public StudentChengjiVo chengji(int userId) {
        return studentDao.chengji(userId);
    }

    @Override
    public List<Integer> getRenByChengji() {
        List<Integer> list = new ArrayList<>();
        for (int i = 200; i < 600; i += 25) {
            list.add(studentDao.getRenByChengji(i, i + 25));
        }
        return list;
    }

}
