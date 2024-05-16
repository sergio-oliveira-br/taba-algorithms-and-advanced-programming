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
 *              ---
 * b)	Write a recursive method to compute the sum of every even-indexed row of either the wage column.
 */

package org.taba.question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Recursive method to compute the sum of every even-indexed row of either the wage column */
public class RecursiveSum
{
    /**Instantiating the Wage Column class */
    WageColumn myWageColumn = new WageColumn();

    public double recursiveSum(String filePath) throws IOException
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            return recursiveSumEvenIndex(bufferedReader, 0, 0);
        }
    }

    public double recursiveSumEvenIndex(BufferedReader bufferedReader, int currentRow, double sum) throws IOException
    {
        //Local variable
        String line;

        //Read the line
        line = bufferedReader.readLine();

        //Base case: Stop recursion when there are no more lines to read
        if (line == null)
        {
            bufferedReader.close();
            return sum;
        }

        //Process the line only if the row is even
        if (currentRow % 2 == 0)
        {
            //Printing to checking...
            Printer myPrinter = new Printer();
            myPrinter.printLine(line);

            double wage = myWageColumn.extractWageColumn(line);
            sum += wage;
        }

        //Recursive case: keep doing recursion with the next line
        return recursiveSumEvenIndex(bufferedReader, currentRow + 1, sum);
    }
}
