
public class Stock {
	
	private String date = "defaultDateMarker";
	private double open = 0.0;
	private double close = 0.0;
	private double change = 0.0;
	private String ticker = "defaultTicker";
	
	public Stock(String ticker, String date, double open, double close){
		this.date = date;
		this.open = open;
		this.close = close;
		this.change = open-close;
		this.ticker = ticker;
	}
	
	public void setOpen(double open){
		this.open = open;
	}
	
	public double getOpen(){
		return this.open;
	}
	
	public void setClose(double close){
		this.close = close;
	}
	
	public double getClose(){
		return this.close;
	}
	
	public double getChange(){
		return this.change;
	}
	
	public void setChange(double change){
		this.change = change;
	}
	
	public String getTicker(){
		return ticker;
	}
	
	public void setTicker(String ticker){
		this.ticker = ticker;
	}

}
