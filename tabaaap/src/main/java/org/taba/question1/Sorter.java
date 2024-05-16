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
import java.util.*;

/** This will sort the file */
public class Sorter
{
    public void sortFile(String filePath, int columnIndex) throws IOException
    {
        //Instantiating the classes
        BufferedReader myBufferedReader = new BufferedReader(new FileReader(filePath));

        //Skip the header
        myBufferedReader.readLine();

        //Local variable
        String line;

        // List to store the rows
        List<Row> rows = new ArrayList<>();

        //Read the rest of the lines and store the wages
        while ((line = myBufferedReader.readLine()) != null)
        {
            //Create a new Row object for each line and add it to the list
            Row row = new Row(line);
            rows.add(row);
        }

        //Sort the rows based on the specified column index
        Collections.sort(rows, getComparator(columnIndex));

        //Printing...
        Printer myPrinter = new Printer();
        myPrinter.printSortedRows(rows);

        //Close the BufferedReader
        myBufferedReader.close();
    }

    public Comparator<Row> getComparator(int columnIndex)
    {
        return new Comparator<Row>()
        {
            @Override
            public int compare(Row row1, Row row2)
            {
                String value1 = String.valueOf(extractValue(row1, columnIndex));
                String value2 = String.valueOf(extractValue(row2, columnIndex));

                //Handle String data type for column (1First Name, 2Second Name, 3Dept)
                if (columnIndex == 1 || columnIndex == 2 || columnIndex == 3)
                {
                    return value1.compareTo(value2);
                }

                //Handle double data type for all other columns
                else if (columnIndex == 4 || columnIndex == 5)
                {
                    double doubleValue1 = Double.parseDouble(value1);
                    double doubleValue2 = Double.parseDouble(value2);
                    return Double.compare(doubleValue1, doubleValue2);
                }

                else
                {
                    return 0;
                }
            }
        };
    }

    public String extractValue(Row row, int columnIndex)
    {
        String[] values = row.getLine().split(",");
        return values[columnIndex];
    }
}
