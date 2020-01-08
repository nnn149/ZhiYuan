package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.SpecialityDao;
import com.mno.model.Speciality;

import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mao
 * @create 2020-01-03
 * @since 1.0.0
 */
public class SpecialityDaoImpl extends BaseDao<Speciality> implements SpecialityDao {
    @Override
    public List<Speciality> getListByUserId(Integer userId) {
        List<Speciality> listData = getListData("select * from speciality where userId=?", userId);
        return listData;
    }

    @Override
    public List<Speciality> getListById(Integer id, Integer userId) {
        List<Speciality> listData;
        if (id == 0) {
            listData = getListData("select * from speciality");
        } else {
            listData = getListData("select * from speciality where id=? and userId=?", id, userId);
        }
        return listData;
    }

    @Override
    public boolean lessTotal(int id) {
        int total = (int) getOneColumn("select total from speciality where id=?", id);
        if (total <= 0) {
            return false;
        } else {
            int iud = iud("update speciality set total=total-1 where id=?", id);
            if (iud > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public int insertOne(Speciality speciality) {

        return iud("insert into speciality(userId,name,total) values(?,?,?)", speciality.getUserId()
                , speciality.getName(), speciality.getTotal()
        );
    }

    @Override
    public boolean deleteById(int id) {
        int iud = iud("delete  from speciality where id=?", id);
        boolean b = iud > 0 ? true : false;
        return b;
    }

    @Override
    public boolean updateOne(Speciality speciality) {
        int iud = iud("update speciality set name=? ,total=? where id=?", speciality.getName(), speciality.getTotal(), speciality.getId());
        boolean b = iud > 0 ? true : false;
        return b;
    }


    public static void main(String[] args) {

    }

}
