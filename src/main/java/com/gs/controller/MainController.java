package com.gs.controller;

import com.alibaba.fastjson.JSONObject;
import com.gs.service.MainService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main")
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class);

    @Resource
    private MainService mainService;

    @ResponseBody
    @RequestMapping("/getData")
    public JSONObject getData(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("查询数据信息,data:" + data.toJSONString());
        return mainService.getData(data);
    }

    @ResponseBody
    @RequestMapping("/deleteData")
    public JSONObject deleteData(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("删除数据信息,data:" + data.toJSONString());
        return mainService.deleteData(data);
    }

    @ResponseBody
    @RequestMapping("/updateData")
    public JSONObject updateData(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("更新数据信息,data:" + data.toJSONString());
        return mainService.updateData(data);
    }

    @ResponseBody
    @RequestMapping("/insertData")
    public JSONObject insertData(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("添加数据信息,data:" + data.toJSONString());
        return mainService.insertData(data);
    }

    @ResponseBody
    @RequestMapping("/count")
    public JSONObject count(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("统计数据信息,data:" + data.toJSONString());
        return mainService.count(data);
    }

    @ResponseBody
    @RequestMapping("/searchData")
    public JSONObject searchData(@RequestBody JSONObject data, HttpServletRequest request) {
        logger.info("查询数据信息,data:" + data.toJSONString());
        return mainService.searchData(data);
    }
}
