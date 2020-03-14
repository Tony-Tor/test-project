package test.safes;

import java.util.ArrayList;
import java.util.List;

import test.MainNode;

public class Test extends MainNode{
	List<Boolean> arr;
	int count;
	List<MyIteration> lmi;
	
	public Test(int count, MyIteration...a) {
		super();
		
		this.count = count;
		
		arr = new ArrayList<>();
		clear();
		
		lmi = new ArrayList<>();
		for (MyIteration i:a) lmi.add(i);
	}
	
	@Override
	public void run() {
		complite();
		out();
		clear();
	}
	
	public void clear() {
		arr.clear();
		for(int i = 0; i < count; i++) {
			arr.add(false);
		}
	}
	
	public void complite() {
		for(int k = 1; k <= count;k++) {
			for(int i = 0; i < count; i++) {
				if(proof(k, i)) {
					lmi.get((int)((k-1)%lmi.size())).iteration(i, arr);
				}
			}
		}
	}
	
	public boolean proof(int k, int i) {
		return k <= count && ((i + 1) % k == 0);
	}
	
	public void out() {
		int count_safes = 0;
		System.out.print("Safe opened: ");
		for(int i = 0; i < count; i++) {
			if(arr.get(i)) {System.out.print(i + 1 + ","); count_safes++;}
		}
		System.out.println("\nCount open safes: " + count_safes);
	}
}
