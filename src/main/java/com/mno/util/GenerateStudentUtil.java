/**
 * FileName: GenerateStudentUtil
 * Author:   10418
 * Date:     2020-01-08 22:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.util;

import com.mno.dao.BaseDao;
import com.mno.model.Student;
import com.mno.model.User;

import java.util.List;
import java.util.Random;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-08
 * @since 1.0.0
 */
public class GenerateStudentUtil {
    public static void main(String[] args) {
        GenerateStudent g = new GenerateStudent();
        g.gen();
    }

    static class GenerateStudent extends BaseDao<User> {
        public int gen() {
//            for (int userId = 111; userId <= 206; userId++) {
//                int match = getRandomNumber(50, 150);
//                int english = getRandomNumber(50, 150);
//                int major = getRandomNumber(150, 300);
//                int total = major + english + match;
//                iud("insert into student (mathScore,englishScore,majorScore,totalScore,userId) values(?,?,?,?,?)", match, english, major, total, userId);
//            }

            List<Student> ids = getListData(Student.class, "select id from student order by totalScore desc");
            for (int i = 1; i < ids.size(); i++) {
                iud("update student set `rank`=? where id=?", i, ids.get(i - 1).getId());
            }
            return 0;

        }

        public int getRandomNumber(int min, int max) {
            Random random = new Random();
            int result = random.nextInt(max) % (max - min + 1) + min;
            return result;
        }

    }
}
