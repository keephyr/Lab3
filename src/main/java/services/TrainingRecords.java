package services;

public class TrainingRecords {

    public static class Date{
        int day;
        int month;
        int year;
        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        public int getDay() {
            return day;
        }
        public void setDay(int day) {
            this.day = day;
        }
        public int getMonth() {
            return month;
        }
        public void setMonth(int month) {
            this.month = month;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return  day +
                    "." + month +
                    "." + year;
        }
    }

    int TrainLevel;
    String TrainName;
    Date TrainDate;

    public TrainingRecords(int trainLevel, String trainName, int day, int month, int year) {
        this.TrainLevel = trainLevel;
        this.TrainName = trainName;
        this.TrainDate = new Date(day, month, year);
    }
    public int getTrainLevel() {
        return TrainLevel;
    }
    public void setTrainLevel(int trainLevel) {
        TrainLevel = trainLevel;
    }
    public String getTrainName() {
        return TrainName;
    }
    public void setTrainName(String trainName) {
        TrainName = trainName;
    }

    @Override
    public String toString() {
        return "TrainingRecords{" +
                "TrainLevel=" + TrainLevel +
                ", TrainName='" + TrainName + '\'' +
                ", TrainDate= (" + TrainDate +
                ")}";
    }
}
