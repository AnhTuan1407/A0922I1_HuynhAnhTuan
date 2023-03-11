package on_tap_module2.model;

import java.util.Scanner;

public abstract class Card {
    private String numCard;
    private String nameCard;
    private String identityCard;
    private String address;

    public Card() {
    }

    public Card(String numCard, String nameCard, String identityCard, String address) {
        this.numCard = numCard;
        this.nameCard = nameCard;
        this.identityCard = identityCard;
        this.address = address;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Card{" +
                "numCard='" + numCard + '\'' +
                ", nameCard='" + nameCard + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number card: ");
        this.numCard = scanner.nextLine();
        System.out.println("Enter name card: ");
        this.nameCard = scanner.nextLine();
        System.out.println("Enter identity card: ");
        this.identityCard = scanner.nextLine();
        System.out.println("Enter address: ");
        this.address = scanner.nextLine();
    }
}
