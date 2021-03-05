package com.example.junitmockitojdoc.model;

/**
 * Base information for Parent
 */

public class Parent extends User {

    private String parentName;
    private boolean isEmployed;
    private boolean hasEmployedSpouse;
    private int parentScore;

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public boolean isHasEmployedSpouse() {
        return hasEmployedSpouse;
    }

    public void setHasEmployedSpouse(boolean hasEmployedSpouse) {
        this.hasEmployedSpouse = hasEmployedSpouse;
    }

    public int getParentScore() {
        return parentScore;
    }

    public void setParentScore(int parentScore) {
        this.parentScore = parentScore;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
