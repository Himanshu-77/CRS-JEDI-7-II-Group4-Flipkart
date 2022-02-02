package com.flipkart.bean;

public class SemesterPaymentWindow {

    private Integer semesterId;
    private Boolean isOpen;

    public SemesterPaymentWindow(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public SemesterPaymentWindow() {
        this.semesterId=1;
        this.isOpen= false;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public SemesterPaymentWindow(Integer semesterId, Boolean isOpen) {
        this.semesterId = semesterId;
        this.isOpen = isOpen;
    }


}
