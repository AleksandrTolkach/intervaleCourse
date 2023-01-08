package by.tolkach.adapter.model;

import java.time.LocalDate;

public class Fine {
    private int incomeSum;
    private int paymentSum;
    private int decreeNumber;
    private String sts;
    private LocalDate date;
    private String article;

    public Fine(int incomeSum, int paymentSum, int decreeNumber, String sts, LocalDate date, String article) {
        this.incomeSum = incomeSum;
        this.paymentSum = paymentSum;
        this.decreeNumber = decreeNumber;
        this.sts = sts;
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

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
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
        private String sts;
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

        public FineBuilder setSts(String sts) {
            this.sts = sts;
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
            return new Fine(incomeSum, paymentSum, decreeNumber, sts, date, article);
        }
    }
}
