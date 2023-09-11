package codegym.vn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Table
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "varchar(50)")
    private String productName;

    @Column
    private Category category;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateRelease;

    @Column
    private double price;
}
