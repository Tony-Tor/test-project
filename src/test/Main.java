package test;

import java.util.List;

import test.lambda.TestLambda;
import test.safes.MyIteration;
import test.safes.Test;
//import test.stream.TestStream;
import test.treemap.TestTreeMap;

public class Main {
	public static void main(String args[]) {
		
		new TestLambda();
		
		MyIteration a = (int i, List<Boolean> l) -> l.set(i, true);
		MyIteration b = (int i, List<Boolean> l) -> l.set(i, false);
		MyIteration c = (int i, List<Boolean> l) -> l.set(i, !l.get(i));
		
		new Test(100, a,b,c);
		
		new Test(100, c);
		
		//new TestStream();
		
		new TestTreeMap();
		
		MainNode.runAll();
	}
}
