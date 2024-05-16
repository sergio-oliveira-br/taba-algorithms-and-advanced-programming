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

/** Extract the Wage column */
public class WageColumn
{
    public double extractWageColumn(String line)
    {
        //going to column number 5 (wage)
        String[] parts = line.split(",");
        try
        {
            double wage = Double.parseDouble(parts[4]);
            return wage;
        }

        catch (NumberFormatException e)
        {
            //e.printStackTrace();
            return -1;
        }
    }
}
