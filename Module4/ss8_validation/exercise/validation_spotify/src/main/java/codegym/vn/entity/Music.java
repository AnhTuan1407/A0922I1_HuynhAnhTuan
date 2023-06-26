package codegym.vn.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Music implements Validator {

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
        name = music.getName();
        singer = music.getSinger();
        kindOfMusic = music.getKindOfMusic();
        String[] specialCharacters = { "@", ";", ".", "=", "-", "+"};

        // Validate name
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        if (name.length() > 50) {
            errors.rejectValue("name", "name.length");
        }
        for (int i = 0; i < specialCharacters.length; i++){
            if (name.contains(specialCharacters[i]) || name.contains(",")){
                errors.rejectValue("name", "name.special");
                break;
            }
        }

        // Validate singer
        ValidationUtils.rejectIfEmpty(errors, "singer", "singer.empty");
        if (singer.length() > 50) {
            errors.rejectValue("singer", "singer.length");
        }
        for (int i = 0; i < specialCharacters.length; i++){
            if (singer.contains(specialCharacters[i]) || singer.contains(",")){
                errors.rejectValue("singer", "singer.special");
                break;
            }
        }

        // Validate kind of music
        ValidationUtils.rejectIfEmpty(errors, "kindOfMusic", "kindOfMusic.empty");
        if (kindOfMusic.length() > 50) {
            errors.rejectValue("kindOfMusic", "kindOfMusic.length");
        }
        for (int i = 0; i < specialCharacters.length; i++){
            if (kindOfMusic.contains(specialCharacters[i])){
                errors.rejectValue("kindOfMusic", "kindOfMusic.special");
                break;
            }
        }
    }
}
