package pers.npcka.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.npcka.model.GameServer;
import pers.npcka.service.ServerService;
import pers.npcka.utils.DateJsonTool;
import pers.npcka.utils.Last7DayTool;

import java.util.List;

@Controller
public class ServerController {

    @Autowired
    private ServerService serverService;

    @RequestMapping("server")
    public String server() {
        return "server";
    }

    @RequestMapping("server/getDay")
    @ResponseBody
    public String getRencentDate() {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            List<String> dayList = Last7DayTool.get7Day();
            json.put("today", dayList.get(3));
            JSONArray result = JSONArray.fromObject(dayList);
            json.put("dayList", result);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }

    @RequestMapping(value = "server/getServerByDate", method = RequestMethod.POST)
    @ResponseBody
    public String getServerByDate(@RequestParam String date) {
        JSONObject json = new JSONObject();
        String msgCode = "200";
        try {
            List<GameServer> list = serverService.getServerByDate(date);
            String result = DateJsonTool.getArrayResult(list, "MM-dd HH:mm");
            json.put("result", result);
        } catch (Exception e) {
            msgCode = "500";
            e.printStackTrace();
        }
        json.put("msgCode", msgCode);
        return json.toString();
    }
}
