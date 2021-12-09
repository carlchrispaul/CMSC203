public class Coffee extends Beverage {
	private boolean extraShot, extraSyrup;
	private final double eShotPrice = 0.50, eSyrupPrice = 0.50;

	public Coffee(String n, SIZE s, boolean eShot, boolean eSyrup) {
		super(n, s, TYPE.COFFEE);
		extraShot = eShot;
		extraSyrup = eSyrup;
	}

	@Override
	double calcPrice() {
		double coffeePrice = super.getBasePrice();
	
		if(super.getSize() == SIZE.MEDIUM) {
			coffeePrice += super.getSizePrice();
		} else if(super.getSize() == SIZE.LARGE) {
			coffeePrice += super.getSizePrice() * 2;
		}
		
		if(extraShot == true) { coffeePrice += eShotPrice; }
		if(extraSyrup == true) { coffeePrice += eSyrupPrice; }
		
		return coffeePrice;
	}

	@Override
	public String toString() {
		return super.toString() + "Extra Shot: " + extraShot + " Extra Syrup: " + extraSyrup + "\nPrice: " + calcPrice(); 
	}

	@Override
	public boolean equals(Object o1) {
		Coffee o2 = (Coffee) o1;
		
		if(extraShot != o2.extraShot || extraSyrup != o2.extraSyrup)
			return false;
		
		return true;
	}
	
	public void setExtraShot(boolean extraShot) { this.extraShot = extraShot; }
	public void setExtraSyrup(boolean extraSyrup) { this.extraSyrup = extraSyrup; }
	
	public boolean getExtraShot() { return extraShot; }
	public boolean getExtraSyrup() { return extraSyrup; }
	public double getShotPrice() { return eShotPrice; }
	public double getSyrupPrice() { return eSyrupPrice; }	
}