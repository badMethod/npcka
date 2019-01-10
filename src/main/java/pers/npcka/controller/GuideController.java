package pers.npcka.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.npcka.model.Guide;
import pers.npcka.service.GuideService;
import pers.npcka.utils.DateJsonTool;
import pers.npcka.model.Page;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = {"getNewsTotalPage", "getGuideTotalPage"}, method = RequestMethod.POST)
    @ResponseBody
    public String getTotalPage(HttpServletRequest request, @RequestParam Integer pageSize, @RequestParam String keyword) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            int count = 0;
            String uri = request.getRequestURI();
            if (uri.contains("/getNewsTotalPage")) {
                count = guideService.getNewsCount(keyword);
            } else if (uri.contains("/getGuideTotalPage")) {
                count = guideService.getGuideCount(keyword);
            }
            int totalPage = (count + pageSize - 1) / pageSize;  // （数据总数 + 页面大小 -1）/ 页面大小 = 总页数(int)
            json.put("totalPage", totalPage);
        } catch (Exception e) {
            e.printStackTrace();
            msgCode = "500";
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    /**
     * 同时接受两种url和两种请求，get请求实现页面初始加载，post请求实现分页功能
     *
     * @param request
     * @param currentPage 当前页面
     * @param pageSize    页面显示信息条数
     * @return
     */
    @RequestMapping(value = {"getNews", "getGuide"}, method = RequestMethod.POST)
    @ResponseBody
    public String getNewsAndGuide(HttpServletRequest request, @RequestParam Integer currentPage, @RequestParam Integer pageSize, @RequestParam String keyword) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            Page page = new Page(currentPage, pageSize);
            Page pages = page.virify(page, 1, 10);


            String uri = request.getRequestURI();
            List<Guide> guide = null;
            if (uri.contains("/getNews")) {
                guide = guideService.getNewsListByPage(currentPage, pageSize, keyword);
            } else if (uri.contains("/getGuide")) {
                guide = guideService.getGuideListByPage(currentPage, pageSize, keyword);
            }

            pages.setPage(guide);

            String pageList = DateJsonTool.getObjResult(pages, "yyyy-MM-dd hh:mm");

            json.put("result", pageList);

        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }


    @RequestMapping(value = {"/news/{id}", "/guide/{id}"})
    public String newDetail(HttpServletRequest request, @PathVariable Integer id) {
        request.setAttribute("id", id);
        return "news-detail";
    }

    /**
     * 获取文章详细信息
     *
     * @param id 文章id
     * @return
     */
    @RequestMapping(value = {"news/getNews", "guide/getNews"}, method = RequestMethod.POST)
    @ResponseBody
    public String getNewsAndGuideDetail(@RequestParam Integer id) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            Guide guide = guideService.getGuideDetail(id);
            String guides = DateJsonTool.getObjResult(guide, "yyyy年MM月dd日");
            json.put("guide", guides);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }
}
