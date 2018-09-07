package test;

public class QuickTest2 {

	public static void main(String[] args){
		
		A a1 = new B();
		a1.printThis();
		
		A a2 = new C();
		a2.printThis();
		
		B b1 = new C();
		b1.printThis();
	}
}

class A {
	public void printThis(){
		System.out.println("AA");
	}
}

class B extends A {
	public void printThis(){
		System.out.println("BB");
	}
}

class C extends B {
	public void printThis(){
		System.out.println("CC");
	}
}