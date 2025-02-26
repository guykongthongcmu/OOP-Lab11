//672115045 Virawit Kongthong OOP-Lab11 Question 2

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) throws IOException{
        try {
            File createFile = new File("RWdata.txt");
            if (createFile.createNewFile()) {
                FileWriter writer = new FileWriter("RWdata.txt");
                Random rand = new Random();
                for (int i = 0; i < 100; i++) {
                    writer.write(rand.nextInt(100)+ " ");
                }
                writer.close();

                // read from file to sort
                try {
                    File f = new File("RWdata.txt");
                    Scanner readFile = new Scanner(f);
                    ArrayList<Integer> numList = new ArrayList<Integer>();
                    while (readFile.hasNextInt()) {
                        numList.add(readFile.nextInt());
                    }
                    // sort
                    ArrayList<Integer> sortedList = insertionSort(numList);
                    System.out.println(sortedList);
                    readFile.close();

                } catch (IOException e) {
                    System.out.println("File not found!" + e.getMessage());
                    e.printStackTrace();
                }
                
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j+1, list.get(j));
                j -= 1;
            }
            list.set(j+1, key);
        }
        return list;
    }
}

