package com.newegg.pr.base.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author vic
 * @date 8/4/2021 6:15 PM
 */
public class JsonUtil {

    private JsonUtil() {}

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // to prevent exception when encountering unknown property:
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // JsonParser.Feature for configuring parsing settings:
        // to allow C/C++ style comments in JSON (non-standard, disabled by default)
        // (note: with Jackson 2.5, there is also `mapper.enable(feature)` / `mapper.disable(feature)`)
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // to allow (non-standard) unquoted field names in JSON:
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // to allow use of apostrophes (single quotes), non standard
        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        MAPPER.setConfig(MAPPER.getDeserializationConfig()
                .with(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
                .with(JsonReadFeature.ALLOW_TRAILING_COMMA)
                .with(JsonReadFeature.ALLOW_MISSING_VALUES)
                .with(JsonWriteFeature.ESCAPE_NON_ASCII));
        MAPPER.setTimeZone(TimeZone.getDefault());
    }

    public static String toJsonString(Object o) {
        try {
            return toJsonString(o, false);
        } catch (JsonProcessingException e) {
           throw  new RuntimeException(e);
        }
    }

    public static String toJsonString(Object o, boolean pretty) throws JsonProcessingException {
        if(pretty) {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } else {
            return MAPPER.writeValueAsString(o);
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonProcessingException {
        return MAPPER.readValue(json, clazz);
    }

    public static <T> T jsonToObject(String json, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        return MAPPER.readValue(json, valueTypeRef);
    }

    public static <K, V> Map<K, V> jsonToMap(String json, Class<K> keyClazz, Class<V> valueClazz) throws JsonProcessingException {
        return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, keyClazz, valueClazz));
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) throws JsonProcessingException {
        return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, clazz));
    }

    /**
     * 对象转化为Map
     * @param obj
     * @return
     */
    public static Map<String,Object> objectToMap(Object obj){
        try{
            Map<String,Object> map = new HashMap(3);
            Class clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }
            return map;
        }catch (Exception e){
            return null;
        }
    }
}
