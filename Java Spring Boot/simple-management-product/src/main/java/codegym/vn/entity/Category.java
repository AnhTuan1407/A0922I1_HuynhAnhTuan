package codegym.vn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;
    @Column(columnDefinition = "varchar(100)")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(Integer id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }
}
