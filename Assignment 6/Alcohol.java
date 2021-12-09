public class Alcohol extends Beverage {
	private boolean weekend;
	private final double wPrice = 0.60;

	public Alcohol(String n, SIZE s, boolean w) {
		super(n, s, TYPE.ALCOHOL);
		weekend = w;
	}

	@Override
	public String toString() {
		return super.toString() + "Weekend: " + isWeekend() + "\nPrice: " + calcPrice();
	}

	@Override
	double calcPrice() {
		double alcoholPrice = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			alcoholPrice += super.getSizePrice();
		} else if(super.getSize() == SIZE.LARGE) {
			alcoholPrice += super.getSizePrice() * 2;
		}
		
		if(weekend == true) { alcoholPrice += wPrice; }
		
		return alcoholPrice;
	}
	
	@Override
	public boolean equals(Object o1) {
		Alcohol o2 = (Alcohol) o1;
		
		if (weekend != o2.weekend)
			return false;
		
		return true;
	}

	public boolean isWeekend() { return weekend; }
	public void setWeekend(boolean weekend) { this.weekend = weekend; }
	public double getWeekendPrice() { return wPrice; }
}