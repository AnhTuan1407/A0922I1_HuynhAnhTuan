package on_tap_module2.service;

import on_tap_module2.model.ATM;
import on_tap_module2.model.Credit;
import on_tap_module2.until.ReadAndWriteATM;
import on_tap_module2.until.ReadAndWriteCredit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditService implements IService {
    List<Credit> creditList = new ArrayList<>();
    ReadAndWriteCredit readAndWriteCredit = new ReadAndWriteCredit();

    @Override
    public void addNew() {
        Credit credit = new Credit();
        credit.input();
        creditList.add(credit);
        readAndWriteCredit.writeCredit(creditList, "src/on_tap_module2/data/data", true);
        creditList = new ArrayList<>();
    }

    @Override
    public void display() {
        creditList = readAndWriteCredit.readCredit("src/on_tap_module2/data/data");
        for (Credit credit : creditList) {
            System.out.println(credit);
        }
    }

    @Override
    public void remove() {
        creditList = readAndWriteCredit.readCredit("src/on_tap_module2/data/data");
        Credit creditObj = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card number you want to remove: ");
        String numberCard = scanner.nextLine();
        for (Credit credit : creditList) {
            if (credit.getNumCard().equals(numberCard)) {
                System.out.println(credit);
                creditObj = credit;
                System.out.println("Search Successful");
            }
        }
        if (creditObj == null) {
            System.out.println("Not Found!");
        }
        System.out.println("Are you sure you want to delete this card(Y/N): ");
        String choice1 = scanner.nextLine();
        if (choice1.equals("Y") || choice1.equals("y")) {
            for (Credit credit : creditList) {
                if (credit.getNumCard().equals(numberCard)) {
                    System.out.println(credit);
                    creditObj = credit;
                }
            }
            if (creditObj != null) {
                creditList.remove(creditObj);
                System.out.println("Remove Successful");
                readAndWriteCredit.writeCredit(creditList, "src/on_tap_module2/data/data", false);
            } else {
                System.out.println("Not Found!");
            }
        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        creditList = readAndWriteCredit.readCredit("src/on_tap_module2/data/data");
        System.out.println("Enter number card you want to search: ");
        String numberCard = scanner.nextLine();
        Credit creditObj = null;
        for (Credit credit : creditList) {
            if (credit.getNumCard().equals(numberCard)) {
                System.out.println(credit);
                creditObj = credit;
                System.out.println("Search Successful");
            }
        }
        if (creditObj == null) {
            System.out.println("Not Found!");
        }
    }
}
