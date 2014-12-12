package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by Prasanna on 12/9/2014.
 */
public class MovieTest {

    static String file = "plot.txt";    // the plot to find type
    private String fName;               // test movie file
    private String typeName;            // test movie type
    private static String version;     // CSV file which has the document term matrix

    static {
        version = "version5.csv";
    }

    public MovieTest(String fileName, String genre){
        this.fName = fileName;
        this.typeName = genre;
    }

    public void run(){
        test(this.fName,this.typeName);
    }

    public void test(String fileName, String genre){
        try {
            int countTrue = 0, countFalse =0;
            String line="";
            // create file reader
            FileReader fileRd = new FileReader(fileName);
            BufferedReader readFile = new BufferedReader(fileRd);

            while((line = readFile.readLine()) != null) {
                CreateMatrices.createWordMatrix(version);
                CreateMatrices.newPlot(file, line);
                CreateMatrices.newPlotMatrix();
                String results = KNN.Main(CreateMatrices.exNewWordMatrix, CreateMatrices.movieInstances, CreateMatrices.exWordCountMatrix);
                if(results.contains(genre)){
                    //System.out.println(results);
                    countTrue++;
                }else {
                    countFalse++;
                }
            }
            double accuracy = countTrue*100/(countFalse+countTrue);
            System.out.println("Percentage accuracy of "+genre+" is: "+accuracy+"%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String []args){
        MovieTest action = new MovieTest("test/ActionMovies.txt","Action");
        action.run();
        MovieTest drama = new MovieTest("test/DramaMovies.txt","Drama");
        drama.run();
        MovieTest horror = new MovieTest("test/HorrorMovies.txt","Horror");
        horror.run();
        MovieTest romance = new MovieTest("test/RomanceMovies.txt","Romance");
        romance.run();
        MovieTest thriller = new MovieTest("test/ThrillerMovies.txt","Thriller");
        thriller.run();
    }*/
}
