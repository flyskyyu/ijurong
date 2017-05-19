package com.party.ijurong.pojo;

/**
 * Created by yu on 2017/5/20.
 */
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化Bean的Date字段
 *
 * @author yuqin
 *
 */
public class DateSerializer extends JsonSerializer<Date>
{
    @Override
    public void serialize(Date value, JsonGenerator generator, SerializerProvider sp) throws IOException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(value);
        generator.writeString(formattedDate);
    }
}
