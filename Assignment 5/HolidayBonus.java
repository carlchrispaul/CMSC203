public class HolidayBonus {
	//calculateHolidayBonus
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] hBonus = new double[data.length]; //hBonus == holiday bonus
		
		for(int col = 0; col < data.length; col++) {
			double highBonus = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
			double lowBonus = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
			int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			
			if(highBonus > 0) 
				hBonus[highBonusIndex] += high;
			
			if(lowBonus > 0 && highBonusIndex != lowBonusIndex) 
				hBonus[lowBonusIndex] += low;
			
			for(int i = 0; i < data.length; i++) {
				if(col >= data[i].length || highBonusIndex == i || i == lowBonusIndex || data[i][col] <= 0)
					continue;
				else
					hBonus[i] += other;
				
				System.out.println();
			}
		}
		return hBonus;
	}
	
	//calculateTotalHolidayBonus
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double totalHBonus = 0;
		double hBonusArray[] = calculateHolidayBonus(data, high, low, other);
		
		for(int i = 0; i < hBonusArray.length; i++) {
			totalHBonus += hBonusArray[i];
		}
		
		return totalHBonus;
	}
}