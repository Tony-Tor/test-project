package test.treemap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import test.MainNode;
import test.utill.ITest;
import test.utill.TestUtill;

public class TestTreeMap extends MainNode {

	List<String> list2 = new ArrayList<>();
	
	TreeMap<Integer, String> tree_map_for_test_speed;
	
	HashMap<Integer, String> hash_map_for_test_speed;
	
	Random r = new Random();
	
	@Override
	public void run() {
		test();
		System.out.println("Speed run metod \"initHashMap\" : " + TestUtill.testSpeed(initHashMap()) + " nsec");
		System.out.println("Speed run metod \"initTreeMap\" : " + TestUtill.testSpeed(initTreeMap()) + " nsec");
		double test_random = TestUtill.testSpeed(testSpeedRandom(), TestUtill.DEFAULT_COUNT*1000);
		System.out.println("Speed run metod with random element \"testHashMap\" : " + (TestUtill.testSpeed(testHashMap(), TestUtill.DEFAULT_COUNT*1000) - test_random) + " nsec");
		System.out.println("Speed run metod with random element \"testTreeMap\" : " + (TestUtill.testSpeed(testTreeMap(), TestUtill.DEFAULT_COUNT*1000) - test_random) + " nsec");
		System.out.println("Speed run metod without random element \"testHashMap\" : " + (TestUtill.testSpeed(testHashMapout(), TestUtill.DEFAULT_COUNT*1000)) + " nsec");
		System.out.println("Speed run metod without random element \"testTreeMap\" : " + (TestUtill.testSpeed(testTreeMapout(), TestUtill.DEFAULT_COUNT*1000)) + " nsec");

	}
	
	public ITest initHashMap(){
		ITest t = () -> {
			hash_map_for_test_speed = new HashMap<>();
			int key = 0;
	        for(int i = 'а' ; i < 'я'; i++) {
	        	for(int k = 'а' ; k < 'я'; k++) {
	        		for(int j = 'а' ; j < 'я'; j++) {
	        			hash_map_for_test_speed.put(key++, "" + (char)i + (char)k + (char)j);
	                }
	            }
	        }
		};
	    return t;
	}
	
	public ITest initTreeMap(){
		ITest t = () -> {
			tree_map_for_test_speed = new TreeMap<>(new Comparator<Integer>() {
		        @Override
		        public int compare(Integer o1, Integer o2) {
		            return o1 - o2;
		        }
		    });
			int key = 0;
	        for(int i = 'а' ; i < 'я'; i++) {
	        	for(int k = 'а' ; k < 'я'; k++) {
	        		for(int j = 'а' ; j < 'я'; j++) {
	        			tree_map_for_test_speed.put(key++, "" + (char)i + (char)k + (char)j);
	                }
	            }
	        }
		};
	    return t;
	}
	
	public ITest testTreeMap() {
		ITest t = () -> {
			tree_map_for_test_speed.get(r.nextInt(33*33*33));
		};
	    return t;
	}
	
	public ITest testHashMap() {
		ITest t = () -> {
			hash_map_for_test_speed.get(r.nextInt(33*33*33));
		};
	    return t;
	}
	
	public ITest testTreeMapout() {
		ITest t = () -> {
			tree_map_for_test_speed.get(10000);
		};
	    return t;
	}
	
	public ITest testHashMapout() {
		ITest t = () -> {
			hash_map_for_test_speed.get(10000);
		};
	    return t;
	}
	
	public ITest testSpeedRandom(){
		ITest t = () -> {
			r.nextInt(33*33*33);
		};
	    return t;
	}
	
	public void test() {
	      TreeMap<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
	          @Override
	          public int compare(Person o1, Person o2) {
	              return o1.age - o2.age;
	          }
	      });
	      map.put(new Person("John", "Smith", 17), 0);
	      map.put(new Person("Ivan", "Petrenko", 65), 0);
	      map.put(new Person("Pedro", "Escobar", 32), 0);
	      map.put(new Person("Radion", "Pyatkin", 14), 0);
	      map.put(new Person("Sergey", "Vashkevich", 19), 0);
	      
	      System.out.println(map.toString());

	      Person firstAdultPerson = map.navigableKeySet().stream().filter(person -> person.age>18).findFirst().get();

	       Map<Person, Integer> youngPeopleMap = map.headMap(firstAdultPerson, false);
	       Map<Person, Integer> adultPeopleMap = map.tailMap(firstAdultPerson, true);
	       showAdvertisementToYoung(youngPeopleMap);
	       showAdvertisementToAdult(adultPeopleMap);
	   }

	   public static void showAdvertisementToYoung(Map<Person, Integer> map){
		   System.out.println(map.toString());
	   }
	   public static void showAdvertisementToAdult(Map<Person, Integer> map){
		   System.out.println(map.toString());
	   }

}
