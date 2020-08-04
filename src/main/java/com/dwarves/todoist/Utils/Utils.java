package com.dwarves.todoist.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public static boolean isKeyValid(Map<String, String> map, String key) {
        if (map.containsKey(key)
                && !map.get(key).isBlank()) {
            return true;
        }
        return false;
    }

    /**
     *  Used for appending sql query if the query not end by a keyword
     * @param strBuilder
     * @param appendStr
     * @param endStr
     */
    public static void appendIfNotEndBy(StringBuilder strBuilder, String appendStr, String endStr) {
        if (strBuilder.lastIndexOf(endStr) != (strBuilder.length()-endStr.length())) {
            strBuilder.append(appendStr);
        }
    }

    /**
     * Add variables to an object list and craft sql query for executing
     *
     * @param obj
     * @param map
     * @param key
     * @param sqlBuilder
     * @param appStr
     * @param strings
     * @return
     */
    public static int craftSqlQuery(List<Object> obj, Map<String, String> map, String key, StringBuilder sqlBuilder, String appStr, String... strings) {
        if (Utils.isKeyValid(map, key)) {
            if (strings.length == 2) {
                Utils.appendIfNotEndBy(sqlBuilder, strings[0], strings[1]);
            }

            sqlBuilder.append(appStr);
            if (key.contains(Constant.DATE)) {
                Date date = Utils.convertStringToDate(
                        map.get(key),
                        Constant.PATTERN);
                obj.add(date);
            } else if (key.contains(Constant.ID)) {
                obj.add(Integer.parseInt(map.get(key)));
            } else {
                obj.add(map.get(key));
            }
            return 1;
        }
        return 0;
    }
}
