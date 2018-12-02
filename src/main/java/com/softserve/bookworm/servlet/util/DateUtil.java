package com.softserve.bookworm.servlet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    private DateUtil() { }

    public static Date getDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            // TODO must be logged
            // TODO add custom more specific unchecked exception instead of using a general RuntimeException
            throw new RuntimeException(e);
        }
    }
}
