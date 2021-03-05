package com.example.junitmockitojdoc.model;

/**
 * Provides information of a child's state.
 */

public class Child extends Parent{

    private String childName;
    private boolean hasDisability;
    private boolean hasTwin;
    private boolean hasOtherSibling;
    private int childScore;
    private int totalScore;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public boolean isHasDisability() {
        return hasDisability;
    }

    public void setHasDisability(boolean hasDisability) {
        this.hasDisability = hasDisability;
    }

    public boolean isHasTwin() {
        return hasTwin;
    }

    public void setHasTwin(boolean hasTwin) {
        this.hasTwin = hasTwin;
    }

    public boolean isHasOtherSibling() {
        return hasOtherSibling;
    }

    public void setHasOtherSibling(boolean hasOtherSibling) {
        this.hasOtherSibling = hasOtherSibling;
    }

    public int getChildScore() {
        return childScore;
    }

    public void setChildScore(byte childScore) {
        this.childScore = childScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(byte totalScore) {
        this.totalScore = totalScore;
    }

}
