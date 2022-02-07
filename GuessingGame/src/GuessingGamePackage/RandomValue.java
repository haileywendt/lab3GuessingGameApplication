package GuessingGamePackage;

public class RandomValue {
	// code section 1 - instance variables
	private java.util.Random rndGenerator = new java.util.Random();
	private int randomValue;
	public final static int NUMBER_OF_VALUES = 100;
	
	// code section 2 - public constructor
	public RandomValue() {
		randomValue = rndGenerator.nextInt(NUMBER_OF_VALUES);
	}
	
	// code section 3 - getters and setters
	public void setRandomValue() {
		randomValue = rndGenerator.nextInt(NUMBER_OF_VALUES);
	}
	
	public void setRandomValue(int n) {
		if (n < 0 || n >= NUMBER_OF_VALUES) {
			return; // take no action - value our of range
		}
		randomValue = n;
	}
	
	public int getRandomValue() {
		return randomValue;
	}
	
	// code section 4 - inquirers
	public boolean isCorrectValue(int value) {
		if (value == randomValue) {
			return true;
		}
		else {
			return false; // fall-through is necessary to make IDE happy...
		}
	}
	
	// compareTo: returns < 0 if random value is less than passed value,
	//			  returns > 0 if random value is greater than passed value, 
	// 			  returns   0 if random value equals passed value
	public int compareTo(int value) {
		return randomValue - value;
	}
}
