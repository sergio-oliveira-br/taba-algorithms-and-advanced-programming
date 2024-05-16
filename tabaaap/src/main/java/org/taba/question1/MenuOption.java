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

public class MenuOption
{
    public void menuQuestion()
    {
        System.out.println("Menu Question 1 -> Chosen File:  Staff.csv\n" +
                "Please choose one of the following options:");

        System.out.println("    1. Read and Print the File.");
        System.out.println("    2. Sum of every even-indexed row of either the wage.");
        System.out.println("    3. Find the minimum value of wage, considering only the odd indexes.");
        System.out.println("    4. Sort columns");
        System.out.println("    5. Multi-threaded solution, where each thread sorts a copy of the data in a different order.");
        System.out.println("    6. Add new Staff (Question 4)");
        System.out.println("    7. Exit.");
    }

    public void menuColumns()
    {
        System.out.println("Menu Columns\n" + "Please choose one of the following options:");

        System.out.println("    0. Employee Number");
        System.out.println("    1. Fist Name");
        System.out.println("    2. Second Name");
        System.out.println("    3. Department");
        System.out.println("    4. Wage");
        System.out.println("    5. Project Completion Rate");
        System.out.println("    6. Exit.");
    }
}
