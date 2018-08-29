import java.util.Iterator;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		ClassList<Integer> list = new ClassList<Integer>();
		
		/*list.add("123-A");
		list.add("123-B");
		list.add("123-C");
		list.add("123-D");
		list.add("123-E");
		*/
		/*list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(15));
		list.add(new Integer(167));
		list.add(new Integer(891));
		
		for(int i=0;i<list.size();i++) {
			System.out.println( i+" : "+list.get(i) );
		}*/
		
		ClassMap<String, String> myMap = new ClassMap<String,String>();
		myMap.put("A", "1");
		myMap.put("B", "4");
		myMap.put("C", "4");
		myMap.put("D", "6");
		myMap.put("A", "9");
		
		Set<String> keySet = myMap.keySet();
		System.out.println("keySet - "+keySet.size());
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
			System.out.println( string+" : "+myMap.get(string) );
		}
	}

}
