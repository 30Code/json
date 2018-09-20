package cn.linhome.lib.utils.json.adapter;

import com.google.gson.JsonElement;

public class LongAdapter extends NumberAdapter<Long>
{
    @Override
    protected Long deserializeIllegalJsonElement(JsonElement json)
    {
        return 0L;
    }

    @Override
    protected Long deserializeJsonElement(JsonElement json)
    {
        return json.getAsLong();
    }
}
