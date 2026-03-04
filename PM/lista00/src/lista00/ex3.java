package lista00;
import java.util.HashSet;
import java.util.Set;


public class ex3 {
    public static void main(String[] args) {
    	
    	int[] matriculaProgramacao = {212121, 3131231, 12312312, 12312313};
    	int[] matriculaModelagem = {212121, 32323, 76676, 76767};
    	
        Set<Integer> set = new HashSet<>();
        
        for (int matricula : matriculaProgramacao){ {
        	set.add(matricula);
        }
        
        for (int matricula : matriculaModelagem){
        	if(set.contains(matricula)){
        	System.out.print(matricula);
        	}
        }
    }
}
