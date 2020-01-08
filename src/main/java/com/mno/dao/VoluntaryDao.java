/**
 * FileName: VoluntaryDao
 * Author:   10418
 * Date:     2020-01-05 20:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan)
 */
package com.mno.dao;

import com.mno.bean.vo.VoluntarySchoolListVo;
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
public interface VoluntaryDao {
    Voluntary getOneByUserId(int userId);

    boolean insertOne(Voluntary voluntary);

    boolean updateOne(Voluntary voluntary);

    boolean updateStatusByUserId(int userId, String status);

    boolean updateStatusById(int id, String status);

    boolean isNext(int id);

    boolean updateNext(int id);

    int getSchoolId(int speciality, int userId);

    List<VoluntarySchoolListVo> schoolList(int userId, int i, int specialityId );
    List<VoluntarySchoolListVo> schoolYiList(int userId, int i, int specialityId );

    List<VoluntarySchoolListVo> adminList(int userId, int i, int specialityId );

    int getNowPici(int id);

    boolean updateSpeciality(int id,int specialityIndex, int specialityId);
}
