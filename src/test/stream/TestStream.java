package test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import test.MainNode;
import test.utill.ITest;
import test.utill.TestUtill;

public class TestStream extends MainNode {

	@Override
	public void run() {
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add("Six");
		list.add("Seven");
		list.add("Eight");
		list.add("Nine");
		list.add("Ten");
		Stream stream = list.stream();
		       
		stream.filter(x -> x.toString().length() == 3).forEach(System.out::print);
		       
		System.out.print(" ");
		       
		IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10)
			.limit(3).forEach(System.out::print);
		       
		System.out.print(" ");
		       
		int[] arr = {70, 80, 90, 100, 110, 120};
		int count = 0;
		for (int x : arr) {
			if (x >= 90) continue;
			x += 10;
			count++;
			if (count > 3) break;
			System.out.print(x);
		}
		
		String[] array = {"Java", "Ruuuuussshhh"};
		Stream<String> streamOfArray = Arrays.stream(array);
		streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
			.flatMap(Arrays::stream).distinct() //выравнивает каждый сгенерированный поток в один поток
			.collect(Collectors.toList()).forEach(System.out::println);
		
		Stream.of(2, 3, 0, 1, 3)
			.flatMapToInt(x -> IntStream.range(0, x))
			.forEach(System.out::print);
		    			
		List<String> list1 = Stream.of("One", "Two", "Three").collect(Collectors.toList());
		System.out.print(list1);
		
		Stream<String> phones = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2", 
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");
   
        ArrayList<String> filteredPhones = phones.filter(s->s.length()<12)
        		.map(x -> x.split(""))
        		.flatMap(x -> Arrays.stream(x))
        		.collect(
        				()->new ArrayList<String>(), // создаем ArrayList
        				(nlist, item)->nlist.add(item), // добавляем в список элемент
        				(nlist, nlist2)-> nlist.addAll(list)); // добавляем в список другой список
          
        filteredPhones.forEach(s->System.out.println(s));
        
        int count1 = 10000;
        List<String> list2 = new ArrayList<>();
        
        for(int i = 'а' ; i < 'я'; i++) {
        	for(int k = 'а' ; k < 'я'; k++) {
        		for(int j = 'а' ; j < 'я'; j++) {
                	list2.add("" + (char)i + (char)k + (char)j);
                }
            }
        }
        
        
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test2(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test(list2), count1) + " nsec");
        
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test2(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test2(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test(list2), count1) + " nsec");
        System.out.println("Speed run metod: " + TestUtill.testSpeed(test2(list2), count1) + " nsec");
    }
	
	public ITest test(List<String> list1) {
		ITest t = () -> {
		List<String> list2 = list1;

	    list2.parallelStream()
	    		.collect(
	    				StringBuilder::new,
	    				(res, elem) -> {
	    					res.append(" ").append(elem);
	    				}, 
	    				(res1, res2) -> {
	    					res1.append(res2.toString());
	    					//System.out.printf("res1=%s, res2=%s\n", res1, res2);
	    				});
	    
	    //System.out.println("collect=" + collect);
		};
	    return t;
	}
	
	public ITest test2(List<String> list1) {
		ITest t = () -> {
			List<String> list2 = list1;
	
		    list2.stream()
		    		.collect(
		    				StringBuilder::new,
		    				(res, elem) -> {
		    					res.append(" ").append(elem);
		    				}, 
		    				(res1, res2) -> {
		    					res1.append(res2.toString());
		    					//System.out.printf("res1=%s, res2=%s\n", res1, res2);
		    				});
		    
		    //System.out.println("collect=" + collect);
	    };
	    return t;
	}
	
	
}
