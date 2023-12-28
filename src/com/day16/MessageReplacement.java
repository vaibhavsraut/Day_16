package com.day16;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageReplacement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        message = message.replaceAll("<<name>>", "John");
        message = message.replaceAll("<<full name>>", "John Doe");
        message = message.replaceAll("91-xxxxxxxxxx", "91-9876543210");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        System.out.println("Modified Message:");
        System.out.println(message);

        scanner.close();
    }
}