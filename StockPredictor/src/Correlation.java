import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Correlation {
	

	// r is the correlation coefficient
	private double r;
	
	private String leadingStockPath = "errorInConstructor_LeadingPathName";
	private String trailingStockPath = "errorInConstructor_TrailingPathName";
	
	//the correlation name is formatted like "FollowStockTicker_LeadStockTicker"
	private String correlationName = "errorInNamingLeadFollowTickers";
	
	public Correlation(String leadingStockTicker, String trailingStockTicker){
		
		this.correlationName = trailingStockTicker + "_" + leadingStockTicker;
		
		this.leadingStockPath = "src\\" + leadingStockTicker + ".csv";
		this.trailingStockPath = "src\\" + trailingStockTicker + ".csv";
	}

	@SuppressWarnings("resource")
	
public ArrayList<Stock> initStockArray(String stockDataPath){
		
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(
			        new InputStreamReader(
			        new FileInputStream(stockDataPath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			while ((line = stream.readLine()) != null){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] values = line.split(",");
		if(!values[0].equals("Date")){
			//here all the days of stocks are initialized. values[0] is the date, values[1] is the open, and values[4] is the close
			//volume, daily high, and daily low are also available, and could easily be factored into the logic below. the stock constructor would need to be changed too. 
			Stock stock = new Stock(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[4]));
			stocks.add(stock);
		
		}
		return stocks;
		
	}
	
	public double getMean(ArrayList<Stock> list){
		double mean = 0.0;
		double temp = 0.0;
		for(int i = 0; i < list.size(); i++){
			temp += list.get(i).getChange();
		}
		mean = temp/list.size();
		return mean;
	}
	
	
public double getR(){
		
		ArrayList<Stock> leadingStocks = initStockArray(leadingStockPath);
		ArrayList<Stock> trailingStocks = initStockArray(trailingStockPath);
		//a equals lead change - mean of lead change, b is same for trailing stocks
		//r = sum of a*b divided by sqrt of (sum of a^2 * sum of  b^2)
		double leadMean = getMean(leadingStocks);
		double trailMean = getMean(trailingStocks);
		double temp = 0.0;
		double leadSum = 0.0;
		for(int i = 0; i < leadingStocks.size(); i++){
			temp = leadingStocks.get(i).getChange() - leadMean;
			temp = temp*temp;
			leadSum += temp;
		}
		
		temp = 0.0;
		double trailSum = 0.0;
		for(int i = 0; i < trailingStocks.size(); i++){
			temp = trailingStocks.get(i).getChange() - trailMean;
			temp = temp*temp;
			trailSum += temp;
		}
		
		
		double product = 0.0;
		double productSum = 0.0;
		for(int i = 1; i < trailingStocks.size(); i++){
			// i-1 in getChange for trailing is to swpace the stock changes by a day. i-1 is one day later than i
			product = (leadingStocks.get(i).getChange() - leadMean) * (trailingStocks.get(i-1).getChange() - trailMean);
			productSum += product;
		}
		
		 r = productSum/(Math.sqrt(trailSum*leadSum));
		return r;
		}
	

	
	}

