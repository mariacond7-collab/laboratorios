package grades;

import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Double> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    public Double calculateAverage() {
        Double sum = 0.0;

        for (Double grade : grades) {
            sum += grade;
        }

        return grades.isEmpty() ? 0.0 : sum / grades.size();
    }

    public Integer countPassingGrades() {
        Integer count = 0;

        for (Double grade : grades) {
            if (grade >= 50.0) {
                count++;
            }
        }

        return count;
    }

    public boolean removeGradeByValue(Double grade) {
        return grades.remove(grade);
    }

    public boolean removeGradeByPosition(Integer position) {
        if (position < 1 || position > grades.size()) {
            return false;
        }

        grades.remove(position - 1);
        return true;
    }

    public ArrayList<Double> getGrades() {
        return new ArrayList<>(grades);
    }

    public boolean isEmpty() {
        return grades.isEmpty();
    }

    public Integer size() {
        return grades.size();
    }
}
