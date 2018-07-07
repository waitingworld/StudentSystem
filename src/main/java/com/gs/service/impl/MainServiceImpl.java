package com.gs.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gs.dao.MainDao;
import com.gs.service.MainService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class MainServiceImpl implements MainService {
    private Logger logger = Logger.getLogger(MainServiceImpl.class);
    @Resource
    private MainDao mainDao;

    public JSONObject getData(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("type")) {
            List<JSONObject> listData = new ArrayList<JSONObject>();
            String type = data.getString("type");
            if (type.equals("student")) {
                listData = mainDao.getStudents(data);

            } else if (type.equals("discipline")) {
                listData = mainDao.getDisciplines(data);

            } else if (type.equals("score")) {
                listData = mainDao.getScores(data);

            }
            result.put("model", listData);
        }

        result.put("success", true);
        logger.info("getData:" + result.toJSONString());
        return result;
    }

    public JSONObject deleteData(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("type")) {
            boolean successFlag = true;
            String type = data.getString("type");
            if (type.equals("student")) {
                if (mainDao.deleteStudents(data) < 0) {
                    if (mainDao.deleteScoresByStudentId(data) < 0) {
                        successFlag = false;
                    }
                    successFlag = false;
                }

            } else if (type.equals("discipline")) {
                if (mainDao.deleteDisciplines(data) < 0) {
                    successFlag = false;
                }

            } else if (type.equals("score")) {
                if (mainDao.deleteScores(data) < 0) {
                    successFlag = false;
                }
            }
            result.put("success", successFlag);
        } else {
            result.put("success", false);
        }
        logger.info("deleteData:" + result.toJSONString());
        return result;
    }

    public JSONObject insertData(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("type")) {
            boolean successFlag = true;
            String type = data.getString("type");
            data = data.getJSONObject("model");
            if (type.equals("student")) {
                List<JSONObject> classes = mainDao.getClasssByName(data);
                if (classes != null && classes.size() > 0) {
                    data.put("class_id", classes.get(0).getString("id"));
                    data.put("sex", data.getString("sex").equals("男") ? 1 : 0);
                    data.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
                    if (mainDao.insertStudent(data) < 0) {
                        successFlag = false;
                    }
                } else {
                    successFlag = false;
                    result.put("msg", "班级不存在！");
                }

            } else if (type.equals("discipline")) {
                data.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
                if (mainDao.insertDiscipline(data) < 0) {
                    successFlag = false;
                }

            } else if (type.equals("score")) {
                data.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
                if (mainDao.insertScore(data) < 0) {
                    successFlag = false;
                }
            }
            result.put("success", successFlag);
        } else {
            result.put("success", false);
        }
        logger.info("result:" + result.toJSONString());
        return result;
    }

    public JSONObject updateData(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("type")) {
            boolean successFlag = true;
            String type = data.getString("type");
            data = data.getJSONObject("model");
            if (type.equals("student")) {
                List<JSONObject> classes = mainDao.getClasssByName(data);
                if (classes != null && classes.size() > 0) {
                    data.put("class_id", classes.get(0).getString("id"));
                    data.put("sex", data.getString("sex").equals("男") ? 1 : 0);
                    if (mainDao.updateStudents(data) < 0) {
                        successFlag = false;
                    }
                } else {
                    successFlag = false;
                    result.put("msg", "班级不存在！");
                }

            } else if (type.equals("discipline")) {
                if (mainDao.updateDisciplines(data) < 0) {
                    successFlag = false;
                }

            } else if (type.equals("score")) {
                if (mainDao.updateScores(data) < 0) {
                    successFlag = false;
                }
            }
            result.put("success", successFlag);
        } else {
            result.put("success", false);
        }
        logger.info("updateData:" + result.toJSONString());
        return result;
    }

    public JSONObject count(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("startTime") && data.containsKey("endTime")) {
            String startTime = data.getString("startTime");
            String endTime = data.getString("endTime");
            Date date1 = Date.valueOf(startTime);
            Date date2 = Date.valueOf(endTime);
            data.put("startTime", date1);
            data.put("endTime", date2);
        }
        result = mainDao.count(data);
        if (result == null) {
            result = new JSONObject();
            result.put("success", true);
            result.put("source", 0);
        } else {
            result.put("success", true);
        }

        return result;
    }

    public JSONObject searchData(JSONObject data) {
        JSONObject result = new JSONObject();
        if (data.containsKey("type") &&
                (data.containsKey("code")||
                        (data.containsKey("discipline_code")&&data.containsKey("student_code")))) {
            String type = data.getString("type");
            if (type.equals("student")) {
                result = mainDao.getStudentById(data);
            } else if (type.equals("discipline")) {
                result = mainDao.getDisciplineById(data);
            } else if (type.equals("score")) {
                result = mainDao.getScoreById(data);
            }
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }
}
