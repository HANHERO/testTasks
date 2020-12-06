package secondExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTests = Integer.parseInt(br.readLine()); //Inputting the number of tests

        for (int i = 0; i < numberOfTests; i++) {
            int numberOfCities = Integer.parseInt(br.readLine()); //Inputting the number of cities
            Graph graph = new Graph(numberOfCities); //Creating a new graph
            for (int j = 0; j < numberOfCities; j++) {
                String nameOfCity = br.readLine(); //Inputting the name of the city
                graph.addCity(new City(nameOfCity)); //Adding the city to array in graph
                int numberOfNeighbors = Integer.parseInt(br.readLine()); //Inputting the number of neighbors
                for (int k = 0; k < numberOfNeighbors; k++) {
                    String[] indexOfCityAndCost = br.readLine().split(" "); //Inputting and splitting neighbor and cost path
                    graph.matrixOfPaths[j][Integer.parseInt(indexOfCityAndCost[0]) - 1] = Integer.parseInt(indexOfCityAndCost[1]); //Filling the mattress of possible path
                }
            }
            int numberOfPathsToFind = Integer.parseInt(br.readLine()); //Inputting number of path to find
            for (int j = 0; j < numberOfPathsToFind; j++) {
                //System.out.println("2 города");
                String[] citiesToFindPath = br.readLine().split(" "); //Inputting and splitting 2 cities to find the lower cost

                System.out.println(graph.findShorterPath(citiesToFindPath[0], citiesToFindPath[1])); //Outputting lower cost between 2 cities
                graph.clear(); //Restores the default prices for the next searches
            }
        }
    }
}

