package camt.se234.lab11.service;

import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.dao.StudentDaoImpl;
import camt.se234.lab11.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    StudentDao studentDao;
    StudentServiceImpl studentService;

    @Before
    public void setup() {
        studentDao = mock(StudentDao.class);
        studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
    }

    @Test
    public void testFindById(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.findStudentById("123"),is(new Student("123","A","temp",2.33)));


        assertThat(studentService.findStudentById("1"),is(new Student("1","B","a",1.0)));
        assertThat(studentService.findStudentById("3"),is(new Student("3","C","c",1.2)));
        assertThat(studentService.findStudentById("5"),is(new Student("5","F","e",0.8)));

    }

    @Test
    public void testAverageGpa(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.getAverageGpa(),is(1.5550000000000004));

    }

    @Test
    public void testAverageGpaNewList(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.getAverageGpaNew(),is(1.0));

    }

    @Test
    public void testWithMock(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("123"),is(new Student("123","A","temp",2.33)));
    }

    @Test
    public void testWithMockOwn(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("01","F","q",1.2));
        mockStudents.add(new Student("02","F","w",0.8));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("01"),is(new Student("01","F","q",1.2)));
    }

    //@Test(expected = StudentServiceImpl.ArithmeticException.class)
    public void getAverageGpaMock(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.getAverageGpa(),is(2.33));
    }

    @Test(expected = StudentServiceImpl.OutputException.class)
    public void testFindByPartOfId(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentByPartOfId("22"),hasItem(new Student("223","C","temp",2.33)));
        assertThat(studentService.findStudentByPartOfId("22"),hasItems(new Student("223","C","temp",2.33),new Student("224","D","temp",2.33)));

    }

    @Test(expected = StudentServiceImpl.OutputException.class)
    public void testFindByPartOfIdOwn(){
        //StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
        //StudentServiceImpl studentService = new StudentServiceImpl();
        //studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("121","F","q",1.2));
        mockStudents.add(new Student("112","F","w",0.8));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentByPartOfId("12"),hasItem(new Student("123","A","temp",2.33)));
        assertThat(studentService.findStudentByPartOfId("12"),hasItems(new Student("123","A","temp",2.33),new Student("121","F","q",1.2)));

    }

    @Test(expected = StudentServiceImpl.NoDataException.class)
    public void testNoDataException(){
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123","A","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("55"),nullValue());
    }


}
