package com.company;

import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Integer> marks = new ArrayList<>();

    public GradeBook(int... marks){
        for (int m:marks) {
            this.marks.add(m);
        }
    }

    public GradeBook(GradeBook gradeBook){
        this.marks = new ArrayList<>(gradeBook.marks);
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks.toString();
    }
}
