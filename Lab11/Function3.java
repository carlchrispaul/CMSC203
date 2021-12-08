import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Function3 extends Function {

	@Override
	public double fnValue(double x) {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(x, 4) - Math.pow(x, 2) + 1); //equation
	}
	
	public String toString() {
		return "Find the minimum distance between the function f(x)=x^2 and the point (0,1)\n"
				+ "This distance is described by the function d(x)=sqrt(x^4 - x^2 + 1)";
	}
	
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		// TODO Auto-generated method stub
		DecimalFormat twoDeci = new DecimalFormat("#.##");
		twoDeci.setRoundingMode(RoundingMode.CEILING);
		
		return "The minimum distance between the function f(x)=x^2 and the point (0,1) is " + twoDeci.format(optVal)
				+ "\n    From points (" + twoDeci.format(x) + "," + twoDeci.format(y) 
				+ ") and (" + twoDeci.format(-x) + "," + twoDeci.format(y) + ")";
	}

	@Override
	public double getXVal(double x) {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getYVal(double x) {
		// TODO Auto-generated method stub
		return Math.pow(x, 2); // y = x^2
	}

	@Override
	public double getZVal(double x) {
		// TODO Auto-generated method stub
		return 0;
	}
}
