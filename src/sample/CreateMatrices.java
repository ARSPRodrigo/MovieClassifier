package sample;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by Prasanna on 12/4/2014.
 */
public class CreateMatrices {
    /*
     * define the arrays to store
     * word count, words and
     * words of new plot
     */
    static double [][] wordCountMatrix;
    static String [] wordMatrix;

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
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"DataSet file "+fileName+" should be here");
        }
    }
}
