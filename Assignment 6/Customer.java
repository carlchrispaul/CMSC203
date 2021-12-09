public class Customer {
	private String name;
	private int age;

	public Customer(String n, int a) {
		this.name = n;
		this.age = a;
	}
	
	public Customer(Customer copy) {
		this.setName(copy.getName());
		this.setAge(copy.getAge());
	}

	@Override
	public String toString() {
		return "Customer: " + name + " Age: " + age;
	}

	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	
	public String getName() { return name; }
	public int getAge() { return age; }
}