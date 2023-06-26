package com.example.firstproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class Sample {
	@GetMapping(value="/Hello")
	public String getHi() {
		return "hello world";
	}
	@GetMapping(value="/MyName")
	public String getName() {
		return "Aditya";
	}
	@GetMapping(value="/add/{a}/{b}")
	public int add(@PathVariable int a,@PathVariable int b) {
		return a+b;
	}
	@GetMapping(value="/cube/{a}")
	public int cube(@PathVariable int a) {
		return a*a*a;
	}
	@GetMapping(value="iterate/{a}")
	public List<Integer> getVal(@PathVariable int a) {
		ArrayList<Integer> num=new ArrayList<>();
		for(int i=0 ; i<=a ; i++) {
			num.add(i);
		}
		return num;
	}
	@GetMapping(value="/fib/{f}")
	public List<Integer> fibonacci(@PathVariable int f) {
		ArrayList<Integer> num=new ArrayList<>();
		int a=0;
		int b=1;
		int c;
		for(int i=0 ; i<f ; i++) {
			num.add(a);
			c=a+b;
			a=b;
			b=c;
		}
		return num;
	}
	@GetMapping(value="/pal/{a}")
	public String val(@PathVariable String a) {
		String temp="";
		for(int i=a.length()-1 ; i>=0 ; i--) {
			temp=temp+a.charAt(i);
		}
			if(a.equals(temp)) {
				return "palindrome";
			}
			else {
				return "not palindrome";
			}
	}
	@GetMapping(value="/let/{a}")
	public int Letter(@PathVariable String a) {
		int count=0;
		for(int i=0 ; i<a.length() ; i++) {
			if(a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u') {
			count=count+1;;
			}
		}
		return count;
		}
	@GetMapping(value="/fact/{a}")
	public int Factorial(@PathVariable int a) {
		int fact=1;
		for(int i=1 ; i<=a ; i++) {
			fact=fact*i;
		}
		return fact;
	}
	@GetMapping(value="/prime/{a}")
	public String Prime(@PathVariable int a) {
		int count=0;
		for(int i=1 ; i<=a ; i++) {
			if(a%i==0) {
				count++;
			}
		}
			if(count==2) {
				return "prime";
			}
			else {
				return "not prime";
			}
	}
	@GetMapping(value="/check")
	public String checkPermission(@PathParam("username") String username,@PathParam("password")String password) {
		if(username.equalsIgnoreCase("mark") && password.equalsIgnoreCase("@ntony")) {
			return "Login Successful";
		}
		else {
			return "Access Denied";
		}
	}
		@GetMapping(value="/cars")
		public Car setCar(@RequestBody Car c) {
			return c;
		}
		@GetMapping(value="/cars1")
		public List<Car> cars(@RequestBody List<Car> c1) {
			return c1;
		}
		@GetMapping(value="/highestPrice")
		public List<Car> cars1(@RequestBody List<Car> c2) {
			List<Car> car1 = c2.stream().filter(x->x.getPrice()>2500000).collect(Collectors.toList());
			return car1;
		}
		@GetMapping(value="/blackcolor")
		public List<Car> cars2(@RequestBody List<Car> c3) {
			List<Car> car2 = c3.stream().filter(x->x.getColor().equalsIgnoreCase("black")).collect(Collectors.toList());
			return car2;
		}
		@GetMapping(value="/getMax")
		public Car cars3(@RequestBody List<Car> c4) {
			Car max = c4.stream().max(Comparator.comparing(Car::getPrice)).get();
			return max;
		}
		@GetMapping(value="/getMin")
		public Car cars4(@RequestBody List<Car> c5) {
			Car min = c5.stream().min(Comparator.comparing(Car::getPrice)).get();
			return min;
		}
		@RequestMapping(value="/bike/bikes")
		public List<Bike> bikes(@RequestBody List<Bike> b1) {
			return b1.stream().filter(x->x.getBrand().equalsIgnoreCase("Yamaha")).collect(Collectors.toList());
		}
}