import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Crossover {
	// n is number of crossover points
	int n;
	
	public Crossover(int n){
		this.n = n;
	}

	
public boolean[] doCrossover(boolean[] parent1, boolean[] parent2){
	
	boolean[] child1 = new boolean[parent1.length];
	boolean[] child2 = new boolean[parent1.length];
	boolean[] faultIndicator = null;
	
	//will hold points where parent arrays will be cut
	ArrayList<Integer> crossoverPoints = new ArrayList<Integer>();
	
	Random r = new Random();

	
	
	//init random cross over points
	for(int i = 0; i < n; i++){
		
		int crossPt = r.nextInt(parent1.length);
		
		if(crossoverPoints.contains(crossPt)) i--;
		
		else crossoverPoints.add(crossPt);
	}
	//used to switch between parents when making children
	boolean bitFlip = false;
	
	//this puts the points in order to make breaking the array up manageable
	Collections.sort(crossoverPoints);
	
	//the next few loops break up the cross over in a swapping fashion
	//chunking the genomes and alternating between children
	//children are then tested for fitness, and the highest fitness child is returned with 99% probability
	
	for(int i = 0; i < n-1; i++){
		if(bitFlip == true) bitFlip = false;
		if(bitFlip == false) bitFlip = true;
		for(int j = crossoverPoints.get(i); j < crossoverPoints.get(i+1); j++){
			if(bitFlip == true){
				child1[j] = parent2[j];
				child2[j] = parent1[j];
			}//endif
			else if(bitFlip == false){
				child2[j] = parent2[j];
				child1[j] = parent1[j];
			}//endelse
		}//endfor2
		}
	//endfor1
	
	//Fitness has yet to be written 
	//but will eventually return a double signifying calculated fitness value
	Fitness fit = new Fitness();
	int c1Fit = 0;
	int c2Fit = 0;
	//c1Fit= fit.getFitness(child1);
	//c2Fit = fit.getFitness(child2);
	int diversity = r.nextInt(99);
	if(diversity == 1){
		if(c1Fit > c2Fit) return child2;
		else if(c1Fit < c2Fit) return child1;
	}
	else if(c1Fit > c2Fit) return child1;
	else return child2;
	//if the code reaches the next line, something has gone wrong
	return faultIndicator;
}

	
	
	
}
