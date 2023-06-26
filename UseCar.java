package day20CollectionStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseCar {
	public static void main(String[] args) {
		Car c1=new Car("Audi",4000000,2015,"blue");
		Car c2=new Car("Benz",5000000,2017,"black");
		Car c3=new Car("BMW",6000000,2013,"Grey");
		Car c4=new Car("Honda",1000000,2018,"Red");
		Car c5=new Car("Hyundai",2000000,2016,"White");
		Car c6=new Car("Audi",7000000,2019,"Silver");
		Car c7=new Car("Rolls Royce",10000000,2015,"Red");
		
		ArrayList<Car> cars=new ArrayList<>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);
		cars.add(c6);
		cars.add(c7);
		
		List<Car> brand = cars.stream().filter(x->x.getBrand().equalsIgnoreCase("Audi")).collect(Collectors.toList());
		brand.forEach(y->System.out.println(y));
		System.out.println("------------------------------------------");
		
		long brandCount = brand.stream().count();
		System.out.println(brandCount);
		System.out.println("-------------------------------------------");
		
		List<Car> price = cars.stream().filter(z->z.getPrice()>4000000).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		System.out.println("--------------------------------------------");
		
		long priceCount = price.stream().count();
		System.out.println(priceCount);
		System.out.println("--------------------------------------------");
		
		List<String> model = cars.stream().filter(t->t.getModel()>2015).map(m->m.getBrand()).collect(Collectors.toList());
		model.forEach(u->System.out.println(u));
		System.out.println("---------------------------------------------");
		
		List<Car> color = cars.stream().filter(o->!o.getColor().equalsIgnoreCase("black")).collect(Collectors.toList());
		color.forEach(k->System.out.println(k));
		System.out.println("---------------------------------------------");
		
		long colorCount = color.stream().count();
		System.out.println(colorCount);
		System.out.println("----------------------------------------------");
		
		List<Car> limit = cars.stream().limit(3).collect(Collectors.toList());
		limit.forEach(d->System.out.println(d));
		System.out.println("----------------------------------------------");
		
		Car max = cars.stream().max(Comparator.comparing(Car::getPrice)).get();
		System.out.println("Max="+max);
		
		Car min = cars.stream().min(Comparator.comparing(Car::getPrice)).get();
		System.out.println("Min="+min);
		System.out.println("----------------------------------------------");
		
		List<Car> sort = cars.stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
		sort.forEach(q->System.out.println(q));
		System.out.println("----------------------------------------------");
		int a=cars.size()-2;
		Car car = sort.get(a);
		System.out.println(car);
		
		Map<String, Car> car1 = cars.stream().filter(x->x.getColor().equalsIgnoreCase("red")).collect(Collectors.toMap(z->z.getBrand(),y->y));
		System.out.println(car1);
		
		List<Car> list = car1.values().stream().filter(l->l.getPrice()>4000000).collect(Collectors.toList());
		
		
	}
}