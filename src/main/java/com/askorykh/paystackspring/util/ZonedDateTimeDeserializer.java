package com.askorykh.paystackspring.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author o.skorykh
 * @version 1.0
 */
public class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime>
{
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");


    public ZonedDateTimeDeserializer()
    {
        this(null);
    }


    public ZonedDateTimeDeserializer(Class<ZonedDateTime> dateTimeClass)
    {
        super(dateTimeClass);
    }


    @Override
    public ZonedDateTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException
    {
        String date = parser.getText();

        return ZonedDateTime.parse(date, format);
    }
}
