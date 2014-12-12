package sample;

import org.tartarus.snowball.EnglishSnowballStemmerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by Prasanna on 10/31/2014.
 */
public class RemoveStopWords {

    public static String [] stopWordsList = {"a","able","about","above","according","accordingly","across","actually","after","afterwards","again","against","all","allow","allows","almost","alone","along","already","also","although","always","among","amongst","an","and","another","any","anybody","anyhow","anyone","anything","anyway","anyways","anywhere","apart","appear","appreciate","appropriate","are","around","aside","ask","asking","associated","available","away","awfully","be","became","because","become","becomes","becoming","been","before","beforehand","behind","being","believe","below","beside","besides","best","better","between","beyond","both","brief","but","by","came","can","cannot","cant","cause","causes","certain","certainly","changes","clearly","com","come","comes","concerning","consequently","consider","considering","contain","containing","contains","corresponding","could","course","currently","definitely","described","despite","did","different","does","doing","done","down","downwards","during","each","edu","eight","either","else","elsewhere","enough","entirely","especially","etc.","even","ever","every","everybody","everyone","everything","everywhere","exactly","example","except","far","few","fifth","first","five","followed","following","follows","for","former","formerly","forth","four","from","further","furthermore","get","gets","getting","given","gives","goes","going","gone","got","gotten","greetings","had","happens","hardly","has","have","having","hello","help","hence","her","here","hereafter","hereby","herein","hereupon","hers","herself","him","himself","his","hither","hopefully","how","howbeit","however","ignored","immediate","in","inasmuch","inc","indeed","indicate","indicated","indicates","inner","insofar","instead","into","inward","it","its","itself","just","keep","keeps","kept","know","known","knows","last","lately","later","latter","latterly","least","less","lest","let","like","liked","likely","little","look","looking","looks","ltd","mainly","many","may","maybe","mean","meanwhile","merely","might","more","moreover","most","mostly","much","must","myself","name","namely","near","nearly","necessary","need","needs","neither","never","nevertheless","new","next","nine","nobody","non","none","noone","nor","normally","not","nothing","novel","now","nowhere","obviously","of","off","often","okay","old","once","one","ones","only","onto","other","others","otherwise","ought","our","ours","ourselves","out","outside","over","overall","own","particular","particularly","per","perhaps","placed","please","plus","possible","presumably","probably","provides","que","quite","rather","really","reasonably","regarding","regardless","regards","relatively","respectively","right","said","same","saw","say","saying","says","second","secondly","see","seeing","seem","seemed","seeming","seems","seen","self","selves","sensible","sent","serious","seriously","seven","several","shall","she","should","since","six","some","somebody","somehow","someone","something","sometime","sometimes","somewhat","somewhere","soon","sorry","specified","specify","specifying","still","sub","such","sup","sure","take","taken","tell","tends","than","thank","thanks","thanx","that","thats","the","their","theirs","them","themselves","then","thence","there","thereafter","thereby","therefore","therein","theres","thereupon","these","they","think","third","this","thorough","thoroughly","those","though","three","through","throughout","thru","thus","together","to","too","took","toward","towards","tried","tries","truly","try","trying","twice","two","under","unfortunately","unless","unlikely","until","unto","upon","use","used","useful","uses","using","usually","uucp","value","various","very","via","viz","want","wants","was","way","welcome","well","went","were","what","whatever","when","whence","whenever","where","whereafter","whereas","whereby","wherein","whereupon","wherever","whether","which","while","whither","who","whoever","whole","whom","whose","why","will","willing","wish","with","within","without","wonder","would","yes","yet","you","your","yours","yourself","yourselves","zero"};

    /*public static void main(String []args){
        String readFile = "";
        createCleanFile(readFile);
    }*/

    public static String createCleanFile(String fileName){
        String writeFile = "";
        try {
            String line = "";
            String line2;
            FileReader fileRd = new FileReader(fileName);
            BufferedReader bufferRd = new BufferedReader(fileRd);

            while((line2= bufferRd.readLine()) != null){
                line +=" "+line2;
            }
            line = line.toLowerCase();
            for(String stopWord : stopWordsList){
                line = line.replaceAll("[^\\w\\s]", "");
                line = line.replaceAll(" " + stopWord + " ", " ");
            }
            String []s = line.split(" ");
            for(String x:s){
                try{
                    EnglishSnowballStemmerFactory.getInstance().process(x);
                    writeFile += x + " ";
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //System.out.println(writeFile+" Done");
        }catch (FileNotFoundException x) {
            System.exit(-1);
        } catch (IOException x) {
            System.exit(-1);
        }
        return writeFile;
    }

    public static String createCleanTxt(String txt){
        String returnTxt = "";
        txt = txt.toLowerCase();
        for(String stopWord : stopWordsList){
            txt = txt.replaceAll("[^\\w\\s]", "");
            txt = txt.replaceAll(" " + stopWord + " ", " ");
        }
        String []s = txt.split(" ");
        for(String x:s){
            try{
                EnglishSnowballStemmerFactory.getInstance().process(x);
                returnTxt += x + " ";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return returnTxt;
    }
}
