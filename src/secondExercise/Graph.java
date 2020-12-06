package secondExercise;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int[][] matrixOfPaths; //Stores possible paths and their price
    int indexOfStartCity; // Needed to determine the starting city
    int indexOfFinishCity; // Needed to determine the finishing city

    List<City> cities; //Array of cities
    List<Path> paths; //Array of paths

    public Graph(int numberOfCities) { //Constructor for variable initialization
        matrixOfPaths = new int[numberOfCities][numberOfCities];
        cities = new ArrayList<>();
        paths = new ArrayList<>();
    }

    public void addCity(City newCity) { //Method for cities adding
        cities.add(newCity);
    }

    public void createPaths() { //This method fills an array of paths
        for (int i = 0; i < matrixOfPaths.length; i++) {
            for (int j = 0; j < matrixOfPaths[i].length; j++) {
                if (matrixOfPaths[i][j] != 0)
                    paths.add(new Path(cities.get(i), cities.get(j), matrixOfPaths[i][j]));
            }
        }
    }

    public Path getMinimal() { //Gives the path with the minimum starting city cost
        Path minimal = paths.get(0);
        for (Path path : paths) { //Determines the minimum price
            if (minimal.from.cityCost > path.from.cityCost + path.costOfPath) {
                minimal = path;

            }
        }
        return minimal; //Return the minimum price
    }

    public int findShorterPath(String start, String finish) { //Finds the shortest path between two cities
        createPaths(); //Fills an array of paths
        for (int i = 0; i < matrixOfPaths.length; i++) {// Finds indexes of the inputed cities
            if (cities.get(i).name.equals(start)) {
                indexOfStartCity = i;
                cities.get(i).cityCost = 0; //Set start city cost to zero
            }
            if (cities.get(i).name.equals(finish)) indexOfFinishCity = i;
        }
        while (paths.size() > 0) { //Setting minimal prices for cities
            Path minimal = getMinimal();

            if (minimal.from.cityCost + minimal.costOfPath < minimal.to.cityCost) {
                //If the price of the next city is greater than the sum of the prices of
                // the previous city and the price of the passed path,
                // sets the sum of the prices of the previous city and the price of the passed path
                minimal.to.cityCost = minimal.from.cityCost + minimal.costOfPath;
            }
            paths.remove(minimal); // Deleting the passed path
        }

        return cities.get(indexOfFinishCity).cityCost; // Returned minimal cost to reach finished city
    }

    public void clear() { //Restores the default prices for the next searches
        for (City city : cities) {
            city.cityCost = 20000;
        }
    }
}
