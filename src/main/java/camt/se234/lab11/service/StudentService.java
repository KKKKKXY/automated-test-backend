package camt.se234.lab11.service;

import camt.se234.lab11.entity.Student;

import java.util.List;

public interface StudentService {
    Student findStudentById(String id);
    List<Student> findStudentByPartOfId(String id);
    double getAverageGpa();
    double getAverageGpaNew();

}
