import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private int numOfAlcoholInCurrentOrder;
	private ArrayList<Order> orderList;
	private Order currentOrder;

	public BevShop() {
		orderList = new ArrayList<Order>(); 
	}

	@Override
	public boolean validTime(int t) {
		if(t >= MIN_TIME && t <= MAX_TIME)
			return true;
		else
			return false;
	}

	@Override
	public boolean eligibleForMore() {
		if(currentOrder.findNumOfBeveType(TYPE.ALCOHOL) <= MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}

	@Override
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL) //testValidAge fails age >= MIN_AGE_FOR_ALCOHOL
			return true;
		else
			return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String name, int age) {
		currentOrder = new Order(time, day, new Customer(name, age));
		orderList.add(currentOrder);
	}

	@Override
	public void processCoffeeOrder(String n, SIZE s, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(n, s, extraShot, extraSyrup);
	}
	
	@Override
	public void processSmoothieOrder(String n, SIZE s, int numOfFruits, boolean addProtein) {
		currentOrder.addNewBeverage(n, s, numOfFruits, addProtein);
	}
	
	@Override
	public void processAlcoholOrder(String n, SIZE s) {
		currentOrder.addNewBeverage(n, s);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orderList.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for (Order o: orderList) {
			total += o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Number of Alcohol Drink: " + numOfAlcoholInCurrentOrder + " Orders: " + orderList + " Current Order: "
				+ currentOrder + " Monthly Sale=" + totalMonthlySale();
	}
	
	@Override
	public void sortOrders() { orderList.sort(null); }
	@Override
	public Order getOrderAtIndex(int index) { return orderList.get(index); }
	public int totalNumOfMonthlyOrders() { return orderList.size(); }
	public boolean isMaxFruit(int fruits) { return fruits > MAX_FRUIT; }
	
	public void setNumOfAlcoholDrink(int numOfAlcohol) { numOfAlcoholInCurrentOrder = numOfAlcohol; }
	public void setOrders(ArrayList<Order> orders) { orderList = orders; }
	public void setCurrentOrder(Order currentOrder) { this.currentOrder = currentOrder; }
	
	public int getMaxOrderForAlcohol() { return MAX_ORDER_FOR_ALCOHOL; }
	public int getMinAgeForAlcohol() { return MIN_AGE_FOR_ALCOHOL; }
	public int getNumOfAlcoholDrink() { return numOfAlcoholInCurrentOrder; }
	public ArrayList<Order> getOrders() { return orderList; }
	public Order getCurrentOrder() { return currentOrder; }
}