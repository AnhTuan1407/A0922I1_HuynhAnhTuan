package codegym.vn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findProductByName",
                query = "select p from Product p where p.nameProduct like '%:name%'")
})
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @NotBlank(message = "Không được để trống!")
    @Column(name = "product_name", columnDefinition = "varchar(100)")
    private String nameProduct;

    @Min(1)
    @Column(name = "quantity")
    private int quantity;

    @Min(1)
    @Column(name = "price")
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_release")
    private Date dateRelease;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public Product() {
    }

    public Product(Integer id, String nameProduct, int quantity, double price, Date dateRelease, Category category) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.dateRelease = dateRelease;
        this.category = category;
    }

    public Product(String nameProduct, int quantity, double price, Date dateRelease, Category category) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.dateRelease = dateRelease;
        this.category = category;
    }
}
