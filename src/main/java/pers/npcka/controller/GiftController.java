package pers.npcka.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.npcka.constant.GiftIsPop;
import pers.npcka.model.Gift;
import pers.npcka.service.GiftService;
import pers.npcka.utils.DateJsonTool;
import pers.npcka.model.Page;

import java.util.List;

@Controller
public class GiftController {

    @Autowired
    private GiftService giftService;

    @RequestMapping("gift")
    public String gift() {
        return "gift";
    }

    /**
     * 获取最新的礼包列表
     *
     * @param nums 需要的数量
     * @return
     */
    @RequestMapping(value = "gift/getNewestGift", method = RequestMethod.POST)
    @ResponseBody
    public String getNewestGift(@RequestParam Integer nums) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            List<Gift> gift = giftService.getNewGift(nums);
            String result = DateJsonTool.getArrayResult(gift, "MM月dd日");
            json.put("gift", result);
        } catch (Exception e) {
            e.printStackTrace();
            msgCode = "500";
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    /**
     * 获取推广的礼包
     *
     * @return
     */
    @RequestMapping(value = "gift/getPopGift", method = RequestMethod.POST)
    @ResponseBody
    public String getPopGift() {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            List<Gift> gift = giftService.getIsPopGift(GiftIsPop.IS_POP);
            String result = JSONArray.fromObject(gift).toString();
            json.put("gift", result);
        } catch (Exception e) {
            e.printStackTrace();
            msgCode = "500";
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    /**
     * 获取所有可领取的礼包
     *
     * @param keyword     关键词搜索
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "gift/getAllGift", method = RequestMethod.POST)
    @ResponseBody
    public String getAllGift(@RequestParam String keyword, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            Page page = new Page(currentPage, pageSize);
            Page pages = page.virify(page, 1, 10);

            List<Gift> gift = giftService.getAllGift(keyword, currentPage, pageSize);

            pages.setPage(gift);

            String gifts = DateJsonTool.getObjResult(pages, "yyyy-MM-dd");
            json.put("gifts", gifts);
        } catch (Exception e) {
            e.printStackTrace();
            msgCode = "500";
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    /**
     * 获取分页数
     *
     * @param keyword
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "gift/getGiftTotalPage", method = RequestMethod.POST)
    @ResponseBody
    public String getTotalPage(@RequestParam String keyword, @RequestParam Integer pageSize) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            int count = giftService.getCurrentCount(keyword);
            int totalPage = (count + pageSize - 1) / pageSize;
            json.put("totalPage", totalPage);
        } catch (Exception e) {
            e.printStackTrace();
            msgCode = "500";
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }
}
