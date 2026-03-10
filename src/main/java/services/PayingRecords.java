package services;

public class PayingRecords {

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

    int Amount;
    String PaymentName;
    String PaymentType;
    Date PaymentDate;

    public PayingRecords(int amount, String paymentName, String paymentType,int day, int month, int year) {
        Amount = amount;
        PaymentName = paymentName;
        PaymentType = paymentType;
        PaymentDate = new Date(day, month, year);
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getPaymentName() {
        return PaymentName;
    }

    public void setPaymentName(String paymentName) {
        PaymentName = paymentName;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    @Override
    public String toString() {
        return "PayingRecords{" +
                "Amount=" + Amount +
                ", PaymentName='" + PaymentName + '\'' +
                ", PaymentType='" + PaymentType + '\'' +
                ", PaymentDate= (" + PaymentDate +
                ")}";
    }
}
