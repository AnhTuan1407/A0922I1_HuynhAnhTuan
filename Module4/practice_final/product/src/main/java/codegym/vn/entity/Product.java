package codegym.vn.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
public class Product implements Validator {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer productId;
    @Column(columnDefinition = "varchar(150)", name = "product_name")
    private String productName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "date_release")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "category_id")
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(Integer productId, String productName, int quantity, double price, Date dateRelease, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.dateRelease = dateRelease;
        this.category = category;
    }

    public Product(String productName, int quantity, double price, Date dateRelease, Category category) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.dateRelease = dateRelease;
        this.category = category;
    }

    public Product() {
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        productName = product.getProductName();
        quantity = product.getQuantity();
        price = product.getPrice();

        ValidationUtils.rejectIfEmpty(errors, "productName", "productName.empty", null, "Not empty");
        if (productName.length() > 50){
            errors.rejectValue("productName",  "productName.empty", null, "Too long!");
        }

        ValidationUtils.rejectIfEmpty(errors, "quantity",  "", null, "Not empty");
        if (quantity < 0){
            errors.rejectValue("quantity",  "", null, "Must be greater than 0!");
        }

        ValidationUtils.rejectIfEmpty(errors, "price",  "", null, "Not empty");
        if (price < 0){
            errors.rejectValue("price",  "", null, "Must be greater than 0!");
        }
    }
}
