package test.utill;

public class TestUtill {
	
	public static final int DEFAULT_COUNT = 10000;
	
	static public double testSpeed(ITest t) {
		return testSpeed(t, DEFAULT_COUNT);
	}
	
	static public double testSpeed(ITest t, int count) {
		
		long begin =  System.nanoTime();
		
		for (int i = 0; i < count; i ++) t.test();
		
		long end = System.nanoTime();
		
		return (double)(end - begin) / count;
	}
}
