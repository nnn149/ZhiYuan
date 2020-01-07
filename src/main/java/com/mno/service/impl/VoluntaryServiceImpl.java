/**
 * FileName: VoluntaryServiceImpl
 * Author:   10418
 * Date:     2020-01-05 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service.impl;

import com.mno.bean.dto.VoluntarySchoolListDto;
import com.mno.bean.vo.VoluntaryListVo;
import com.mno.bean.vo.VoluntarySchoolListVo;
import com.mno.bean.vo.VoluntaryUpdateVo;
import com.mno.dao.FactoryDao;
import com.mno.dao.UserDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.User;
import com.mno.model.Voluntary;
import com.mno.service.VoluntaryService;

import java.util.ArrayList;
import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryServiceImpl implements VoluntaryService {
    VoluntaryDao voluntaryDao = FactoryDao.getVoluntaryDao();
    UserDao userDao = FactoryDao.getUserDao();

    @Override
    public VoluntaryListVo getListVoByUserId(int userId) {
        Voluntary voluntary = voluntaryDao.getOneByUserId(userId);
        if (voluntary == null) {
            voluntaryDao.insertOne(new Voluntary(userId, "未填报"));
            voluntary = voluntaryDao.getOneByUserId(userId);
        }
        VoluntaryListVo vo = new VoluntaryListVo();
        vo.setId(voluntary.getId());
        vo.setStatus(voluntary.getStatus());
        vo.setUpdateTime(voluntary.getUpdateTime());
        vo.setUserId(userId);
        User user = userDao.getOneById(userId);
        vo.setNickname(user.getNickname());
        return vo;
    }

    @Override
    public boolean update(Voluntary voluntary) {
        return voluntaryDao.updateOne(voluntary);
    }

    @Override
    public boolean submit(int userId) {
        return voluntaryDao.submit(userId);
    }

    @Override
    public VoluntaryUpdateVo getInfoByUserId(int userId) {
        Voluntary oneByUserId = voluntaryDao.getOneByUserId(userId);
        VoluntaryUpdateVo vo = new VoluntaryUpdateVo(oneByUserId);
        List<Integer> ls = new ArrayList<>();
        ls.add(voluntaryDao.getSchoolId(1, userId));
        ls.add(voluntaryDao.getSchoolId(2, userId));
        ls.add(voluntaryDao.getSchoolId(3, userId));
        ls.add(voluntaryDao.getSchoolId(4, userId));
        ls.add(voluntaryDao.getSchoolId(5, userId));
        ls.add(voluntaryDao.getSchoolId(6, userId));
        ls.add(voluntaryDao.getSchoolId(7, userId));
        ls.add(voluntaryDao.getSchoolId(8, userId));
        ls.add(voluntaryDao.getSchoolId(9, userId));
        ls.add(voluntaryDao.getSchoolId(10, userId));
        ls.add(voluntaryDao.getSchoolId(11, userId));
        ls.add(voluntaryDao.getSchoolId(12, userId));
        ls.add(voluntaryDao.getSchoolId(13, userId));
        ls.add(voluntaryDao.getSchoolId(14, userId));
        ls.add(voluntaryDao.getSchoolId(15, userId));
        ls.add(voluntaryDao.getSchoolId(16, userId));
        ls.add(voluntaryDao.getSchoolId(17, userId));
        ls.add(voluntaryDao.getSchoolId(18, userId));
        ls.add(voluntaryDao.getSchoolId(19, userId));
        ls.add(voluntaryDao.getSchoolId(20, userId));
        vo.setSchoolIds(ls);
        return vo;
    }

    @Override
    public List<VoluntarySchoolListVo> schoolList(int userId, VoluntarySchoolListDto voluntarySchoolListDto) {
        List<VoluntarySchoolListVo> list = new ArrayList<>();
//        for (int i = 1; i <= 20; i++) {
//            List<VoluntarySchoolListVo> voluntarySchoolListVos = voluntaryDao.schoolList(userId, i, voluntarySchoolListDto.getSpeciality());
//            for (VoluntarySchoolListVo voluntarySchoolListVo : voluntarySchoolListVos) {
//                if (voluntarySchoolListVo != null) {
//                    voluntarySchoolListVo.setZhiyuan("第" + i + "志愿");
//                    list.add(voluntarySchoolListVo);
//                }
//            }
//        }
        List<VoluntarySchoolListVo> voluntarySchoolListVos = voluntaryDao.schoolList(userId, voluntarySchoolListDto.getVoluntary(), voluntarySchoolListDto.getSpeciality());
        for (VoluntarySchoolListVo voluntarySchoolListVo : voluntarySchoolListVos) {
            if (voluntarySchoolListVo != null) {
                voluntarySchoolListVo.setZhiyuan("第" + voluntarySchoolListDto.getVoluntary() + "志愿");
                list.add(voluntarySchoolListVo);
            }
        }
        return list;
    }
}
