import java.text.DecimalFormat;

public class Triangle {

private double sideA;
private double sideB;
private double sideC;
private static final DecimalFormat FORMATER = new DecimalFormat("#.###");

public Triangle(double sideA, double sideB, double sideC) {
	
	if (isTriangle(sideA,sideB, sideC)  ) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	} else {
		this.sideB = 1;
		this.sideA = 1;
		this.sideC = 1;
	}
	
	
	
	
	


}

public double getSideA() {
	return this.sideA;
	
}

public double getSideB() {
	return this.sideB;
	
}

public double getSideC() {
	return this.sideC;
	
}

public boolean setSideA(double sideA ) {
	if (isTriangle(sideA,this.sideB, this.sideC) == true ) {
		this.sideA = sideA;
		return true;
	} 
	
	return false;
	
}

public boolean setSideB(double sideB ) {
	if (isTriangle(this.sideA, sideB, this.sideC) == true ) {
		this.sideB = sideB;
		return true;
	} 
	
	return false;
	
	
}

public boolean setSideC(double sideC ) {
	if (isTriangle(this.sideA,this.sideB, sideC) == true ) {
		this.sideC = sideC;
		return true;
	} 
	
	return false;
	
	
}

private static boolean isTriangle(double a, double b, double c) {
	if (a > 0 && b>0 && c>0 && a+b > c && b+c > a && a+c > b) {
		return true;
	}else {
	return false;
	}
}

public String toString() {
	
	String sideAOutput = FORMATER.format(getSideA());
	String sideBOutput = FORMATER.format(getSideB());
	String sideCOutput = FORMATER.format(getSideC());
	
	return ("Triangle("+ sideAOutput + ", " + sideBOutput + ", " + sideCOutput + ")");
	
}
}