package org.taba.question1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;


public class Writer
{
    public boolean saveFile(List<String> rows, int columnIndex, String filePath) throws IOException
    {
        String fileName = getFileName(filePath, columnIndex);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))
        {
            for (String line : rows)
            {
                writer.println(line);
            }
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }




    /** Generate a new file name based on path and column index*/
    public String getFileName(String originalFilePath, int columnIndex)
    {
        return originalFilePath.replace(".csv", "_sorted_column_" + columnIndex + ".csv");
    }
}
