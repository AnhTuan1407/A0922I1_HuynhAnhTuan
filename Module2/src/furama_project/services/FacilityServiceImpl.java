package furama_project.services;

import furama_project.models.Facility;
import furama_project.models.House;
import furama_project.models.Room;
import furama_project.models.Villa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {

    LinkedHashMap<String, Integer> services = new LinkedHashMap<>();
    ArrayList<Villa> villas = new ArrayList<>();
    ArrayList<House> houses = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    @Override
    public void displayFacilityMaintenance() {
        System.out.println(services.entrySet());
    }

    @Override
    public void addNew() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add new Villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Back to menu");
            System.out.println("Enter your choice: ");
            int n = scanner.nextInt();
            switch (n) {
                case 1: {
                    Villa villa = new Villa();
                    villa.input();
                    villas.add(villa);
                    if (services.containsKey("villa")) {
                        int value = services.get("villa") + 1;
                        services.put("villa", value);
                    } else {
                        services.put("villa", 1);
                    }
                    break;
                }

                case 2: {
                    House house = new House();
                    house.input();
                    houses.add(house);
                    if (services.containsKey("house")) {
                        int value = services.get("house") + 1;
                        services.put("house", value);
                    } else {
                        services.put("house", 1);
                    }
                    break;
                }

                case 3: {
                    Room room = new Room();
                    room.input();
                    rooms.add(room);
                    if (services.containsKey("room")) {
                        int value = services.get("room") + 1;
                        services.put("room", value);
                    } else {
                        services.put("room", 1);
                    }
                    break;
                }
                case 4: {
                    return;
                }
            }
        }

    }

    @Override
    public void display() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n1. Display Villa");
            System.out.println("2. Display House");
            System.out.println("3. Display Room");
            System.out.println("4. Display All");
            System.out.println("5. Back to menu");
            System.out.println("Enter your choice: ");
            int n = scanner.nextInt();
            switch (n) {
                case 1: {
                    for (Villa villa : villas) {
                        villa.output();
                    }
                    break;
                }

                case 2: {
                    for (House house : houses) {
                        house.output();
                    }
                    break;
                }

                case 3: {
                    for (Room room : rooms) {
                        room.output();
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nVILLA");
                    for (Villa villa : villas) {
                        villa.output();
                    }

                    System.out.println("\nHOUSE");
                    for (House house : houses) {
                        house.output();
                    }

                    System.out.println("\nROOM");
                    for (Room room : rooms) {
                        room.output();
                    }
                    break;
                }
                case 5: {
                    return;
                }
            }
        }

    }

    @Override
    public void edit() {

    }
}
