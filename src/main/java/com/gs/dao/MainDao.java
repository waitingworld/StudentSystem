package com.gs.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainDao {
    List<JSONObject> getStudents(JSONObject data);

    List<JSONObject> getClasssByName(JSONObject data);

    List<JSONObject> getDisciplines(JSONObject data);

    List<JSONObject> getScores(JSONObject data);

    int deleteStudents(JSONObject data);
    int deleteDisciplines(JSONObject data);
    int deleteScores(JSONObject data);
    int deleteScoresByStudentId(JSONObject data);
    
    int updateStudents(JSONObject data);
    int updateDisciplines(JSONObject data);
    int updateScores(JSONObject data);
    
    int insertStudent(JSONObject data);
    int insertDiscipline(JSONObject data);
    int insertScore(JSONObject data);

    JSONObject count(JSONObject data);

    JSONObject getStudentById(JSONObject data);
    JSONObject getDisciplineById(JSONObject data);
    JSONObject getScoreById(JSONObject data);
}
