import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Function2 extends Function {

	@Override
	public double fnValue(double x) {
		// TODO Auto-generated method stub
		return (x / 3) + 2 * Math.sqrt(Math.pow(x, 2) - 8 * x + 25); //equation
	}
	
	public String toString() {
		return "Minimize the distance a dog will run and swim to retrieve a ball in the ocean";
	}
	
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		// TODO Auto-generated method stub
		DecimalFormat twoDeci = new DecimalFormat("#.##");
		twoDeci.setRoundingMode(RoundingMode.CEILING);
		
		return "After running along the beach for " + twoDeci.format(x)
				+"m, the minimum amount of time the dog will reach the ball is " + twoDeci.format(optVal) + "s";
	}

	@Override
	public double getXVal(double x) {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getYVal(double x) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public double getZVal(double x) {
		// TODO Auto-generated method stub
		return -1;
	}
}
