package pers.npcka.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Last7DayTool {
    public static List<String> get7Day() {
        List<String> list = new ArrayList<>();
        for (int i = -3; i < 4; i++) {
            list.add(getPastDay(i));
        }
        return list;
    }

    public static String getPastDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        return sdf.format(calendar.getTime());
    }

}
