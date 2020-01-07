package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.service.FactoryService;
import com.mno.service.SpecialityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SpecialityController extends BaseServlet {
    private SpecialityService specialityService = FactoryService.getSpecialityService();

    public JsonResult infoByUserId(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        if (userId == 0 || userId == null) {
            userId = (Integer) req.getSession().getAttribute("userId");
        }
        List list = specialityService.getListByUserId(userId);
        return new JsonResult<>(list);
    }

    public JsonResult infoById(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        List list = specialityService.getListById(id, userId);
        return new JsonResult<>(list);
    }

}
