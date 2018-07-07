package com.gs.model;

public class Score {
    private String id;
    private String discipline_id;
    private String student_id;
    private int score;
    private int credit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(String discipline_id) {
        this.discipline_id = discipline_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id='" + id + '\'' +
                ", discipline_id='" + discipline_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", score=" + score +
                ", credit=" + credit +
                '}';
    }
}
