package pers.npcka.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;

public class DateJsonTool {

    public static String getObjResult(Object obj, String pattern){
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(pattern));
        return JSONObject.fromObject(obj,config).toString();
    }

    public static String getArrayResult(Object obj, String pattern){
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(pattern));
        return JSONArray.fromObject(obj,config).toString();
    }
}
