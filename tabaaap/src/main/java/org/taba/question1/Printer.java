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

import java.util.List;

public class Printer
{
    public void printLine(String line)
    {
        String[] column = line.split(",");

        //Formatting the columns
        System.out.printf("%-10s %-15s %-15s %-15s %-10s %-10s%n",
                column[0], column[1], column[2], column[3], column[4], column[5]);

    }

    public void printSortedRows(List<Row> rows)
    {
        Printer printer = new Printer();
        for (Row row : rows) {
            printer.printLine(row.getLine());
        }
    }
}
