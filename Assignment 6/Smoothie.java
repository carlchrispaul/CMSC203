public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean addProteinPowder;
	private final double proteinPrice = 1.50, fruitPrice = 0.50;

	public Smoothie(String n, SIZE s, int fruits, boolean protein) {
		super(n, s, TYPE.SMOOTHIE);
		numOfFruits = fruits;
		addProteinPowder = protein;
	}

	@Override
	public String toString() {
		return super.toString() + "Number of Fruits: " + numOfFruits + " Add Protein Powder: " + addProteinPowder
				+ "\nPrice: " + calcPrice();
	}

	@Override
	double calcPrice() {
		double smoothiePrice = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			smoothiePrice += super.getSizePrice();
		} else if(super.getSize() == SIZE.LARGE) {
			smoothiePrice += super.getSizePrice() * 2;
		}
		
		if(numOfFruits > 0) { smoothiePrice += numOfFruits * fruitPrice; }
		if(addProteinPowder == true) { smoothiePrice += proteinPrice; }
		
		return smoothiePrice;
	}
	
	@Override
	public boolean equals(Object o1) {
		Smoothie o2 = (Smoothie) o1;
		
		if(!super.equals(o1) || numOfFruits != o2.numOfFruits || addProteinPowder != o2.addProteinPowder)
			return false;
		
		return true;
	}

	public void setNumOfFruits(int fruits) { this.numOfFruits = fruits; }
	public void setAddProtien(boolean protein) { this.addProteinPowder = protein; }
	
	public int getNumOfFruits() { return numOfFruits; }
	public boolean getAddProtien() { return addProteinPowder; }
	public double getProteinPrice() { return proteinPrice; }
	public double getFruitPrice() { return fruitPrice; }
}