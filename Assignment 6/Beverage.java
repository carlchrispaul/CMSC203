public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private final double basePrice = 2.00, sizePrice = 1.00;

	public Beverage(String n, SIZE s, TYPE t) {
		name = n;
		size = s;
		type = t;
	}
	
	abstract double calcPrice();

	@Override
	public String toString() {
		return "Beverage: " + name + " Size: " + size;
	}

	@Override
	public boolean equals(Object o1) {
		Beverage o2 = (Beverage) o1;
		
		if(name != o2.name || size != o2.size || type != o2.type)
			return false;

		return true;
	}
	
	public void setBevName(String n) { name = n; }
	public void setType(TYPE t) { type = t; }
	public void setSize(SIZE s) { size = s; }
	
	public String getBevName() { return name; }
	public TYPE getType() { return type; }
	public SIZE getSize() { return size; }
	public double getBasePrice() { return basePrice; }
	public double getSizePrice() { return sizePrice; }
}