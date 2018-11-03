package org.launchcode;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestClass {

    public static void main(String[] args)
    {

        //  Reading input file name from keyboard
        //	System.out.print("Enter file name: ");
        //	Scanner keyBoard = new Scanner(System.in);
        //	String fileName = keyBoard.next();

        String fileName = "testfile0.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName +
                "\ncontains the following lines:\n");

        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " +
                    fileName);
            System.exit(0);
        }

        //ArrayList<String> alist = new ArrayList<>();
        ArrayList<Double> doublist = new ArrayList<Double>();

        for (int x = 0; inputStream.hasNextLine(); x++)
        {
            //alist.add(inputStream.nextLine());
            doublist.add(inputStream.nextDouble());

        }
        inputStream.close();

        ArrayList<Integer> busStops = new ArrayList<Integer>();
        double num = doublist.get(0);
        while(num > 0){
            busStops.add((int)(num % 1000000));
            num = num / 1000000;
        }

        for (int x = 0; x < busStops.size(); x++){
            System.out.println(busStops.get(x));
        }

    }
}
