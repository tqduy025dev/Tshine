package com.tshine.common.converter;

import com.tshine.common.utils.TimeUtils;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.text.ParseException;

public class StringToTimestampConverter implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(MappingContext<String, Timestamp> mappingContext) {
        try {
            String source = mappingContext.getSource();
            return TimeUtils.parseTimestamp(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
