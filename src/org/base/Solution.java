package org.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int i1=1, i2=3;
		String message="Dumb mofo";
		
		System.out.println(" i1|i2 "+(i1|i2));
		System.out.println("nifty".getClass().getSimpleName());
		System.out.println("substring: "+message.charAt(i1+1));
		
		List<Object> l=new ArrayList<>();
		l.add("one");
		l.add(2);
		
		System.out.println(l.get(0) instanceof Object);
		System.out.println(l.get(1) instanceof Integer);
		
		String msg="Hello world, is changing";
		//System.out.println(msg.substring(12, 6));
		
		System.out.println("Apple".compareTo("Banana"));
		return;
	}
}
