package codegym.vn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(columnDefinition = "varchar(100)", name = "name")
    private String name;

    @Column(columnDefinition = "varchar(100)", name = "author")
    private String author;

    @Column(columnDefinition = "varchar(255)", name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<BorrowBook> borrowBooks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBook> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBook> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }


}
