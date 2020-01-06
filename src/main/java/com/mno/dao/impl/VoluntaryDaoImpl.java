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

import com.mno.dao.BaseDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.Voluntary;

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
    public boolean submit(int userId) {
        int iud = iud("update voluntary set status='已提交' where userId=?", userId);
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
}
