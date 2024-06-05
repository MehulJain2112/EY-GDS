package com.ey.day8assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectCallDetails {
    public static void main(String[] args) {
        List<CallDetailRecord> callDetails = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter from number:");
            int fromNumber = scanner.nextInt();
            
            System.out.println("Enter to number:");
            int toNumber = scanner.nextInt();
            
            System.out.println("Enter duration in minutes:");
            float duration = scanner.nextFloat();
            
            float charge = duration * 1.0f;
            
            callDetails.add(new CallDetailRecord(fromNumber, toNumber, duration, charge));
            
            System.out.println("Do you want to add another record? (Yes/No)");
            String response = scanner.next().toLowerCase();
            
            if (response.equals("no")) {
                break;
            }
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ChargeRecord.ser"))) {
            oos.writeObject(callDetails);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}
