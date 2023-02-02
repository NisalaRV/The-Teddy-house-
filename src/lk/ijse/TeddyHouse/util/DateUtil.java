package lk.ijse.TeddyHouse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
