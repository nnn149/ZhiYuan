/**
 * FileName: VoluntarySchoolListDto
 * Author:   10418
 * Date:     2020-01-07 9:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.bean.dto;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-07
 * @since 1.0.0
 */
public class VoluntarySchoolListDto {
    private LimitDto limit;
    private int speciality;
    private int voluntary;

    public int getVoluntary() {
        return voluntary;
    }

    public void setVoluntary(int voluntary) {
        this.voluntary = voluntary;
    }


    public VoluntarySchoolListDto() {
    }

    public LimitDto getLimit() {
        return limit;
    }

    public void setLimit(LimitDto limit) {
        this.limit = limit;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }
}
