package projectmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String convert(String dateString,String from,String to){
        try{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(from);
            Date  date=simpleDateFormat.parse(dateString);
            simpleDateFormat=new SimpleDateFormat(to);
            return simpleDateFormat.format(date);
        }catch (Exception e){
            System.out.println(e.toString());
            return "";
        }
    }
}
