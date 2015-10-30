package com.augmentum.examonline.model;

import java.util.Date;

public class Exam {
    private int id;
    private String name;

    private Date createdTime;
    private String description;
    private Date effectiveTime;
    private int duration;
    private int questionQuantity;
    private int totalScore;
    private int passCriteria;
    private int questionPoints;
    private String creator;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getEffectiveTime() {
        return effectiveTime;
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getQuestionQuantity() {
        return questionQuantity;
    }
    public void setQuestionQuantity(int questionQuantity) {
        this.questionQuantity = questionQuantity;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public int getPassCriteria() {
        return passCriteria;
    }
    public void setPassCriteria(int passCriteria) {
        this.passCriteria = passCriteria;
    }
    public int getQuestionPoints() {
        return questionPoints;
    }
    public void setQuestionPoints(int questionPoints) {
        this.questionPoints = questionPoints;
    }
}
