import java.util.Random;


public class Mutate {
	private int n;
	
	public Mutate(int n){
		
		//We might also think about having a more frequent mutation at the end of the run, as crossover becomes less effective
		this.n = n;
		
	}
	
public boolean[] mutate(boolean[] individual){
	
	Random r = new Random();
for(int i = 0; i < individual.length; i++){ 
	if(i < individual.length-1){
		//mutation rate of 1/n
	int random = r.nextInt(n);
	if(random == 1){
		if(individual[i] == false){
			individual[i] = true;
		}
		else{
			individual[i] = false;
		}
	}//endif2
	}//endif1
	else{
		//rate of 1/(2n) is used to mutate the prediction
		int temp = r.nextInt(n*2);
		if(temp == 1){
			if(individual[i] == false){
				individual[i] = true;
			}
			else{
				individual[i] = false;
			}
		}
	}
	}//endfor
	return individual;
}

}
