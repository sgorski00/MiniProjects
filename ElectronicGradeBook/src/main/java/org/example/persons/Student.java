package org.example.persons;

public class Student extends Person{
    int[] grades;

    public Student(String firstName, String lastName, int... grades) {
        super(firstName, lastName);
        this.grades = grades;
    }

    public double getAverageGrade(){
        double result = 0;
        for(int i : this.grades){
            result += i;
        }
        return result/this.grades.length;
    }
}
