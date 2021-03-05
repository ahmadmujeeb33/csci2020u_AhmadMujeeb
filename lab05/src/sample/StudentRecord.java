package sample;

public class StudentRecord {
        private String sid;
        private double assignments;
        private double midterm;
        private double finalExam;
        private double FinalMark;
        private String Lettergrade;

    public StudentRecord(String sid, double assignments, double midterm, double finalExam) {
        this.sid = sid;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }
    public String getSid() {
        return sid;
    }

    public double getAssignments() {
        return assignments;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getFinalMark() {
        this.FinalMark =  (this.assignments*20 + this.midterm*30 + this.finalExam*50)/100;
        return this.FinalMark;
    }

    public String getLettergrade() {
        if(this.FinalMark>80 && this.FinalMark<100){
            return "A";
        }
        else if(this.FinalMark>70 && this.FinalMark<80){
            return "B";
        }
        else if(this.FinalMark>60 && this.FinalMark<70){
            return "C";
        }
        else if(this.FinalMark>50 && this.FinalMark<59){
            return "D";
        }
        return "F";
    }




}
