class Product{
	int price;
	int bonusPoint=10;
}

class Tv extends Product{
	boolean power;
}

class Computer extends Product{
}

class Audio extends Product{
}

class Buyer {
	int money =1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		money -= p.price;
		bonusPoint += p.bonusPoint;
	}
}
public class Ex38 {
	public static void main(String[]args) {
		Tv t = new Tv();
		t.price = 100;
		Computer c =new Computer();
		c.price = 200;
		Audio a = new Audio();
		a.price = 10;
		
		Buyer buyer = new Buyer();
		buyer.buy(t);
		System.out.println(buyer.money);
		buyer.buy(c);
		System.out.println(buyer.money);
		buyer.buy(a);
		System.out.println(buyer.money);
	}
}
