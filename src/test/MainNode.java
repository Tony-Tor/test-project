package test;

import java.util.ArrayList;
import java.util.List;

public abstract class MainNode {
	public static List<MainNode> nodes = new ArrayList<>(); 
	
	public MainNode() {
		nodes.add(this);
	}
	
	public static void runAll() {
		nodes.forEach(MainNode::run);
	}
	
	public abstract void run();
}
