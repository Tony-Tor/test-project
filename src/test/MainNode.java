package test;

import java.util.ArrayList;
import java.util.List;

public abstract class MainNode {
	public static List<MainNode> nodes = new ArrayList<>(); 
	
	public MainNode() {
		nodes.add(this);
		System.out.println("INFO: Create node " + this.getClass().getName());
	}
	
	public static void runAll() {
		nodes.forEach(MainNode::insiderun);
	}
	
	private void insiderun(){
		System.out.println("\nINFO: Run node " + this.getClass().getName());
		run();
	}
	
	public abstract void run();
}
