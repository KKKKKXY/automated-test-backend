package camt.se234.lab11.service;

import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    @Override
    public String getGrade(double score) {
        if (score > 79.5) {
            return "A";
        }
        else if (score > 74.5){
            return "B";
        }else if (score > 59.5){
            return "C";
        }else if (score > 32.5) {
            return "D";
        } else
            return "F";

    }

    @Override
    public String getGrade(double midtermScore, double finalScore) {
        //return null;
        return getGrade((midtermScore + finalScore) / 2);

    }


}
