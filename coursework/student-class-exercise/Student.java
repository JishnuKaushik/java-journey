public class Student {
    // declare fields here based on the 8 details listed
    int semester;
    int admissionYear;
    String rollNumber;
    String mobileNo;
    double attendancePercent;
    double cgpa;
    String section;
    boolean hostellerStatus;

    // constructor — fills these fields when you create a Student object
    public Student(int semester, int admissionYear, String rollNumber,
                   String mobileNo, double attendancePercent, double cgpa,
                   String section, boolean hostellerStatus) {
        this.semester = semester;
        this.admissionYear = admissionYear;
        this.rollNumber = rollNumber;
        this.mobileNo = mobileNo;
        this.attendancePercent = attendancePercent;
        this.cgpa = cgpa;
        this.section = section;
        this.hostellerStatus = hostellerStatus;
    }

    // your job: write a method here to display all the fields
    public void displayDetails() {
        // fill this in
    }
}