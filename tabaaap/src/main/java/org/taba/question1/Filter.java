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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filter
{
    public double findMinWageOddEmpNo(String filePath) throws IOException
    {
        double minWage = Double.MAX_VALUE;
        int rowIndex = 0;

        //Variable to store the line with the minimum wage
        String minWageLine = null;

        try(BufferedReader myBufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while((line = myBufferedReader.readLine()) != null)
            {
                if(rowIndex % 2 != 0)
                {
                    String[] columns = line.split(",");
                    double wage = Double.parseDouble(columns[4]);
                    if (wage < minWage)
                    {
                        minWage = wage;
                        minWageLine = line;
                    }
                }
                rowIndex++;
            }
        }
        //Print the line with the minimum wage
        System.out.println("Row with minimum wage... ");
        System.out.println("EmpNo, FistName, SecondName, Department, Wage, project_completion_rate\n" + minWageLine);
        return minWage;
    }
}
