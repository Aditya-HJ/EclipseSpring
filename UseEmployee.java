package day20CollectionStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
public class UseEmployee {
	public static void main(String[] args) {
		Employee e1=new Employee("Bala",24,"Male",20000);
		Employee e2=new Employee("Akash",42,"Male",45000);
		Employee e3=new Employee("Arjun",27,"Male",28000);
		Employee e4=new Employee("sita",28,"Female",27000);
		Employee e5=new Employee("Ram",36,"male",38000);
		Employee e6=new Employee("priya",30,"female",38000);
		Employee e7=new Employee("mala",23,"female",20000);
		Employee e8=new Employee("kumar",40,"Male",55000);
		Employee e9=new Employee("raj",22,"Male",23000);
		Employee e10=new Employee("madan",28,"Male",30000);
		
		ArrayList<Employee> emps=new ArrayList<>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		emps.add(e6);
		emps.add(e7);
		emps.add(e8);
		emps.add(e9);
		emps.add(e10);
		
//		List<Employee> femaleEmployees = emps.stream().filter(x->x.getGender().equalsIgnoreCase("female")).collect(Collectors.toList());
//		System.out.println(femaleEmployees);
//		femaleEmployees.forEach(y->System.out.println(y));
//		long femalecount = femaleEmployees.stream().count();
//		long femaleEmployeescount = emps.stream().filter(x->x.getGender().equalsIgnoreCase("female")).count();
		
		List<Employee> maleEmp = emps.stream().filter(y->y.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());
		maleEmp.forEach(z->System.out.println(z));
		System.out.println("-----------------------------------------------");
		long malecount = maleEmp.stream().count();
		System.out.println(malecount);
		System.out.println("-----------------------------------------------");
		
		List<Employee> salaryCollect = emps.stream().filter(a->a.getSalary()>30000 && a.getSalary()<60000).collect(Collectors.toList());
		salaryCollect.forEach(b->System.out.println(b));
		System.out.println("------------------------------------------------");
		
		List<Employee> nameCollect = emps.stream().filter(c->c.getName().startsWith("A")).collect(Collectors.toList());
		long nameCount = nameCollect.stream().count();
		System.out.println(nameCount);
		System.out.println("------------------------------------------------");
		
		List<Employee> ageCollect = emps.stream().filter(g->g.getAge()>35 && g.getAge()<50).collect(Collectors.toList());
		ageCollect.forEach(v->System.out.println(v));
		System.out.println("-------------------------------------------------");
		List<String> collectName = emps.stream().map(l->l.getName()).collect(Collectors.toList());
		 List<String> collectName1 = emps.stream().filter(k->k.getAge()<30).map(l->l.getName()).collect(Collectors.toList());
		collectName1.forEach(j->System.out.println(j));
	}
}
