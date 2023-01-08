package by.tolkach.smev.model;

import java.time.LocalDate;
import java.util.UUID;

public class Fine {
    private UUID id;
    private int incomeSum;
    private int paymentSum;
    private int decreeNumber;
    private String sts;
    private LocalDate date;
    private String article;

    public Fine(UUID id, int incomeSum, int paymentSum, int decreeNumber, String sts, LocalDate date, String article) {
        this.id = id;
        this.incomeSum = incomeSum;
        this.paymentSum = paymentSum;
        this.decreeNumber = decreeNumber;
        this.sts = sts;
        this.date = date;
        this.article = article;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        private UUID id;
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

        public FineBuilder setId(UUID id) {
            this.id = id;
            return this;
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
            return new Fine(id, incomeSum, paymentSum, decreeNumber, sts, date, article);
        }
    }
}
