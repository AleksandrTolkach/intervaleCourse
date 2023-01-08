package by.tolkach.smev.dao.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fines")
public class FineEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private int incomeSum;
    private int paymentSum;
    private int decreeNumber;
    private String sts;
    private LocalDate date;
    private String article;

    public FineEntity() {
    }

    public FineEntity(UUID id, int incomeSum, int paymentSum, int decreeNumber, String sts, LocalDate date, String article) {
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

    public static class FineEntityBuilder {
        private UUID id;
        private int incomeSum;
        private int paymentSum;
        private int decreeNumber;
        private String sts;
        private LocalDate date;
        private String article;

        private FineEntityBuilder() {}

        public static FineEntityBuilder createBuilder() {
            return new FineEntityBuilder();
        }

        public FineEntityBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public FineEntityBuilder setIncomeSum(int incomeSum) {
            this.incomeSum = incomeSum;
            return this;
        }

        public FineEntityBuilder setPaymentSum(int paymentSum) {
            this.paymentSum = paymentSum;
            return this;
        }

        public FineEntityBuilder setDecreeNumber(int decreeNumber) {
            this.decreeNumber = decreeNumber;
            return this;
        }

        public FineEntityBuilder setSts(String sts) {
            this.sts = sts;
            return this;
        }

        public FineEntityBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public FineEntityBuilder setArticle(String article) {
            this.article = article;
            return this;
        }

        public FineEntity build() {
            return new FineEntity(id, incomeSum, paymentSum, decreeNumber, sts, date, article);
        }
    }
}
