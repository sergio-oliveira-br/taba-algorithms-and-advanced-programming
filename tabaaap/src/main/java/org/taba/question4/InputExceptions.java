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
 * Question 4: b) Java Exception that handles special cases and communicates to users to correct the cases.
 * Chosen File: staff.csv
 */
package org.taba.question4;

public class InputExceptions extends Exception {
    public InputExceptions(String message) {
        super(message);
    }
}
