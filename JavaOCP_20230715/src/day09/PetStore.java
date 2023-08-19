package day09;

public class PetStore {

	public static void main(String[] args) {
		// 多型應用
		Dog dog = new Dog("柴犬");
		Cat cat = new Cat("波斯貓");
		
		Animal a1 = new Dog("米葛魯");
		Animal a2 = new Cat("花臉貓");
		Animal a3 = new Bird("白文鳥");
		
		// 多型在宣告上面會具有較多的靈活性
		Animal x = new Dog("Dog1");
		x = new Cat("Cat2");
		
		
		System.out.printf("%s", dog.getName());
		dog.sound();
		System.out.printf("%s", cat.getName());
		cat.sound();
		
		// 有一個動物陣列, 裡面有狗跟貓
		Animal[] animals = {dog, cat, a1, a2, a3};
		for(Animal animal : animals) {
			System.out.printf("%s", animal.getName());
			animal.sound();
		}
		
	}

}
