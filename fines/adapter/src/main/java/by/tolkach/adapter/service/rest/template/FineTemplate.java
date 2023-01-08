package by.tolkach.adapter.service.rest.template;

import java.time.LocalDate;

public class FineTemplate {
    private int incomeSum;
    private int paymentSum;
    private int decreeNumber;
    private String sts;
    private LocalDate date;
    private String article;

    public FineTemplate(int incomeSum, int paymentSum, int decreeNumber, String sts, LocalDate date, String article) {
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

    public static class FineTemplateBuilder {
        private int incomeSum;
        private int paymentSum;
        private int decreeNumber;
        private String sts;
        private LocalDate date;
        private String article;

        private FineTemplateBuilder() {
        }

        public static FineTemplateBuilder createBuilder() {
            return new FineTemplateBuilder();
        }

        public FineTemplateBuilder setIncomeSum(int incomeSum) {
            this.incomeSum = incomeSum;
            return this;
        }

        public FineTemplateBuilder setPaymentSum(int paymentSum) {
            this.paymentSum = paymentSum;
            return this;
        }

        public FineTemplateBuilder setDecreeNumber(int decreeNumber) {
            this.decreeNumber = decreeNumber;
            return this;
        }

        public FineTemplateBuilder setSts(String sts) {
            this.sts = sts;
            return this;}


        public FineTemplateBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public FineTemplateBuilder setArticle(String article) {
            this.article = article;
            return this;
        }

        public FineTemplate build() {
            return new FineTemplate(incomeSum, paymentSum, decreeNumber, sts, date, article);
        }
    }
}
