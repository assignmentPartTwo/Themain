/*
* Date: 2021 May 5rd
* Name: William Wu && Ian Huang
* Teacher: Mr.Ho
* Description: Method summative assignment part two
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class methodAssignmentPartTwo {
    public static void main(String[] args){
        // use a for loop to identify the frequency of numbers 1- 9 appearing as the
        // first number in the sales csv. store the integer into an array from indexes
        // 1 to 8 (length 9).
        // call a method that in a for loop, and parameter of the freqeuncy array, divide each
        // integer in the indexes by 1621 or do it right after storing the frequency into the array
        // percentage: frquency of each number divide by 1621  <-- parameter for bar graph 

        // a temporary double
        double[] deleteLater = {700, 400, 176, 80, 70, 60, 50, 45, 40};
        findPercent(deleteLater);   // call findPercent method

        // Detect for errors when generating the results file
        try {
            exportChart(deleteLater);   // call exportChart method
        }
        catch (Exception e) {
            System.out.println("File error");
        }
    }
    /**
     * Description: a method to calculate the percentage of how frequent each number 
     *              appears in the sale file. 
     *    % = (frequency / number of rows in csv file) x 100 %
     * 
     * @author Ian
     * @param frequency   The array containing the frequency of #1 - 9 being the first number
     */
    public static void findPercent(double[] frequency) {
        for (int i = 0; i < frequency.length; i++) {
            // going through each index to find the percentage, rounded to
            // one decimal place
            frequency[i] = Math.round( frequency[i] / 16.21 * 10.0 )/10.0;
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
    public static void readFile(String path) throws FileNotFoundException{
        // The path to the csv file
        path = "sales.csv";

        //Parsing a csv file into BufferedReader class constructor
        Bufferedreader br = new BufferedReader(new FileReader(path));

        // Variable line that equals to nothing right now
        String line = "";

        // Try, catch, and finally statement are for if the code goes wrong
        // Try block goes first 
        try{
            // A while loop that infinantly go over the file and read each line unitl it is empty
            while((line = br.readLine()) != null){
                // A string array that seperates the different infos by the comma in the file
                String[] value = line.split(",");
            }
        }
        // The two catch files are for if the file is not found from the file path, they will print the files' stack trace
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        // Finally block that will be executed in every case, success or caught exception
        finally{
            // Close the bufferscanner if all lines in the file is read
            if(br != null){
                try{
                    br.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}