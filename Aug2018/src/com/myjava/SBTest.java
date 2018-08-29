public class SBTest {

	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
       
       System.out.println(sb.length());
       System.out.println("capacity -"+sb.capacity());
       System.out.println(sb);
       
       sb.append("AnkaraoTammisett");
       System.out.println("length - "+sb.length());
       System.out.println("capacity -"+sb.capacity());
       System.out.println(sb);
       //"AnkaraoTammisett";	
       Object obj = null;
       sb.append(obj);
       System.out.println("length - "+sb.length());
       System.out.println("capacity -"+sb.capacity());
       System.out.println(sb);
       sb.append("ymtech234213423sdafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdfffffffffffffffffffffffffffffffffffffffffffffffffaaaaaaaaaaa");
       System.out.println("length - "+sb.length());
       System.out.println("capacity -"+sb.capacity());
       System.out.println(sb);
       
       System.out.println("-------------------------------");
       
       ClassStringBuilder csb= new ClassStringBuilder();
       
       System.out.println("length - "+csb.length());
       System.out.println("capacity -"+csb.capacity());
       System.out.println(csb);
       
       csb.append("AnkaraoTammisett");
       System.out.println("length - "+csb.length());
       System.out.println("capacity -"+csb.capacity());
       System.out.println(csb);
       //"AnkaraoTammisett";		
       csb.append(null);
       System.out.println("length - "+csb.length());
       System.out.println("capacity -"+csb.capacity());
       System.out.println(csb);
       csb.append("ymtech234213423sdafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdfffffffffffffffffffffffffffffffffffffffffffffffffaaaaaaaaaaa");
       System.out.println("length - "+csb.length());
       System.out.println("capacity -"+csb.capacity());
       System.out.println(csb);
	}
	

}
