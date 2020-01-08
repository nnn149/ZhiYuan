/**
 * FileName: VoluntaryDaoImpl
 * Author:   10418
 * Date:     2020-01-05 20:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.dao.impl;

import com.mno.bean.vo.VoluntarySchoolListVo;
import com.mno.dao.BaseDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.Voluntary;

import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryDaoImpl extends BaseDao<Voluntary> implements VoluntaryDao {
    @Override
    public Voluntary getOneByUserId(int userId) {
        Voluntary oneData = getOneData("select * from voluntary where userId=?", userId);
        return oneData;

    }

    @Override
    public boolean insertOne(Voluntary voluntary) {
        int iud = iud("insert into voluntary(userId,status) values(?,?)", voluntary.getUserId(), voluntary.getStatus());
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateOne(Voluntary voluntary) {
        int iud = iud("update voluntary set status=?,speciality1=?,speciality2=?,speciality3=?,speciality4=?,speciality5=?,speciality6=?,speciality7=?,speciality8=?,speciality9=?,speciality10=?,speciality11=?,speciality12=?,speciality13=?,speciality14=?,speciality15=?,speciality16=?,speciality17=?,speciality18=?,speciality19=?,speciality20=?,tiaoji1=?,tiaoji2=?,tiaoji3=?,tiaoji4=?,tiaoji5=?,tiaoji6=?,tiaoji7=?,tiaoji8=?,tiaoji9=?,tiaoji10=?,tiaoji11=?,tiaoji12=?,tiaoji13=?,tiaoji14=?,tiaoji15=?,tiaoji16=?,tiaoji17=?,tiaoji18=?,tiaoji19=?,tiaoji20=? where userId=?",
                "已填报", voluntary.getSpeciality1(), voluntary.getSpeciality2(), voluntary.getSpeciality3(), voluntary.getSpeciality4(), voluntary.getSpeciality5(), voluntary.getSpeciality6(), voluntary.getSpeciality7(), voluntary.getSpeciality8(), voluntary.getSpeciality9(), voluntary.getSpeciality10(), voluntary.getSpeciality11(), voluntary.getSpeciality12(), voluntary.getSpeciality13(), voluntary.getSpeciality14(), voluntary.getSpeciality15(), voluntary.getSpeciality16(), voluntary.getSpeciality17(), voluntary.getSpeciality18(), voluntary.getSpeciality19(), voluntary.getSpeciality20(), voluntary.isTiaoji1(), voluntary.isTiaoji2(), voluntary.isTiaoji3(), voluntary.isTiaoji4(), voluntary.isTiaoji5(), voluntary.isTiaoji6(), voluntary.isTiaoji7(), voluntary.isTiaoji8(), voluntary.isTiaoji9(), voluntary.isTiaoji10(), voluntary.isTiaoji11(), voluntary.isTiaoji12(), voluntary.isTiaoji13(), voluntary.isTiaoji14(), voluntary.isTiaoji15(), voluntary.isTiaoji16(), voluntary.isTiaoji17(), voluntary.isTiaoji18(), voluntary.isTiaoji19(), voluntary.isTiaoji20(), voluntary.getUserId());
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStatusByUserId(int userId, String status) {
        int iud = iud("update voluntary set status=? where userId=?", status, userId);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStatusById(int id, String status) {
        int iud = iud("update voluntary set status=? where id=?", status, id);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isNext(int id) {
        int nowPici = (int) getOneColumn("select nowPici from voluntary where id=?", id);
        if (nowPici > 20) {
            return false;
        } else {
            nowPici++;
        }
        int speciality = (int) getOneColumn("select speciality" + nowPici + " from voluntary where id=?", id);
        if (speciality == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updateNext(int id) {
        int iud = iud("update voluntary set nowPici=nowPici+1 where id=?", id);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSchoolId(int speciality, int userId) {
        int oneColumn = (int) getOneColumn("select speciality.userId from speciality,voluntary where voluntary.speciality" + speciality + " = speciality.id and voluntary.userId=?", userId);
        return oneColumn;
    }

    @Override
    public List<VoluntarySchoolListVo> schoolList(int userId, int i, int specialityId) {
        String sql = "SELECT \n" +
                "voluntary.tiaoji" + i + " AS tiaoji,voluntary.id AS id,user.nickname AS nickname,user.username AS username,user.remark AS remark,student.mathScore AS mathScore,student.englishScore AS englishScore,student.majorScore AS majorScore,student.totalScore AS totalScore,student.rank AS `rank`,speciality.name AS speciality\n" +
                "FROM user,voluntary,student,speciality\n" +
                "WHERE \n" +
                "voluntary.userId=user.id\n" +
                "AND \n" +
                "voluntary.userId=student.userId\n" +
                "AND\n" +
                "voluntary.speciality" + i + " IN (SELECT speciality.id FROM speciality WHERE speciality.userId=" + userId + ")\n" +
                "AND\n" +
                "voluntary.speciality" + i + "=speciality.id AND voluntary.nowPici=" + i + " " + (specialityId == 0 ? "" : "AND speciality.id=" + specialityId) + " AND voluntary.status='已提交'\n" +
                "\n ORDER BY student.rank,student.mathScore DESC";
        List<VoluntarySchoolListVo> listData = getListData(VoluntarySchoolListVo.class, sql);
        return listData;
    }

    @Override
    public List<VoluntarySchoolListVo> adminList(int userId, int i, int specialityId) {
        String sql = "SELECT \n" +
                "voluntary.tiaoji" + i + " AS tiaoji,voluntary.id AS id,user.nickname AS nickname,user.username AS username,user.remark AS remark,student.mathScore AS mathScore,student.englishScore AS englishScore,student.majorScore AS majorScore,student.totalScore AS totalScore,student.rank AS `rank`,speciality.name AS speciality\n" +
                "FROM user,voluntary,student,speciality\n" +
                "WHERE \n" +
                "voluntary.userId=user.id\n" +
                "AND \n" +
                "voluntary.userId=student.userId\n" +
                "AND\n" +
                "voluntary.speciality" + i + " IN (SELECT speciality.id FROM speciality WHERE speciality.userId=" + userId + ")\n" +
                "AND\n" +
                "voluntary.speciality" + i + "=speciality.id AND voluntary.nowPici=" + i + " " + (specialityId == 0 ? "" : "AND speciality.id=" + specialityId) + "  AND (voluntary.status='预录取' or voluntary.status='调剂') \n" +
                "\n ORDER BY student.rank,student.mathScore DESC";

        List<VoluntarySchoolListVo> listData = getListData(VoluntarySchoolListVo.class, sql);
        return listData;
    }

    @Override
    public int getNowPici(int id) {
        int nowPici = (int) getOneColumn("select nowPici from voluntary where id=?", id);
        return nowPici;
    }

    @Override
    public boolean updateSpeciality(int id, int specialityIndex, int specialityId) {
        int iud = iud("update voluntary set speciality" + specialityIndex + "=? where id=?", specialityId, id);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }
}
