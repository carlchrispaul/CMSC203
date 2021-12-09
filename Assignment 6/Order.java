import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNum, orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverageList;
	
	public Order(int t, DAY d, Customer c) {
		orderNum = (int) (Math.random() * (90000-10000)+10000);
		orderTime = t;
		orderDay = d;
		customer = new Customer(c);
		beverageList = new ArrayList<Beverage>();
	}

	@Override
	//add Coffee
	public void addNewBeverage(String n, SIZE s, boolean eShot, boolean eSyrup) {
		beverageList.add(new Coffee(n, s, eShot, eSyrup));
	}
	
	@Override
	//add Smoothie
	public void addNewBeverage(String n, SIZE s, int numOfFruits, boolean addProtein) {
		beverageList.add(new Smoothie(n, s, numOfFruits, addProtein));
	}
	
	@Override
	//add Alcohol
	public void addNewBeverage(String n, SIZE s) {
		beverageList.add(new Alcohol(n, s, isWeekend()));
	}
	
	@Override
	public String toString() {
		return "Order Number: " + orderNum + " Time: " + orderTime + " Day: " + orderDay + " Customer: "
				+ customer + " Beverages: " + beverageList + " Total=" + calcOrderTotal();
	}
	
	@Override
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		
		for (Beverage b: beverageList) {
			orderTotal += b.calcPrice();
		}
		
		return orderTotal;
	}

	@Override
	public int compareTo(Order other) {
		if (orderNum == other.getOrderNo()) 
			return 0;
		else if(orderNum > other.getOrderNo()) 
			return 1;
		else
			return -1;
	}
	
	@Override
	public int findNumOfBeveType(TYPE t) {
		int num = 0;
		
		for (Beverage b: beverageList) {
			if (b.getType() == t) {
				num++;
			}
		}
		
		return num;
	}
	
	@Override
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
			return true;
		else
			return false;
	}
	
	public void setOrderNo(int num) { orderNum = num; }
	public void setOrderTime(int time) { orderTime = time; }
	public void setOrderDay(DAY day) { orderDay = day; }
	public void setCustomer(Customer c) { customer = c; }
	public void setBeverages(ArrayList<Beverage> bev) { beverageList = bev; }
	
	public int getOrderNo() { return orderNum; }
	public int getOrderTime() { return orderTime; }
	public DAY getOrderDay() { return orderDay; }
	public Customer getCustomer() { return new Customer(customer); }
	public ArrayList<Beverage> getBeverages() { return beverageList; }
	@Override
	public Beverage getBeverage(int beverageType) { return this.beverageList.get(beverageType); }
	public int getTotalItems() { return beverageList.size(); }
}