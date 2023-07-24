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
    @Column(columnDefinition = "varchar(50)", name = "product_name")
    private String productName;
    @Column(name = "price")
    private double price;

    @Column(columnDefinition = "varchar(50)", name = "status")
    private String status = "Chờ duyệt";

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, double price, String status, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Product(String productName, double price, String status, Category category) {
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        productName = product.getProductName();
        price = product.getPrice();

        ValidationUtils.rejectIfEmpty(errors, "productName", "productName.empty", null, "Not empty");
        if (productName.length() > 50 || productName.length() < 5){
            errors.rejectValue("productName",  "productName.empty", null, "Tên sản phẩm từ 5 đến 50 ký tự!");
        }

        ValidationUtils.rejectIfEmpty(errors, "price",  "", null, "Not empty");
        if (price < 100000){
            errors.rejectValue("price",  "", null, "Must be greater than 100000 VND!");
        }
    }
}
