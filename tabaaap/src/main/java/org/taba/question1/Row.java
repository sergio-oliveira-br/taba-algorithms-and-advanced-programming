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

/** The proposal is to encapsulate a complete line of the CSV file */
public class Row implements Comparable<Row>
{
    //Instance variables
    String line;
    double wage;

    //Constructor
    public Row (String line)
    {
        this.line = line;
        this.wage = new WageColumn().extractWageColumn(line);
    }

    public String getLine()
    {
        return line;
    }

    /** We covered this on Data Structures with Keith Maycock in Data Structure and Algorithms */
    @Override
    public int compareTo(Row other)
    {
        return Double.compare(this.wage, other.wage);
    }
}
