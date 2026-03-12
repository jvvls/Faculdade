import java.util.Scanner;


public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maiorIdade = Integer.MIN_VALUE;
        int menorIdade = Integer.MAX_VALUE;
        int qtdMulheresFiltro = 0;
        boolean temHabitante = false;

        while (true) {
            System.out.print("Idade (-1 para encerrar):\n");
            int idade = sc.nextInt();

            if (idade == -1) {
                break;
            }

            temHabitante = true;

            if (idade > maiorIdade) {
                maiorIdade = idade;
            }
            if (idade < menorIdade) {
                menorIdade = idade;
            }

            System.out.print("Sexo (masculino/feminino):\n");
            String sexo = sc.next().toLowerCase();

            System.out.print("Cor dos olhos (azuis/verdes/castanhos):\n");
            String olhos = sc.next().toLowerCase();

            System.out.print("Cor dos cabelos (louros/castanhos/pretos):\n");
            String cabelos = sc.next().toLowerCase();

            if (sexo.equals("feminino")
                && idade >= 18 && idade <= 35
                && olhos.equals("verdes")
                && cabelos.equals("louros")) {
                qtdMulheresFiltro++;
            }
        }

        if (temHabitante) {
            System.out.println("Maior idade: " + maiorIdade);
            System.out.println("Menor idade: " + menorIdade);
        } else {
            System.out.println("Nenhum habitante informado.");
        }

        System.out.println(
            "Quantidade de mulheres entre 18 e 35 anos, com olhos verdes e cabelos louros: "
            + qtdMulheresFiltro
        );

        sc.close();
    }
}
