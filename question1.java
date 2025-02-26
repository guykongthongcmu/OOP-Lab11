//672115045 Virawit Kongthong OOP-Lab11 Question 1¬

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        try {
            System.out.println("Enter the file path:");
            String filePath = userInput.nextLine();
            
            File file = new File(filePath);
            Scanner readFile = new Scanner(file);
            
            int count = 0;
            double total = 0, avg;
            
            while (readFile.hasNext()) {
                String num = readFile.nextLine();
                count++;
                total += Double.parseDouble(num);
            }
            
            avg = total / count;
            
            System.out.println("Total: " + total);
            System.out.println("Average: " + avg);
            
            readFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while parsing numbers from the file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            userInput.close();
        }
    }
}
