package codegym.vn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowBook {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(columnDefinition = "varchar(100)", name = "user_name")
    private String userName;

    @Column(name = "borrowed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowedDate;

    @Column(name = "pay_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDay;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Book book;

    @Column(name = "status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowBook() {
    }

    public BorrowBook(Integer userId, String userName, Date borrowedDate, Date payDay, Book book) {
        this.userId = userId;
        this.userName = userName;
        this.borrowedDate = borrowedDate;
        this.payDay = payDay;
        this.book = book;
    }

    public BorrowBook(Integer userId, String userName, Date borrowedDate, Date payDay, Book book, boolean status) {
        this.userId = userId;
        this.userName = userName;
        this.borrowedDate = borrowedDate;
        this.payDay = payDay;
        this.book = book;
        this.status = status;
    }
}
