package codegym.vn.entity;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowBook implements Validator {
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
    private boolean status = false;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowBook borrowBook = (BorrowBook) target;
        userName = borrowBook.getUserName();
        String[] specialCharacters = {"@", ";", ".", "=", "-", "+"};

        ValidationUtils.rejectIfEmpty(errors, "userName", "userName.empty", null, "Không được để trống!");
        if (userName.length() > 100) {
            errors.rejectValue("userName", "userName.length", null, "Tên quá dài!");
        }
        for (int i = 0; i < specialCharacters.length; i++) {
            if (userName.contains(specialCharacters[i])){
                errors.rejectValue("userName", "userName.specialCharacter", null, "Không được chứa ký tự đặc biệt!");
                break;
            }
        }
    }
}
