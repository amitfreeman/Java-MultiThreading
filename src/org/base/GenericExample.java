package org.base;

import java.util.ArrayList;
import java.util.List;

class Container<T extends Number, U extends Number, Z>{
	T tVal;
	U uVal;
	Z zVal;
	
	public  Container() {};
	
	public Container(T t, U u, Z z) {
		this.tVal=t;
		this.uVal=u;
		this.zVal=z;
	}
	
	public Number myMax() {
        double i=Double.parseDouble(tVal.toString());
        double y=Double.parseDouble(uVal.toString());
     
        return  Double.max(i, y);
   	}
	
	@Override
	public String toString() {
		return "Container [tVal=" + tVal + ", uVal=" + uVal + ", zVal="+zVal+"]";
	}
}

public class GenericExample {

	public static void main(String[] args) {
         
		 //Generic collection
         List<Integer> listN=new ArrayList<>();
         listN.add(2);
         listN.add(3);
         
         for(Integer ai: listN) {
        	 System.out.print(" "+ai);
         }
         System.out.println("");
         
         //Generic class
         Container<Integer,Integer, String> con1=
        		 new Container<Integer,Integer, String>(3, 33, "Three");
         System.out.println(con1.toString());
         System.out.println("Max num is = "+con1.myMax());
	}

}
