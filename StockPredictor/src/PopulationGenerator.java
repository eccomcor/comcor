import java.util.ArrayList;
import java.util.Random;


public class PopulationGenerator {
	//n is number of genes
	//mu is parent pop size
	
	
	private int n;
	private int mu;

	
	public PopulationGenerator(int n, int mu){
		
		this.n = n;
		this.mu = mu;
		
		
		 
	}
	
public boolean[] generateIndividual(){
	//n+1 denotes the additional bit necessary for the binary "up or down" prediction
	
	boolean[] classifier = new boolean[n+1];
	Random r = new Random();
	for(int i = 0; i < classifier.length; i++){
		classifier[i] = r.nextBoolean();
		}
	return classifier;
}

public ArrayList<boolean[]> generatePopulation(){
	
	ArrayList<boolean[]> population = new ArrayList<boolean[]>();
	
	for (int i = 0; i < mu; i++){
		population.add(generateIndividual());
	}
	return population;
}
	
public int getN(){
		return n;
}

public int getMu(){
	return mu;
}


}
