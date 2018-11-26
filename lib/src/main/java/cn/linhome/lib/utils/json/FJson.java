package cn.linhome.lib.utils.json;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public final class FJson
{
    private FJson()
    {
    }

    public static <T> T jsonToObject(String json, Class<T> clazz)
    {
        return JSON.parseObject(json, clazz);
    }

    public static String objectToJson(Object obj)
    {
        return JSON.toJSONString(obj);
    }

    public static <T> T mapToObject(Map map, Class<T> clazz)
    {
        T t = null;
        if (map != null)
        {
            String json = objectToJson(map);
            t = jsonToObject(json, clazz);
        }
        return t;
    }
}
