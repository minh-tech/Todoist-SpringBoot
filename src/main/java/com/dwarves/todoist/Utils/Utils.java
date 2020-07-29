package com.dwarves.todoist.Utils;

import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public static boolean isIdValid(int id) {
        // Id in Postgresql starts from 1
        if (id <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isIdExisted(List<Integer> idList, int id) {
        if (Collections.binarySearch(idList, id) < 0){
            return false;
        }
        return true;
    }
}
