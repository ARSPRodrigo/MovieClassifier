package sample;

import java.util.*;

public class KNN {

public static String Main(double []query, String [] movieInstances, double [][] instances){

    //k : # of neighbours
    int k = movieInstances.length;

    //list to save movie data
    List<Movie> movieList = new ArrayList<Movie>();

    //list to save distance result
    List<Result> resultList = new ArrayList<Result>();

    // add movie data to movieList
    for(int i=0;i<movieInstances.length;i++){
        movieList.add(new Movie(instances[i],movieInstances[i]));
    }

    //data about unknown movie puts into query

    //find distances
    for(Movie movie : movieList){
        double dist = 0.0;
        for(int j = 0; j < movie.movieAttributes.length; j++){
            dist += Math.pow(movie.movieAttributes[j] - query[j], k);
        }
        double distance = Math.sqrt( Math.abs(dist) );
        resultList.add(new Result(distance,movie.movieName));
    }
    Collections.sort(resultList, new DistanceComparator());

    double d = 0.0;
    double []b = new double[k];
    for(int x = 0; x < k; x++){
        d += resultList.get(x).distance;
    }
    for(int x = 0; x < k; x++){
        b[x] = resultList.get(x).distance*100/d;
    }

    /*
     * prints the types of new movie
     * get the lowest possibility
     * prints which grater than that
     */
    String result = "";
    double a = 20;
    for(int x = 0; x < k; x++){
        if(b[x] < a) {
            result += resultList.get(x).movieName + " ";
        }
    }
    return result;
}

    //simple class to model instances (features + class)
    static class Movie {
        double[] movieAttributes;
        String movieName;
        public Movie(double[] movieAttributes, String movieName){
            this.movieName = movieName;
            this.movieAttributes = movieAttributes;
        }
    }

    //simple class to model results (distance + class)
    static class Result {
        double distance;
        String movieName;
        public Result(double distance, String movieName){
            this.movieName = movieName;
            this.distance = distance;
        }
    }

    //simple comparator class used to compare results via distances
    static class DistanceComparator implements Comparator<Result> {
        @Override
        public int compare(Result a, Result b) {
            return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
        }
    }
	       
}

























