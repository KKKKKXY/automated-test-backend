package camt.se234.lab11.service;

import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student findStudentById(String id) {
        for (Student student: this.studentDao.findAll()
             ) {
            if (student.getStudentId().equals(id)){
                return student;
            }
        }
        throw new NoDataException();
    }

    @Override
    public List<Student> findStudentByPartOfId(String id) {
        List<Student> output = new ArrayList<>();
        for (Student student: this.studentDao.findAll()
                ) {
            if (student.getStudentId().indexOf(id) != -1){
                output.add(student);
            }
        }
        throw new OutputException();
    }

    
    @Override
    public double getAverageGpa() {
        double total = 0;
        for (Student student: this.studentDao.findAll()
                ) {
            total += student.getGpa();

        }
        return total/this.studentDao.findAll().size();
    }

    @Override
    public double getAverageGpaNew() {
        double total = 0;
        for (Student student: this.studentDao.findAllNewList()
        ) {
            total += student.getGpa();

        }
        return total/this.studentDao.findAllNewList().size();
    }

    public class NoDataException extends RuntimeException {

    }
    public class OutputException extends RuntimeException {

    }
    public class ArithmeticException extends RuntimeException {

    }

}
