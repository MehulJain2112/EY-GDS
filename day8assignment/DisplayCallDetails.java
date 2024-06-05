package com.ey.day8assignment;

import java.io.*;
import java.util.List;

public class DisplayCallDetails {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ChargeRecord.ser"))) {
            @SuppressWarnings("unchecked")
			List<CallDetailRecord> callDetails = (List<CallDetailRecord>) ois.readObject();
            
            for (CallDetailRecord record : callDetails) {
                System.out.println("From Number: " + record.getFromNumber());
                System.out.println("To Number: " + record.getToNumber());
                System.out.println("Charge: " + record.getCharge());
                System.out.println("------------------------");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
