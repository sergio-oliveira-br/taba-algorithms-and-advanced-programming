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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**Multi-thread solution, where each thread sorts a copy of the data
 *  in a different order depending on the column being sorted.
 *  i.e., thread 1: sorts based on column 1, thread 2: sorts based on column 2, and so on.
 *  A copy of each order should be saved to a different file. */
public class MultiThreadSort extends Thread
{
    //Instance Variables
    String filePath;
    int columnIndex;
    String savedFilePath;

    //Creat an object
    Reader myReader = new Reader();
    Writer myWriter = new Writer();
    List<String> data;

    //Constructor
    public MultiThreadSort(String filePath, int columnIndex) throws FileNotFoundException
    {
        this.filePath = filePath;
        this.columnIndex = columnIndex;
    }

    @Override
    public void run()
    {
        try
        {
            //Sorting...
            Sorter mySorter = new Sorter();
            mySorter.sortFile(filePath, columnIndex);

            List<String> data = myReader.readData(filePath);

            boolean fileSaved = myWriter.saveFile(data, columnIndex,filePath);
            if (fileSaved)
            {
                savedFilePath = myWriter.getFileName(filePath, columnIndex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
