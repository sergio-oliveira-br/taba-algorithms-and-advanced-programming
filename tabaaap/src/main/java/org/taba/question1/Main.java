/** National College of Ireland - NCI
 * Higher Diploma in Science in Computing
 *              ---
 * Terminal Based Assignment Assessment
 * From 15 May 2024 to 18 May 2024
 *              ---
 * Algorithms and Advanced Programming
 * Lecturer: Dr. William Clifford
 *              ---
 * Student: Sergio Vinicio da Silva Oliveira
 * x23170981@student.ncirl.ie
 *              ---
 * Question 1: Using a data file you have NOT previously worked on for the CA
 * Chosen File: staff.csv
 */
package org.taba.question1;

import org.taba.question4.InputExceptions;
import org.taba.question4.RecordAdder;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        /** Instance Variables */
        int userChoice; //used on Menu option

        /** My File */
        String filePath = "/Users/sergiovinicio/NCI/Algorithms and Advanced Programming/TABA - AAP/tabaaap/Staff.csv";

        /** Instantiating the classes */
        MenuOption myMenuOption = new MenuOption();         //Display the menuQuestion1, which contains the choices from answers (a) to (e)
        Reader myReader = new Reader();                     //Responsible to reade the CSV file
        Printer myPrinter = new Printer();                  //Responsible to print the CSV file (Question (a))
        RecursiveSum myRecursiveSum = new RecursiveSum();   //Responsible to calculate the sum of every even-indexed (Question (b))
        Filter myFilter = new Filter();                     //Responsible to apply filter, such as odd number (Question (c))
        Sorter mySorter = new Sorter();                     //Responsible to sort the file for all possible columns (Question (d))
        RecordAdder myRecordAdder = new RecordAdder();      //Responsible to add new line into my csv file (Question 4)

        Scanner sc = new Scanner(System.in);                //Responsible only for get input from the user

        /** Welcome and Menu */
        System.out.println("On CA I worked on Stock File.");
        System.out.println("*** \nWelcome to TABA - AAP");

        myMenuOption.menuQuestion();
        userChoice = sc.nextInt();

        /** Options */
        switch (userChoice)
        {
            /** Read and Print */
            case 1:
                System.out.println("Printing the file ...");
                try
                {
                    List<String> fileData = myReader.readData(filePath);

                    for (String line : fileData)
                    {
                        myPrinter.printLine(line);
                    }
                }

                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                break;

            /** Recursive method to compute the sum of every even-indexed row of either the wage */
            case 2:
                System.out.println("Sum of every even-indexed row of either the wage ...");
                double sum = myRecursiveSum.recursiveSum(filePath);

                //Create a new DecimalFormat
                DecimalFormat df = new DecimalFormat("#.##");

                //Formating
                String formattedSum = df.format(sum);

                System.out.println("Sum of every even-indexed row of the wage column: " + formattedSum);
            break;

            /** Iterative method to find the minimum value. Only the odd indexes */
            case 3:
                double minWage = myFilter.findMinWageOddEmpNo(filePath);
                System.out.println("Minimum wage in the wage column (odd indexes only): " + minWage);
            break;

            /** Sorting method for all possible columns in the data file */
            case 4:
                myMenuOption.menuColumns();
                System.out.println("Enter the column index to sort:");
                int columnIndex = sc.nextInt();

                mySorter.sortFile(filePath, columnIndex);
            break;

            /** Multi-thread Solution, save files based on columns*/
            case 5:
                //local variable
                int numOfColumns = 5;

                //Creating a new object (thread) for each column of my file
                for (int i = 1; i <= numOfColumns; i++) {
                    MultiThreadSort myMultiThread = new MultiThreadSort(filePath, i);
                    myMultiThread.start();

                    try
                    {
                        myMultiThread.join(); //Wait for the thread
                    } catch (InterruptedException e) {
                        System.out.println("Error occurred while sorting file.");
                        e.printStackTrace();
                    }
                }
            break;

            /** Question 4 - Add new Staff and Save */
            case 6:
                System.out.println("Adding a new record...");

                                    //ID, FistName, SecondName, Depart, Wages, Rate
                String[] newRecord = {"", "Sergio", "Oliveira123", "IT", "999", "01299"};
                try
                {
                    myRecordAdder.addRecord(filePath, newRecord);
                } catch (InputExceptions e) {
                    throw new RuntimeException(e);
                }
            break;

            /** Exit */
                case 7:
                    System.out.println("This was TABA - AAP \nby Sergio Oliveira - x23170981@student.ncirl.ie ");
            break;
        }
    }
}