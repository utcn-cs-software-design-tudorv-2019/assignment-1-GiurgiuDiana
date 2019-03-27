package Model;
import java.sql.Date;


public class Grades {
    private int Grade;
    private Date examDate;
    private Date MidtermDate;
    private int MidtermGrade;
    private int exam;
    private int studentID;
    private int coursesID;

    public Grades(int grade, Date examDate, Date midtermDate, int midtermGrade, int exam, int studentID, int coursesID) {
        Grade = grade;
        this.examDate = examDate;
        MidtermDate = midtermDate;
        MidtermGrade = midtermGrade;
        this.exam = exam;
        this.studentID = studentID;
        this.coursesID = coursesID;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Date getMidtermDate() {
        return MidtermDate;
    }

    public void setMidtermDate(Date midtermDate) {
        MidtermDate = midtermDate;
    }

    public int getMidtermGrade() {
        return MidtermGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        MidtermGrade = midtermGrade;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCoursesID() {
        return coursesID;
    }

    public void setCoursesID(int coursesID) {
        this.coursesID = coursesID;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "Grade=" + Grade +
                ", examDate=" + examDate +
                ", MidtermDate=" + MidtermDate +
                ", MidtermGrade=" + MidtermGrade +
                ", exam=" + exam +
                ", studentID=" + studentID +
                ", coursesID=" + coursesID +
                '}';
    }
}
