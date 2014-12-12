package sample;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by Prasanna on 12/4/2014.
 */
public class CreateMatrices {

    static String newPlot;                      // stores the words of new plot
    /*
     * define the arrays to store
     * word count, words and
     * words of new plot
     */
    static double [][] wordCountMatrix;
    static double [][] exWordCountMatrix;
    static String [] wordMatrix;
    static double [] newWordMatrix;
    static double [] exNewWordMatrix;

    // array containing movie types
    static String [] movieInstances = {"Action", "Drama", "Horror", "Romance", "Thriller"};

    /*
     * read CSV file
     * insert data into wordCountMatrix
     */
    public static void createWordMatrix(String fileName){
        try {
            String line;
            // create file reader
            FileReader fileRd = new FileReader(fileName);
            BufferedReader readFile = new BufferedReader(fileRd);

            line = readFile.readLine();         // read the first line of words
            line = line.replaceAll("\"", "");    // replace all "s
            wordMatrix = line.split(",");       // split with commas and insert into word matrix
            wordCountMatrix = new double[movieInstances.length][wordMatrix.length]; // initialize wordCountMatrix
            int i = 0;
            while ((line = readFile.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] newLine = line.split(",");

                // count the number of words in each type
                double wordCount = 0;
                for (String x : newLine) {
                    wordCount += Double.parseDouble(x);
                }
                // insert each words' percentage occurrence
                for (int j = 0; j < newLine.length; j++) {
                    wordCountMatrix[i][j] = Double.parseDouble(newLine[j]) * 100 / wordCount;
                }
                i++;
            }
            //System.out.println("createWordMatrix: Done");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"DataSet file "+fileName+" should be here");
        }
    }

    /*
     * remove stop words from new plot
     * done word stemming for new plot
     * write words to new file newPlot
     */
    public static void newPlot(String filename, String txtPlot){
        if(txtPlot.isEmpty()) {
            newPlot = RemoveStopWords.createCleanFile(filename);
        }
        else {
            newPlot = RemoveStopWords.createCleanTxt(txtPlot);
        }
        //System.out.println("newPlot: Done");
        //System.out.println(newPlot);
    }

    /*
     * create matrix new plot words
     * add the word count to the matrix
     */
    public static void newPlotMatrix() throws IOException {
        newWordMatrix = new double[wordMatrix.length];  // initialize newWordMatrix
        String line = newPlot;
        String []s = line.split(" ");                   // split line using spaces
        int i = 0;
        for(String x:wordMatrix){
            int count = 0;
            for(String y:s){
                if(x.equals(y)){                        // check whether line has the word
                    count++;                            // get each word count
                }
            }
            newWordMatrix[i] = count;                   // enter count to matrix
            i++;
        }

        /*
         * newPlotMatrix have
         * words which not used
         * existing word matrices
         * increase the accuracy
         */
        int disWordCount = 0;                           // distinct word count
        for(double x:newWordMatrix){
            if(x != 0.0){
                disWordCount++;
            }
        }
        i = 0;
        exNewWordMatrix = new double[disWordCount];
        exWordCountMatrix = new double[movieInstances.length][disWordCount];
        for(int j=0;j<wordMatrix.length;j++){
            if(newWordMatrix[j] != 0.0) {
                exNewWordMatrix[i] = newWordMatrix[j];
                for (int k = 0; k < movieInstances.length; k++) {
                    exWordCountMatrix[k][i] = wordCountMatrix[k][j];
                }
                i++;
            }
        }
        /*for(double []d: exWordCountMatrix){
            System.out.println(Arrays.toString(d));
        }*/
        //System.out.println("newPlotMatrix: Done");
    }
}
