/**
 * FileName: VoluntaryController
 * Author:   10418
 * Date:     2020-01-05 20:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mno.bean.JsonResult;
import com.mno.bean.PageBean;
import com.mno.bean.ResultCode;
import com.mno.bean.dto.VoluntaryAdminListDto;
import com.mno.bean.dto.VoluntarySchoolListDto;
import com.mno.bean.vo.VoluntaryListVo;
import com.mno.bean.vo.VoluntarySchoolListVo;
import com.mno.bean.vo.VoluntaryUpdateVo;
import com.mno.service.FactoryService;
import com.mno.service.VoluntaryService;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryController extends BaseServlet {
    private VoluntaryService voluntaryService = FactoryService.getVoluntaryService();

    public JsonResult list(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        VoluntaryListVo oneByUserId = voluntaryService.getListVoByUserId(userId);
        List<VoluntaryListVo> list = new ArrayList<>();
        list.add(oneByUserId);
        return new JsonResult(new PageBean<>(1, list));
    }

    public JsonResult schoolList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = new String(req.getInputStream().readAllBytes());
        if (StringUtils.isNullOrEmpty(json)) {
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
        ObjectMapper om = new ObjectMapper();
        VoluntarySchoolListDto voluntarySchoolListDto = om.readValue(json, VoluntarySchoolListDto.class);
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        List<VoluntarySchoolListVo> voluntarySchoolListVos = voluntaryService.schoolList(userId, voluntarySchoolListDto);
        PageBean<List<VoluntarySchoolListVo>> pg = new PageBean<>(voluntarySchoolListVos.size(), voluntarySchoolListVos);
        return new JsonResult(pg);
    }

    public JsonResult adminList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = new String(req.getInputStream().readAllBytes());
        if (StringUtils.isNullOrEmpty(json)) {
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
        ObjectMapper om = new ObjectMapper();
        VoluntaryAdminListDto voluntaryAdminListDto = om.readValue(json, VoluntaryAdminListDto.class);
        List<VoluntaryAdminListDto> voluntaryAdminListVos = voluntaryService.adminList(voluntaryAdminListDto);
        PageBean<List<VoluntaryAdminListDto>> pg = new PageBean<>(voluntaryAdminListVos.size(), voluntaryAdminListVos);
        return new JsonResult(pg);
    }

    public JsonResult info(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        VoluntaryUpdateVo infoByUserId = voluntaryService.getInfoByUserId(userId);
        return new JsonResult(infoByUserId);
    }

    public JsonResult update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        String json = new String(req.getInputStream().readAllBytes());
        if (StringUtils.isNullOrEmpty(json)) {
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
        ObjectMapper om = new ObjectMapper();
        VoluntaryUpdateVo voluntary = om.readValue(json, VoluntaryUpdateVo.class);
        voluntary.setUserId(userId);
        List<Integer> schoolIds = voluntary.getSchoolIds();
        boolean isC = false;
        HashSet<Integer> hs = new HashSet<>();
        for (Integer i : schoolIds) {
            if (i == 0) {
                continue;
            }
            if (!hs.add(i)) {
                isC = true;
                break;
            }
        }
        if (isC) {
            return new JsonResult(ResultCode.ZHIYUAN_ERROR);
        }
        if (voluntaryService.update(voluntary)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.VALIDATED_ERROR);
        }

    }

    public JsonResult submit(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (voluntaryService.submit(userId)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.UNKNOWN_ERROR);
        }

    }

    public JsonResult pizhun(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (voluntaryService.pizhun(id)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.UNKNOWN_ERROR);
        }

    }

    public JsonResult reject(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (voluntaryService.reject(id)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.UNKNOWN_ERROR);
        }
    }

    public JsonResult preAdmission(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (voluntaryService.preAdmission(id)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.ZHUANYE_LESS);
        }
    }

    public JsonResult tiaoji(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer specialityId = Integer.parseInt(req.getParameter("specialityId"));
        if (voluntaryService.tiaoji(id, specialityId)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.ZHUANYE_LESS);
        }
    }
}
