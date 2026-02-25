package lista00;
import  java.util.Scanner;

public class ex1 {
	
	public static int fatorial(int num) {
		if(num == 1) {
			return 1;
		}
		
		else {
			return num * fatorial(num-1);
		}
				
	}
	
	public static void main(String args[]) {
		System.out.printf("Insira número:");
		Scanner sc = new Scanner(System.in);
		int num = 0;
		num = sc.nextInt();
		
		int resultado = fatorial(num);
		System.out.print(resultado);
		sc.close();
	}

}
