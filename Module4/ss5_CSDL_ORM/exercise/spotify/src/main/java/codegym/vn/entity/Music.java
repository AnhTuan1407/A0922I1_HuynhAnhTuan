package codegym.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Music {

    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    private String singer;
    private String kindOfMusic;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Music(int id, String name, String singer, String kindOfMusic, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.link = link;
    }

    public Music() {
    }

    public Music(String name, String singer, String kindOfMusic, String link) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.link = link;
    }
}
