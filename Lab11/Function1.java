import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Function1 extends Function {

	@Override
	public double fnValue(double x) {
		// TODO Auto-generated method stub
		if(x <= 0.0) // r > 0
			return Double.MAX_VALUE;
		else
			return 0.8 * Math.PI * Math.pow(x, 2) + 800 / x; //equation
	}
	
	public String toString() {
		return "Minimize the cost of a can that will hold 2 liters of liquid";
	}
	
	@Override
	public String answerString(double optVal, double x, double y, double z) {
		// TODO Auto-generated method stub
		DecimalFormat twoDeci = new DecimalFormat("#.##");
		twoDeci.setRoundingMode(RoundingMode.CEILING);
		
		return "Minimum cost is $" + twoDeci.format(optVal) + " with height = " 
				+ twoDeci.format(y) + "cm and radius = " + twoDeci.format(x) + "cm"; 
		//The example image on word has height and radius reversed. I followed the calculation in the video
		//and r equals around 5.4cm and height equals around 21.7cm
	}

	@Override
	public double getXVal(double x) {
		// TODO Auto-generated method stub
		return x; //radius
	}

	@Override
	public double getYVal(double x) {
		// TODO Auto-generated method stub
		double y = 2000 / (Math.PI * Math.pow(x, 2));
		return y; //height
	}

	@Override
	public double getZVal(double x) {
		// TODO Auto-generated method stub
		return -1.0;
	}
}
