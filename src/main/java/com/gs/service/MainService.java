package com.gs.service;

import com.alibaba.fastjson.JSONObject;

public interface MainService {
    JSONObject getData(JSONObject data);
    JSONObject deleteData(JSONObject data);
    JSONObject updateData(JSONObject data);
    JSONObject insertData(JSONObject data);
    JSONObject count(JSONObject data);
    JSONObject searchData(JSONObject data);
}
