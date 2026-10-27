package com.pluralsight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("What date will you be coming (MM/DD/YYYY): ");
        String dateInput = scanner.nextLine().trim();

        System.out.print("How many tickets would you like? ");
        int numTickets = Integer.parseInt(scanner.nextLine().trim());

        scanner.close();

        String lastName = "";
        String firstName = "";
        int lastSpaceIndex = fullName.lastIndexOf(' ');

        if (lastSpaceIndex != -1) {
            firstName = fullName.substring(0, lastSpaceIndex);
            lastName = fullName.substring(lastSpaceIndex + 1);
        } else {
            firstName = "";
            lastName = fullName;
        }
        String formattedName = lastName + ", " + firstName;

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateInput, inputFormatter);
        String formattedDate = parsedDate.toString();

        String ticketWord = (numTickets >= 1) ? "ticket" : "tickets";

        System.out.println(numTickets + " " + ticketWord + " reserved for " + formattedDate + " under " + formattedName);
    }
}