package org.launchcode;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestClass
{

    public static void main(String[] args)
    {

        //  Reading input file name from keyboard
        //	System.out.print("Enter file name: ");
        //	Scanner keyBoard = new Scanner(System.in);
        //	String fileName = keyBoard.next();

        String fileName = "C:\\Users\\anagr\\OneDrive\\Documents\\Github\\SECpractice\\src\\org\\model\\test.txt";
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
        ArrayList<Integer> intlist = new ArrayList<Integer>();

        for (int x = 0; inputStream.hasNextLine(); x++)
        {
            //alist.add(inputStream.nextLine());

        intlist.add(inputStream.nextInt());

        }
        inputStream.close();

        for (int x = 0; x < intlist.size(); x++){
            System.out.println(intlist.get(x));
        }

    }
}
