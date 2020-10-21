import java.lang.reflect.Array;

public class Lab1 {
public static int sum(int a, int b) {
	
	return a+b;
}

public static int castToInt(double a) {
	
	return (int)a;
}

public static String emphasize(String a) {
	
	return "***" + a + "***";
}

public static boolean isOdd(int a) {
	if (a%2 == 0 ) {
	return false;
	} else {
		
		return true;
	}
}

public static int findMax(int a, int b, int c) {
	if(a>b && a>c) {
	return a;
	}
	if(b>a && b>c) {
		
		return b;
	}
	else {
		return c;
	}
}
public static int sum(int[] array) {
	int summation = 0;
	for (int i= 0; i < array.length ;++i ) {
	 summation  = summation + array[i];

	}
	return summation;
}
public static int sumOdd(int[] array2) {
	int summationOdd = 0;
	for (int i= 0; i < array2.length ;++i ) {
		  if(array2[i]%2 == 1) {
			  summationOdd = summationOdd + array2[i];
		  }

		}
	return summationOdd;
}

public static int findMax(int[] array3) {
	
	int max = array3[0];
	for (int i= 0; i < array3.length-1 ;++i ) {
		  if(max <= array3[i+1]) {
			  max = array3[i+1];
		  }

		}
	
	return max;
}
	// TODO: Implement the methods that are tested in Lab1Test.java
}
