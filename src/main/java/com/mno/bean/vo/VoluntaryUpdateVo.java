/**
 * FileName: VoluntaryUpdateVo
 * Author:   10418
 * Date:     2020-01-06 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.bean.vo;

import com.mno.model.Voluntary;

import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-06
 * @since 1.0.0
 */
public class VoluntaryUpdateVo extends Voluntary {
    private List<Integer> schoolIds;

    public VoluntaryUpdateVo() {
    }

    public VoluntaryUpdateVo(Voluntary voluntary) {
        this.setId(voluntary.getId());
        this.setUserId(voluntary.getUserId());
        this.setStatus(voluntary.getStatus());
        this.setUpdateTime(voluntary.getUpdateTime());

        this.setSpeciality1(voluntary.getSpeciality1());
        this.setTiaoji1(voluntary.isTiaoji1());
        this.setSpeciality2(voluntary.getSpeciality2());
        this.setTiaoji2(voluntary.isTiaoji2());
        this.setSpeciality3(voluntary.getSpeciality3());
        this.setTiaoji3(voluntary.isTiaoji3());
        this.setSpeciality4(voluntary.getSpeciality4());
        this.setTiaoji4(voluntary.isTiaoji4());
        this.setSpeciality5(voluntary.getSpeciality5());
        this.setTiaoji5(voluntary.isTiaoji5());
        this.setSpeciality6(voluntary.getSpeciality6());
        this.setTiaoji6(voluntary.isTiaoji6());
        this.setSpeciality7(voluntary.getSpeciality7());
        this.setTiaoji7(voluntary.isTiaoji7());
        this.setSpeciality8(voluntary.getSpeciality8());
        this.setTiaoji8(voluntary.isTiaoji8());
        this.setSpeciality9(voluntary.getSpeciality9());
        this.setTiaoji9(voluntary.isTiaoji9());
        this.setSpeciality10(voluntary.getSpeciality10());
        this.setTiaoji10(voluntary.isTiaoji10());
        this.setSpeciality11(voluntary.getSpeciality11());
        this.setTiaoji11(voluntary.isTiaoji11());
        this.setSpeciality12(voluntary.getSpeciality12());
        this.setTiaoji12(voluntary.isTiaoji12());
        this.setSpeciality13(voluntary.getSpeciality13());
        this.setTiaoji13(voluntary.isTiaoji13());
        this.setSpeciality14(voluntary.getSpeciality14());
        this.setTiaoji14(voluntary.isTiaoji14());
        this.setSpeciality15(voluntary.getSpeciality15());
        this.setTiaoji15(voluntary.isTiaoji15());
        this.setSpeciality16(voluntary.getSpeciality16());
        this.setTiaoji16(voluntary.isTiaoji16());
        this.setSpeciality17(voluntary.getSpeciality17());
        this.setTiaoji17(voluntary.isTiaoji17());
        this.setSpeciality18(voluntary.getSpeciality18());
        this.setTiaoji18(voluntary.isTiaoji18());
        this.setSpeciality19(voluntary.getSpeciality19());
        this.setTiaoji19(voluntary.isTiaoji19());
        this.setSpeciality20(voluntary.getSpeciality20());
        this.setTiaoji20(voluntary.isTiaoji20());

    }

    public List<Integer> getSchoolIds() {
        return schoolIds;
    }

    public void setSchoolIds(List<Integer> schoolIds) {
        this.schoolIds = schoolIds;
    }
}
