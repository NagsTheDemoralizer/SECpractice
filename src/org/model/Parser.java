package org.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser
{
    private static Parser instance = null;

    // private constructor restricted to this class itself
    private Parser()
    {
    }

    public static ArrayList<Long> inputParser(String file)
    {
        String fileName = "C:\\Users\\anagr\\OneDrive\\Documents\\Github\\SECpractice\\src\\org\\model\\" + file;
        fileName = "/Users/dainemcniven/Documents/University/SEC/" + file;
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
        ArrayList<Long> intlist = new ArrayList<Long>();

        for (int x = 0; inputStream.hasNextLine(); x++) {
            intlist.add(inputStream.nextLong());
        }
        inputStream.close();

        /*
        for (int x = 0; x < intlist.size(); x++){
            System.out.println(intlist.get(x));
        }*/

        return intlist;

    }

    // static method to create instance of Singleton class
    public static Parser getInstance()
    {
        if (instance == null)
            instance = new Parser();

        return instance;
    }
}
