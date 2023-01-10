package by.tolkach.adapter.model;

import java.time.LocalDate;

public class Fine {
    private int incomeSum;
    private int paymentSum;
    private int decreeNumber;
    private String vehicleId;
    private LocalDate date;
    private String article;

    public Fine(int incomeSum, int paymentSum, int decreeNumber, String vehicleId, LocalDate date, String article) {
        this.incomeSum = incomeSum;
        this.paymentSum = paymentSum;
        this.decreeNumber = decreeNumber;
        this.vehicleId = vehicleId;
        this.date = date;
        this.article = article;
    }

    public int getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(int incomeSum) {
        this.incomeSum = incomeSum;
    }

    public int getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    public int getDecreeNumber() {
        return decreeNumber;
    }

    public void setDecreeNumber(int decreeNumber) {
        this.decreeNumber = decreeNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public static class FineBuilder {
        private int incomeSum;
        private int paymentSum;
        private int decreeNumber;
        private String vehicleId;
        private LocalDate date;
        private String article;

        private FineBuilder() {
        }

        public static FineBuilder createBuilder() {
            return new FineBuilder();
        }

        public FineBuilder setIncomeSum(int incomeSum) {
            this.incomeSum = incomeSum;
            return this;
        }

        public FineBuilder setPaymentSum(int paymentSum) {
            this.paymentSum = paymentSum;
            return this;
        }

        public FineBuilder setDecreeNumber(int decreeNumber) {
            this.decreeNumber = decreeNumber;
            return this;
        }

        public FineBuilder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;}


        public FineBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public FineBuilder setArticle(String article) {
            this.article = article;
            return this;
        }

        public Fine build() {
            return new Fine(incomeSum, paymentSum, decreeNumber, vehicleId, date, article);
        }
    }
}
