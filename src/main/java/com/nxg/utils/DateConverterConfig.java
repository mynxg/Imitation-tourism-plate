package com.nxg.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author nxg
 * @apiNote 日期转换器
 */
@Component
public class DateConverterConfig implements Converter<String, Date> {
    private static final List<String> formarts2 = new ArrayList<>(4);
    static{
        formarts2.add("yyyy-MM");
        formarts2.add("yyyy-MM-dd");
        formarts2.add("yyyy-MM-dd hh:mm");
        formarts2.add("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        if(source.matches("^\\d{4}-\\d{1,2}$")){
            return parseDate(source, formarts2.get(0));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            return parseDate(source, formarts2.get(1));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts2.get(2));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts2.get(3));
        }else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }
    /**
     * 格式化日期
     * @param dateStr String 字符型日期
     * @param format String 格式
     * @return Date 日期
     */
    public Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

}
