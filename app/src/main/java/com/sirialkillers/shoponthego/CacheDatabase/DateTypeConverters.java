package com.sirialkillers.shoponthego.CacheDatabase;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by User on 30-Nov-17.
 */

public class DateTypeConverters {
    @TypeConverter
    public static Long fromDate(Date date) {
        if (date==null) {
            return(null);
        }

        return(date.getTime());
    }

    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch==null) {
            return(null);
        }

        return(new Date(millisSinceEpoch));
    }

}
