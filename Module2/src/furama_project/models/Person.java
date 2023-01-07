package furama_project.models;

public abstract class Person {
    protected String idPerson;
    protected String namePerson;
    protected String dateOfBirth;
    protected String sex;
    protected String identityCard;
    protected String phoneNumber;
    protected String emailAddress;

    public Person() {
    }

    public Person(String idPerson, String namePerson, String dateOfBirth, String sex, String identityCard, String phoneNumber, String emailAddress) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
