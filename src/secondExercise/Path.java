package secondExercise;

public class Path {
    public City from; //Parent city
    public City to; //Finite city
    public int costOfPath; // Cost of path

    public Path(City first, City second, int costOfPath) { //Constructor for variable initialization;
        this.from = first;
        this.to = second;
        this.costOfPath = costOfPath;
    }
}
