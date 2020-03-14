package test.lambda;

import test.MainNode;

public class TestLambda extends MainNode{
	@Override
	public void run() {
		Cat myCat = new Cat();
        System.out.println(myCat);

        // создаем лямбду
        Settable<Cat> s = (obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        };

        // вызываем метод, в который передаем кота и лямбду
        changeEntity(myCat, s);
        // выводим на экран и видим, что состояние кота изменилось (имеет имя и возраст)
        System.out.println(myCat);
	}
	
	private static <T extends WithNameAndAge>  void changeEntity(T entity, Settable<T> s) {
        s.set(entity, "Мурзик", 3);
    }
}
