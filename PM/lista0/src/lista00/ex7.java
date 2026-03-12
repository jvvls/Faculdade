import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] temperaturas = new double[12];
        String[] meses = {
            "janeiro", "fevereiro", "marco", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
        };

        for (int i = 0; i < 12; i++) {
            System.out.print("Temperatura media de " + meses[i] + ": ");
            temperaturas[i] = sc.nextDouble();
        }

        double maiorTemp = temperaturas[0];
        double menorTemp = temperaturas[0];
        int mesMaior = 0;
        int mesMenor = 0;

        for (int i = 1; i < 12; i++) {
            if (temperaturas[i] > maiorTemp) {
                maiorTemp = temperaturas[i];
                mesMaior = i;
            }

            if (temperaturas[i] < menorTemp) {
                menorTemp = temperaturas[i];
                mesMenor = i;
            }
        }

        System.out.printf("Maior temperatura: %.2f em %s%n", maiorTemp, meses[mesMaior]);
        System.out.printf("Menor temperatura: %.2f em %s%n", menorTemp, meses[mesMenor]);

        sc.close();
    }
}
