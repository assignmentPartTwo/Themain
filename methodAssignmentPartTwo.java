/*
* Date: 2021 May 5rd
* Name: William Wu && Ian Huang
* Teacher: Mr.Ho
* Description: Method summative assignment part two
**/

import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class methodAssignmentPartTwo {
    public static void main(String[] args){

        // a temporary double
        double[] deleteLater = {700, 400, 176, 80, 70, 60, 50, 45, 40};


        // Detect for errors when generating the results file
        try {
            exportChart(deleteLater);   // call exportChart method
        }
        catch (Exception e) {
            System.out.println("File error");
        }
    }    
    /**
     * Description: output the percentage of each number as a chart in a new
     *              csv file.
     * @author Ian
     * @param csvLine       the array holding the percentage of how often each number appears
     * @throws IOException  if input or output exception has occured when appending on a file
     */
    public static void exportChart(double[] csvLine) throws IOException {
        File outFile = new File("results.csv");    // creating a csv file

        FileWriter fr = new FileWriter(outFile, true);  // boolean to append
        BufferedWriter br = new BufferedWriter(fr);     // initialize buffer writer
        PrintWriter out = new PrintWriter(br);      // let printwriter access the file

        for (int i = 1; i < 10; i++) {
            out.write(i + " = " + csvLine[i-1] + "%");      // editing the file
            out.write("\n");
        }

        // provides the location and name of the file
        System.out.println("File located at: " + outFile.getAbsolutePath() + "\nName: results.csv");
        System.out.println("\nDone\n");
        out.close();    // closing print writer
        br.close();     // closing buffer writer
        fr.close();     // closing file writer
    }
}
