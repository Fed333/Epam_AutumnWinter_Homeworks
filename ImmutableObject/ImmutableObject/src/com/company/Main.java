package com.company;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Roman", 18, "1PI-20B", new GradeBook(5, 5, 5));
        System.out.println(s1);
        GradeBook gradeBook = s1.getGradeBook();
        gradeBook.getMarks().set(0, 2);
        gradeBook.getMarks().set(1, 2);
        gradeBook.getMarks().set(2, 2);
        System.out.println(s1);

        Student s2 = s1.setName("Ivan");
        System.out.println(s2);
        System.out.println("Set new GradeBook for Ivan");
        s2 = s2.setGradeBook(new GradeBook(3, 3, 3));
        System.out.println(s2);

        System.out.println("Attempts to change an existing GradeBook");
        s2.getGradeBook().getMarks().set(0, 4);
        s2.getGradeBook().getMarks().set(1, 4);
        s2.getGradeBook().getMarks().set(2, 4);
        System.out.println("Attempt to change an existing group");
        s2.setGroup("3PI-20B");
        System.out.println(s2);
        System.out.println(s1);
    }
}
