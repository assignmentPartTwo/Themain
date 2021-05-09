/*
* Date: 2021 May 5rd
* Name: William Wu && Ian Huang
* Teacher: Mr.Ho
* Description: Method summative assignment part two
**/

// importing all necessary packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class methodAssignmentPartTwo {
    public static void main(String[] args){

        // the array that will store the percent of frequency
        double[] frequency = new double[9];

        // try and catch error if no file is found
        try {
            readFile(frequency);        // call readFile method
        }
        catch(FileNotFoundException e){
            e.printStackTrace();        // output file not found results
        }
        finally {
            // fraud validation if number 1 (index 0) appears within the range of 29 - 32 %
            int min = 29;
            int max = 32;
            if (frequency[0] >= min && frequency[0] <= max) {
                System.out.println("No fraud has occured");
            }
            else {
                System.out.println("A fraud has likely occured");
            }
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

        // Detect for errors when generating the results file
        try {
            exportChart(frequency);   // call exportChart method
        }
        catch (IOException e) {
            System.out.println("An input/output error has occured");
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
    /**
     * Description: scans the sales.csv file
     * 
     * @author William Wu
     * @param hz the double array to store the frequency of digits (Hertz)
     * @throws FileNotFoundException if the file is not found exception has occured when scanning the file
     */
    public static void readFile(double[] hz) throws FileNotFoundException{
        // The path to the csv file
        String path = "sales.csv";

        //Parsing a csv file into BufferedReader class constructor
        BufferedReader br = new BufferedReader(new FileReader(path));

        // Variable line that equals to nothing right now
        String line = "";

        // Try, catch, and finally statement are for if the code goes wrong
        // Try block goes first 
        try{
            // A while loop that infinantly go over the file and read each line unitl it is empty
            while((line = br.readLine()) != null){
                // A string array that seperates the different infos by the comma in the file
                String[] value = line.split(",");

                // for loop that compares numbers 1 - 9 with the beginning number of each row of sales
                for (int i = 1; i < 10; i ++) {
                    int firstNum = value[1].charAt(0);      // the char at the first index of the sales amount
                    // condition: the value of the first number equals i(1- 9)
                    if (Character.getNumericValue(firstNum) == i) {
                        hz[i-1]++;    //accumulating the frequency of integers 1 to 9 being the fist number 
                    }
                }
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

            findPercent(hz);   // call findPercent method
        }
    }
}
