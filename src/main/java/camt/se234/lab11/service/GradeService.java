package camt.se234.lab11.service;

public interface GradeService {
    String getGrade(double score);
    String getGrade(double midtermScore, double finalScore);

}
