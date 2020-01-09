/**
 * FileName: UserController
 * Author:   10418
 * Date:     2020-01-02 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.model.User;
import com.mno.service.FactoryService;
import com.mno.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class UserController extends BaseServlet {
    private UserService userService = FactoryService.getUserService();

    public JsonResult info(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.getOneById(userId);
        Map<String, Object> info = new HashMap<>(4);
        info.put("introduction", user.getNickname());
        if (user.getRole().equals("student")) {
            info.put("avatar", "http://pic1.zhimg.com/v2-c8a9b7c1f56cdee7c6a2b3303a23bfd8_b.gif");
        } else if (user.getRole().equals("school")) {
            info.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        } else {
            info.put("avatar", "http://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20180928/478245be1df842f599ef3bfce76d734e.gif");
        }
        info.put("name", user.getUsername());
        List<String> list = new ArrayList<>();
        list.add(user.getRole());
        info.put("roles", list);
        return new JsonResult<>(info);
    }

    public JsonResult schools(HttpServletRequest req, HttpServletResponse resp) {
        List<User> school = userService.getListByRole("school");
        return new JsonResult<>(school);
    }
}
