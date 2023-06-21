package codegym.vn.entity;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(50)")
    private String blogGenre;
    @Column(columnDefinition = "varchar(150)")
    private String name;
    @Column(columnDefinition = "varchar(150)")
    private String title;
    @Column(columnDefinition = "varchar(250)")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogGenre() {
        return blogGenre;
    }

    public void setBlogGenre(String blogGenre) {
        this.blogGenre = blogGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog() {
    }

    public Blog(Integer id, String blogGenre, String name, String title, String content) {
        this.id = id;
        this.blogGenre = blogGenre;
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public Blog(String blogGenre, String name, String title, String content) {
        this.blogGenre = blogGenre;
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
