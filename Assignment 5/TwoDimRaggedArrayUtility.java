import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public final class TwoDimRaggedArrayUtility {
	//readFile
	public static double[][] readFile(File file) throws FileNotFoundException {
		int rows = 0, presentRow = 0;
		
		Scanner keyb1 = new Scanner(file);
		while(keyb1.hasNextLine()) {
			rows++;
			keyb1.nextLine();
		}
		keyb1.close();
		
		double[][] data = new double[rows][];
		
		Scanner keyb2 = new Scanner(file);
		while(keyb2.hasNextLine()) {
			String text = keyb2.nextLine();
			String[] col = text.trim().split(" ");
			data[presentRow] = new double[col.length];
			
			for(int presentCol = 0; presentCol < col.length; presentCol++)
				data[presentRow][presentCol] = Double.parseDouble(col[presentCol]);
			
			presentRow++;
		}
		
		keyb2.close();
		return data;
	}
	
	//writeToFile
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter pWriter = new PrintWriter(outputFile);
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				pWriter.write(data[row][col] + " ");
			}
			pWriter.write("\n");
		}
		pWriter.close();
	}
	
	//getTotal
	public static double getTotal(double[][] data) {
		double total = 0;
		
		for(int row = 0; row < data.length; row++ ) {
			for(int col = 0; col < data[row].length; col++)
				total += data[row][col];
		}
		return total;
	}
	
	//getAverage
	public static double getAverage(double[][] data) {
		int amount = 0;
		double total = 0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				amount++;
			}
		}
		double average = total / amount;
		return average;
	}
	
	//getRowTotal
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		
		for(int col = 0; col < data[row].length; col++) 
			rowTotal += data[row][col];
		
		return rowTotal;
	}
	
	
	//getColumnTotal
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(col >= data[row].length || col < 0) 
				continue;
			
			colTotal += data[row][col];
		}
		return colTotal;
	}
	
	//getHighestInRow
	public static double getHighestInRow(double[][] data, int row) {
		double highInRow = 0;
		
		if(data.length < row || row < 0)
			return 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if(highInRow < data[row][col]) {
				highInRow = data[row][col];
			}
		}
		return highInRow;
	}
	
	//getHighestInRowIndex
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highInRow = 0;
		int highInRowIndex = 0;
		
		if(data.length < row || row < 0)
			return 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if(highInRow < data[row][col]) {
				highInRow = data[row][col];
				highInRowIndex = col;
			}
		}
		return highInRowIndex;
	}
	
	//getLowestInRow
	public static double getLowestInRow(double[][] data, int row) {
		double lowInRow = 0;
		
		if(data.length < row || row < 0) 
			return 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if(lowInRow > data[row][col] || lowInRow == 0) {
				lowInRow = data[row][col];
			}
		}
		return lowInRow;
	}
	
	//getLowestInRowIndex
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowInRow = 0;
		int lowInRowIndex = 0;
		
		if(data.length < row || row < 0) 
			return 0;
		
		for(int col = 0; col < data[row].length; col++) {
			if(lowInRow > data[row][col] || lowInRow == 0) {
				lowInRow = data[row][col];
				lowInRowIndex = col;
			}
		}
		return lowInRowIndex;
	}
	
	//getHighestInColumn
	public static double getHighestInColumn(double[][] data, int col) {
		double highInCol = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col || col < 0) 
				continue;
			
			if(highInCol < data[row][col])
				highInCol = data[row][col];
			
		}
		return highInCol;
	}
	
	//getHighestInColumnIndex
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highInCol = 0;
		int highInColIndex = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col || col <0) 
				continue;
			
			if(highInCol < data[row][col]) {
				highInCol = data[row][col];
				highInColIndex = row;
			}
		}
		return highInColIndex;
	}
	
	//getLowestInColumn
	public static double getLowestInColumn(double[][] data, int col) {
		double lowInCol = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(col >= data[row].length || col < 0)
				continue;
			
			if(lowInCol > data[row][col] || lowInCol == 0)
				lowInCol = data[row][col];
		}
		return lowInCol;
	}
	
	//getLowestInColumnIndex
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowInCol = 0;
		int lowInColIndex = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(col >= data[row].length || col < 0) 
				continue;
			
			if(lowInCol > data[row][col] || lowInCol == 0) {
				lowInCol = data[row][col];
				lowInColIndex = row;
			}
		}
		return lowInColIndex;
	}
	
	//getHighestInArray
	public static double getHighestInArray(double[][] data) {
		double highArray = 0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {				
				if(highArray < data[row][col]) {
					highArray = data[row][col];
				}
			}
		}
		return highArray;
	}
	
	//getLowestInArray
	public static double getLowestInArray(double[][] data) {
		double lowArray = 0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(lowArray > data[row][col] || lowArray == 0) {
					lowArray = data[row][col];
				}
			}
		}
		return lowArray;
	}
}
