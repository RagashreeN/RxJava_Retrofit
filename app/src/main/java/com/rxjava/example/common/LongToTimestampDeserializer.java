package com.rxjava.example.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Timestamp;

/**
 * Created by iglulabs on 2/6/17.
 */

public class LongToTimestampDeserializer implements JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        Long timestampLong = element.getAsLong();
        return new Timestamp(timestampLong);
    }
}
