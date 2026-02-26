package lista00;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;


public class ex4 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	Set<Integer> z = new HashSet<>();
    	
    	System.out.printf("Tamanho de x:\n");
    	int n = sc.nextInt();
    	
    	System.out.printf("Tamanho de y:\n");
    	int m = sc.nextInt();
    	
    	int[] x = new int[n];
    	int[] y = new int[m];
    	
    	for(int i = 0; i < n; i++) {
    		System.out.printf("Entrada:\n");
    		x[i] = sc.nextInt();
    	}
    	
    	for(int i = 0; i < m; i++) {
    		System.out.printf("Entrada:\n");
    		y[i] = sc.nextInt();
    	}
    	
    	for(int num : x) {
    		z.add(num);
    	}
    	
		for (int num : y) {
		z.add(num);
		}
    	
    	for(int num : z) {
    		System.out.print(num+" ");
    	}
    	
    	
    	sc.close();
    }
}
