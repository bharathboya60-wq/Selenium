package SeleniumPractice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;
public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> Names = new ArrayList<String>();
		Names.add("Ankit");
		Names.add("Anu");
		Names.add("Bharath");
		Names.add("Bhanu");
		Names.add("Ajay");
		Names.add("Bheema");
		Names.add("Arjuna");
		Names.add("Anushka");
		Names.add("Ankit");
		Names.add("Anu");
		Names.add("Bharath");
		Names.add("Bhanu");
		Names.add("Ajay");
		Names.add("Bheema");
		Names.add("Arjuna");
		Names.add("Anushka");
		for(String name: Names)
		{
			if(name.charAt(0) == 'A' || name.charAt(0) == 'a')
			{
//				System.out.println(name);
			}

		}
		
		List<String> Alpha1 = new ArrayList<>(List.of("a","c", "e"));
		List<String> Alpha2 = new ArrayList<>(List.of("b","d", "f"));
		
		
		System.out.println("Stream Filter");
//		System.out.print(StreamFilter(Names));
		StreamFilter(Names);
		
		
		System.out.println("Sorted Stream");
		SortStream(Names);
		
		
		System.out.println("Concated Streams");
		ConcatStream(Alpha1, Alpha2);
		
		System.out.println("Collectors in Streams");
		CollectorStream(Names);
		
		
	}

	private static void StreamFilter(List<String> NamedF) {
		
		NamedF.stream()
	            .filter(s -> {
	                if (s.charAt(0) == 'A' || s.charAt(0) == 'a') {
//	                    System.out.println("Starts with A");
	                    return true;
	                }
	                else {
	                	 return false;
	                }
	               
	            })
	             .map(s->s.toUpperCase())
	             .forEach(s->System.out.println(s));
	}
	
	public static void SortStream(List<String> NamedS) {
		NamedS.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	public static void ConcatStream(List<String> Alpha1, List<String> Alpha2) {
		Stream<String> NewStream = Stream.concat(Alpha1.stream(), Alpha2.stream()).sorted();
		NewStream.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		boolean flags = Alpha1.stream().anyMatch(s->s.equalsIgnoreCase("a"));
		System.out.println(flags);
		
	}
	
	public static void CollectorStream(List<String> Alpha1) {
		List<String> Cls = Alpha1.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		Set<String> Ses = Alpha1.stream().map(s->s.toUpperCase()).collect(Collectors.toSet());
		System.out.println("Iterator of the List Stream");
		for(String C:Cls) {
			System.out.println(C);
		}
		System.out.println(Cls.get(1));
		System.out.println("Iterator of the Set Stream");
		Iterator<String> It = Ses.iterator();
		while(It.hasNext()) {
			System.out.println(It.next());
		}
		
		
	}

}
