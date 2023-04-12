package lesson16_text_file.read_file;

public class Country {
    public String id;
    public String acronym;
    public String nameCountry;

    public Country() {
    }

    public Country(String id, String acronym, String nameCountry) {
        this.id = id;
        this.acronym = acronym;
        this.nameCountry = nameCountry;
    }

    public Country(String[] result) {
        this.id = result[0];
        this.acronym = result[1];
        this.nameCountry = result[2];
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", acronym='" + acronym + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
