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
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}

import java.io.*;
import java.util.List;

public class DisplayCallDetails {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ChargeRecord.ser"))) {
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
