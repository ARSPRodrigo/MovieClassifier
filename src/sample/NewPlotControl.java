package sample;

/*
 * Created by Prasanna on 12/12/2014.
 */
public class NewPlotControl {

    static String newPlot;                      // stores the words of new plot

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
    }
}
