package camt.se234.lab11.dao;

import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    List<Student> students;
    List<Student> newStudents;
    public StudentDaoImpl(){
        students = new ArrayList<>();
        newStudents = new ArrayList<>();

        students.add(new Student("123","A","temp",2.33));
        students.add(new Student("1","B","a",1.0));
        students.add(new Student("2","B","b",2.0));
        students.add(new Student("3","C","c",1.2));
        students.add(new Student("4","D","d",2.0));
        students.add(new Student("5","F","e",0.8));


        newStudents.add(new Student("01","F","q",1.2));
        newStudents.add(new Student("02","F","w",0.8));

    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }
    public List<Student> findAllNewList() {
        return this.newStudents;
    }


}
