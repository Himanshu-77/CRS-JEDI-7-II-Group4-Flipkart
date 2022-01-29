package com.flipkart.exception;

public class ProfessorNotFoundException extends Exception {

    private int professorID;

    /**
     * @param professorID
     */
    public ProfessorNotFoundException(int professorID) {
        super();
        this.professorID = professorID;
    }

    /**
     * @return the courseID
     */
    public int professorID() {
        return professorID;
    }

    @Override
    public String getMessage() {
        return "ProfessorID: " + professorID + "is not present in the list!";
    }
}
