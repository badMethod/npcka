package pers.npcka.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.npcka.model.Guide;
import pers.npcka.service.GuideService;
import pers.npcka.utils.DateJsonValueProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class GuideController {

    @Autowired
    private GuideService guideService;

    @RequestMapping("news")
    public String news() {
        return "news";
    }

    @RequestMapping("guide")
    public String guide() {
        return "guide";
    }

    /**
     * 同时接受两种url和两种请求，get请求实现页面初始加载，post请求实现分页功能
     *
     * @param request
     * @param currentPage 当前页面
     * @param pageSize    页面显示信息条数
     * @return
     */
    @RequestMapping(value = {"getNews", "getGuide"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getNewsAndGuide(HttpServletRequest request, Integer currentPage, Integer pageSize) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        if (currentPage == null || currentPage <= 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 5;
        }
        try {
            String uri = request.getRequestURI();
            List<Guide> page = null;
            if (uri.contains("/getNews")) {
                page = guideService.getNewsListByPage(currentPage, pageSize);
            } else if (uri.contains("/getGuide")) {
                page = guideService.getGuideListByPage(currentPage, pageSize);
            }
            // 格式化Json中时间为字符串
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm"));
            String pageList = JSONArray.fromObject(page, jsonConfig).toString();
            json.put("page", pageList);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        json.put("currentPage", currentPage);
        json.put("pageSize", pageSize);
        return json.toString();
    }


    @RequestMapping(value = {"/news/{id}", "/guide/{id}"})
    public String newDetail(HttpServletRequest request, @PathVariable Integer id) {
        request.setAttribute("id", id);
        String uri = request.getRequestURI();
        int type = 1;
        if (uri.contains("news")) {
            type = 1;
        } else if (uri.contains("guide")) {
            type = 2;
        }
        request.setAttribute("type", type);
        return "news-detail";
    }

    /**
     * 获取文章详细信息
     *
     * @param id 文章id
     * @return
     */
    @RequestMapping(value = {"news/getNews","guide/getNews"}, method = RequestMethod.POST)
    @ResponseBody
    public String getNewsAndGuideDetail(@RequestParam Integer id, @RequestParam Integer type) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        Guide guide = null;
        try {
            guide = guideService.getGuideDetail(id);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy年MM月dd日"));
            String guides = JSONObject.fromObject(guide, jsonConfig).toString();
            json.put("guide", guides);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }
}
