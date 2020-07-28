package com.dwarves.todoist.Utils;

import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date convertStringToDate(String dateStr, String pattern) {
        Date date = null;
        DateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(dateStr);
            if (!dateStr.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            return null;
        }
        return date;
    }
    
    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
