/**
 * FileName: VoluntaryService
 * Author:   10418
 * Date:     2020-01-05 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service;

import com.mno.bean.dto.VoluntaryAdminListDto;
import com.mno.bean.dto.VoluntarySchoolListDto;
import com.mno.bean.vo.VoluntaryListVo;
import com.mno.bean.vo.VoluntarySchoolListVo;
import com.mno.bean.vo.VoluntaryUpdateVo;
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
public interface VoluntaryService {
    VoluntaryListVo getListVoByUserId(int userId);

    boolean update(Voluntary voluntary);

    boolean submit(int userId);

    boolean reject(int id);
    boolean pizhun(int id);
    VoluntaryUpdateVo getInfoByUserId(int userId);

    List<VoluntarySchoolListVo> schoolList(int userId, VoluntarySchoolListDto voluntarySchoolListDto);
    List<VoluntaryAdminListDto> adminList( VoluntaryAdminListDto voluntaryAdminListDto);

    boolean preAdmission(int id);

    boolean tiaoji(int id, int specialityId);

}
