package on_tap_module2.service;

import on_tap_module2.model.ATM;
import on_tap_module2.until.ReadAndWriteATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMService implements IService {
    List<ATM> atmList = new ArrayList<>();
    ReadAndWriteATM readAndWriteATM = new ReadAndWriteATM();

    @Override
    public void addNew() {
        ATM atm = new ATM();
        atm.input();
        atmList.add(atm);
        readAndWriteATM.writeATM(atmList, "src/on_tap_module2/data/data", true);
        atmList = new ArrayList<>();
    }

    @Override
    public void display() {
        atmList = readAndWriteATM.readATM("src/on_tap_module2/data/data");
        for (ATM atm : atmList) {
            System.out.println(atm);
        }
    }

    @Override
    public void remove() {
        atmList = readAndWriteATM.readATM("src/on_tap_module2/data/data");
        ATM atmObj = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card number you want to remove: ");
        String numberCard = scanner.nextLine();
        for (ATM atm : atmList) {
            if (atm.getNumCard().equals(numberCard)) {
                System.out.println(atm);
                atmObj = atm;
                System.out.println("Search Successful");
            }
        }
        if (atmObj == null) {
            System.out.println("Not Found!");
        }
        System.out.println("Are you sure you want to delete this card(Y/N): ");
        String choice1 = scanner.nextLine();
        if (choice1.equals("Y") || choice1.equals("y")) {
            for (ATM atm : atmList) {
                if (atm.getNumCard().equals(numberCard)) {
                    System.out.println(atm);
                    atmObj = atm;
                }
            }
            if (atmObj != null) {
                atmList.remove(atmObj);
                System.out.println("Remove Successful");
                readAndWriteATM.writeATM(atmList, "src/on_tap_module2/data/data",false);
            } else {
                System.out.println("Not Found!");
            }
        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        atmList = readAndWriteATM.readATM("src/on_tap_module2/data/data");
        System.out.println("Enter number card you want to search: ");
        String numberCard = scanner.nextLine();
        ATM atmObj = null;
        for (ATM atm : atmList) {
            if (atm.getNumCard().equals(numberCard)) {
                System.out.println(atm);
                atmObj = atm;
                System.out.println("Search Successful");
            }
        }
        if (atmObj == null) {
            System.out.println("Not Found!");
        }
    }

    public void transfer() {
        String num1, num2;
        Scanner scanner = new Scanner(System.in);
        atmList = readAndWriteATM.readATM("src/on_tap_module2/data/data");
        System.out.println("Enter the transfer card number: ");
        num1 = scanner.nextLine();
        ATM card1 = null;
        ATM card2 = null;
        for (ATM atm : atmList) {
            if (atm.getNameCard().equals(num1)) {
                System.out.println(atm);
                card1 = atm;
                break;
            }
        }
        if (card1 == null) {
            System.out.println("Not Found!");
        }

        System.out.println("Enter the receiving card number: ");
        num2 = scanner.nextLine();
        for (ATM atm : atmList) {
            if (atm.getNameCard().equals(num2)) {
                System.out.println(atm);
                card2 = atm;
                break;
            }
        }
        if (card2 == null) {
            System.out.println("Not Found!");
        }
        System.out.println("Enter the amount you want to transfer: ");
        double money = scanner.nextDouble();
        if (card1.getSurplus() < money) {
            System.out.println("Insufficient balance!");
        } else {
            card1.setSurplus(card1.getSurplus() - money);
            card2.setSurplus(card1.getSurplus() + money);
            System.out.println("Money transfer successful!");
        }
    }
}
