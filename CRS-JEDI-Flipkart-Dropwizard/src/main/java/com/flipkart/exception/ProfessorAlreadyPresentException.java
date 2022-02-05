package com.flipkart.exception;

public class ProfessorAlreadyPresentException extends Exception {

    private String professorID;

    public ProfessorAlreadyPresentException() {
        this.professorID = "";
    }

    /**
     * @param professorID
     */
    public ProfessorAlreadyPresentException(String professorID) {
        super();
        this.professorID = professorID;
    }

    /**
     * @return the courseID
     */
    public String professorID() {
        return professorID;
    }

    @Override
    public String getMessage() {
        return "ProfessorID: " + professorID + "is already present in the list!";
    }
}
