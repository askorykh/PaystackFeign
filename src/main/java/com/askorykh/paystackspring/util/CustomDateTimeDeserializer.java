package com.askorykh.paystackspring.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author o.skorykh
 * @version 1.0
 */
public class CustomDateTimeDeserializer extends StdDeserializer<DateTime>
{
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    public CustomDateTimeDeserializer()
    {
        this(null);
    }


    public CustomDateTimeDeserializer(Class<DateTime> dateTimeClass)
    {
        super(dateTimeClass);
    }


    @Override
    public DateTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException
    {
        String date = parser.getText();

        return format.parseDateTime(date);
    }
}
