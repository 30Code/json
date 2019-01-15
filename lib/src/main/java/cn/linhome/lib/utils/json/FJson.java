package cn.linhome.lib.utils.json;

import cn.linhome.lib.utils.json.adapter.DoubleAdapter;
import cn.linhome.lib.utils.json.adapter.FloatAdapter;
import cn.linhome.lib.utils.json.adapter.IntegerAdapter;
import cn.linhome.lib.utils.json.adapter.LongAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public final class FJson
{
    public static final Gson gGSON = new GsonBuilder()
            .registerTypeAdapter(int.class, new IntegerAdapter())
            .registerTypeAdapter(Integer.class, new IntegerAdapter())

            .registerTypeAdapter(long.class, new LongAdapter())
            .registerTypeAdapter(Long.class, new LongAdapter())

            .registerTypeAdapter(float.class, new FloatAdapter())
            .registerTypeAdapter(Float.class, new FloatAdapter())

            .registerTypeAdapter(double.class, new DoubleAdapter())
            .registerTypeAdapter(Double.class, new DoubleAdapter())
            .create();

    private FJson()
    {
    }

    public static <T> T jsonToObject(String json, Class<T> clazz)
    {
        return gGSON.fromJson(json, clazz);
    }

    public static String objectToJson(Object obj)
    {
        return gGSON.toJson(obj);
    }

    public static <T> T mapToObject(Map map, Class<T> clazz)
    {
        if (map == null)
        {
            return null;
        }
        String json = objectToJson(map);
        return jsonToObject(json, clazz);
    }
}
