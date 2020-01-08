package com.mno.dao.impl;

import com.mno.bean.vo.StudentChengjiVo;
import com.mno.dao.BaseDao;
import com.mno.dao.FactoryDao;
import com.mno.dao.StudentDao;
import com.mno.dao.UserDao;
import com.mno.model.Student;
import com.mno.model.User;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mao
 * @create 2020-01-03
 * @since 1.0.0
 */
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    UserDao userDao = FactoryDao.getUserDao();

    @Override
    public Student getOneById(int id) {
        Student oneData = getOneData("select * from user where id=?", id);
        return oneData;
    }

    @Override
    public Student getOneByUserId(int userid) {
        Student oneInfo = getOneData("select * from student where userId=?", userid);
        return oneInfo;
    }

    @Override
    public StudentChengjiVo chengji(int userId) {
        StudentChengjiVo vo = new StudentChengjiVo();
        String status = (String) getOneColumn("select status from voluntary where userId=?", userId);
        User user = userDao.getOneById(userId);
        vo.setNickname(user.getNickname());
        vo.setUsername(user.getUsername());
        vo.setSchoolName("无");
        vo.setSpecialityName("无");
        if (status.equals("正式录取")) {
            vo.setRemark("正式录取");
            int nowPici = (int) getOneColumn("select nowPici from voluntary where userId=?", userId);
            int specialityId = (int) getOneColumn("select speciality" + nowPici + " from voluntary where userId=?", userId);
            String specialityName = (String) getOneColumn("select name from speciality where id=?", specialityId);
            vo.setSpecialityName(specialityName);
            int schoolId = (int) getOneColumn("select userId from speciality where id=?", specialityId);
            User school = userDao.getOneById(schoolId);
            vo.setSchoolName(school.getNickname());
        } else if (status.equals("未录取")) {
            vo.setRemark("未录取");
        } else {
            vo.setRemark("未出结果");
        }
        return vo;
    }
}
