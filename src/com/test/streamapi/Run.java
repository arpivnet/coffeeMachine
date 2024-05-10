package com.test.streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface fi
{
	// public void print(Integer variable);
	public boolean isEqual(Integer s);
}

public class Run
{

	public static void main(String[] args)
	{

		// fi cinterface=(variable)->{return variable==3;};

		// System.out.println(cinterface.isEqual(3));
//		fi cinterface1=new fi() {
//			@Override 
//			public void print(Integer variable){System.out.println("I am a variablle="+variable);}
//		};
//		
//		
//		cinterface1.print(89);

		List<String> list = Arrays.asList("A", "B,ta", "C", "D");

//		int count=Collections.frequency(list, "A");
//		System.out.println("Count="+count);

		Map<String, List<String>> out = list.stream().filter(c -> !c.equals("C")).map(d -> d.replace(",", "!")).sorted()
				.collect(Collectors.groupingBy(Function.identity()));
		// .forEach(f->System.out.println("----->"+f));
		// System.out.println(out);
		// System.out.println(list.stream().count());

//		List<String> list=Arrays.asList("A,zb","B,ta","C","D");			
//		String out=list.stream()
//				.filter(c->!c.equals("C"))
//				.map(d->d.replace(",", "!"))
//				.collect(Collectors.joining("\n"));
//				//.collect(Collectors.groupingBy(Function.identity()));
//		//.forEach(f->System.out.println("----->"+f));
//		System.out.println(out);
//		System.out.println(list.stream().count());

//		String filtered="";
//		for(String s:list) {
//			if(!s.equals("C")) {
//				filtered+=s;
//				System.out.println(">"+filtered);
//			}
//		}
//		
//		System.out.println("======>"+filtered);

	}

}
