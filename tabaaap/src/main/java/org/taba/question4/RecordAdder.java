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
 * Question 4: a)Write a Java program that accepts a new record, and adds it at the end of the record array
 * Chosen File: staff.csv
 */
package org.taba.question4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordAdder
{
    /**This method will add a new record into my file*/
    public void addRecord(String filePath, String[] record) throws IOException, InputExceptions
    {
        /** Handle Exceptions Question (b) */
        //First Name
        if (record[1].isEmpty() || record[1].matches("\\d+")) //any string containing  digits
        {
            throw new InputExceptions ("Employee first_name cannot be empty. It cannot have only digits! Please correct this");
        }

        //Reading the file to find the last EmpNo
        int lastEmpNo = getLastEmpNo(filePath);

        //Add a number
        lastEmpNo++;

        //Add new record
        record[0] = Integer.toString(lastEmpNo);

        try (PrintWriter myWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true))))
        {
            StringBuilder mySBuilder = new StringBuilder();
            for (String field : record) {
                mySBuilder.append(field).append(",");
            }
            //Removes the last comma and adds a new line
            mySBuilder.deleteCharAt(mySBuilder.length() - 1);
            myWriter.println(mySBuilder.toString());
            System.out.println("New record has been added successfully.");
        }
    }

    /**This method find the last num in my file */
     public int getLastEmpNo(String filePath) throws IOException {
         List<Integer> empNos = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             String line;

             reader.readLine(); //skip the header
             while ((line = reader.readLine()) != null)
             {
                 String[] fields = line.split(",");
                 int empNo = Integer.parseInt(fields[0]);
                 empNos.add(empNo);
             }
         }
         //Find the last EmpNo
         int lastEmpNo = 0;
         for (int empNo : empNos) {
             if (empNo > lastEmpNo) {
                 lastEmpNo = empNo;
             }
         }
         System.out.println("My Last Emp No: " + lastEmpNo);
         return lastEmpNo;
     }

     /**This method is for question 4.b -> handle input exceptions  */

}
