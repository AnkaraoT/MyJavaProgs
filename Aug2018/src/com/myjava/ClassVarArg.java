
public class ClassVarArg {

	public static void main(String[] args) {
		//m1();
		m1(3);
		m1(5,7,8);

		int[] a = {45,56,78,22};
		int[] b = {5,6,8,2};
		m1(a);
		//m1(a,b);
	}
	
	public static void m1(int...x) {		
		for(int x1:x) {
			System.out.println(x1);
		}		
		System.out.println("=================");
	}
	
	/*public static void m1(int[]...x) {		
		for(int[] x1:x) {
			System.out.println(x1[0]);			
		}	
		System.out.println("-------------------");
	}	*/
}
