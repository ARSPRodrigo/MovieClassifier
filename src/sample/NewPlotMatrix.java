package sample;

import java.io.IOException;

/*
 * Created by Prasanna on 12/12/2014.
 */
public class NewPlotMatrix {
    /*
     * define the arrays to store
     * word count, words and
     * words of new plot
     */
    static double [][] wordCountMatrix = CreateMatrices.wordCountMatrix;
    static double [][] exWordCountMatrix;
    static String [] wordMatrix = CreateMatrices.wordMatrix;
    static double [] newWordMatrix;
    static double [] exNewWordMatrix;

    // array containing movie types
    static String [] movieInstances = CreateMatrices.movieInstances;

    /*
     * create matrix new plot words
     * add the word count to the matrix
     */
    public static void newPlotMatrix() throws IOException {
        newWordMatrix = new double[wordMatrix.length];  // initialize newWordMatrix
        String line = NewPlotControl.newPlot;
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
    }
}
