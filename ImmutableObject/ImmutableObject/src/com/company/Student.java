package com.company;

import java.util.Objects;

public final class Student {
    private final String name;
    private final int age;
    private final String group;

    private final GradeBook gradeBook;


    public Student(String name, int age, String group) {
        this(name, age, group, new GradeBook());
    }

    public Student(String name, int age, String group, GradeBook gradeBook) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.gradeBook = new GradeBook(gradeBook);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public GradeBook getGradeBook() {
        return new GradeBook(gradeBook);
    }

    public Student setAge(int age){
        return new Student(this.name, age, this.group, this.gradeBook);
    }

    public Student setName(String name){
        return new Student(name, this.age, this.group, this.gradeBook);
    }

    public Student setGradeBook(GradeBook gradeBook){
        return new Student(this.name, this.age, this.group, gradeBook);
    }

    public Student setGroup(String group){
        return new Student(this.name, this.age, group, this.gradeBook);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group) &&
                Objects.equals(gradeBook, student.gradeBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group, gradeBook);
    }

    @Override
    public String toString() {
       return String.format("%10s - %3d - %7s - %-20s", name, age, group, gradeBook);
    }
}
