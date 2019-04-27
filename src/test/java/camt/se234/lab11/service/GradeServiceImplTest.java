package camt.se234.lab11.service;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class GradeServiceImplTest {
    @Test
    public void testGetGrade(){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(100),is("A"));
        assertThat(gradeService.getGrade(80),is("A"));
        assertThat(gradeService.getGrade(78.9),is("B"));
        assertThat(gradeService.getGrade(75),is("B"));
        assertThat(gradeService.getGrade(74.4),is("C"));
        assertThat(gradeService.getGrade(60),is("C"));
        assertThat(gradeService.getGrade(59.4),is("D"));
        assertThat(gradeService.getGrade(33),is("D"));
        assertThat(gradeService.getGrade(32),is("F"));
        assertThat(gradeService.getGrade(0),is("F"));
    }

    public Object paramsForTestGetGradeParams(){
        return new Object[][]{
                {100,"A"},
                {77,"B"}
        };
    }

    @Test
    @Parameters(method = "paramsForTestGetGradeParams")
    @TestCaseName("Test getGrade Paeams [{index}] : input is {0}, expect \"{1}\"")
    public void testGeGradeParams(double score,String expectedGrade){
        GradeServiceImpl grageService = new GradeServiceImpl();
        assertThat(grageService.getGrade(score),is(expectedGrade));
    }

    //test all possible grade

    @Test
    public void testAllPossibleGrade(){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(100,100),is("A"));
        assertThat(gradeService.getGrade(90,90),is("A"));
        assertThat(gradeService.getGrade(70,80),is("B"));
        assertThat(gradeService.getGrade(70,70),is("C"));
        assertThat(gradeService.getGrade(60,60),is("C"));
        assertThat(gradeService.getGrade(50,50),is("D"));
        assertThat(gradeService.getGrade(30,30),is("F"));
    }



}
