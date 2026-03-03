import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int QUESTOES = 8;
        final int ALUNOS = 10;
        final int NOTA_MINIMA = 6;

        String[] gabarito = new String[QUESTOES];

        System.out.println("Digite o gabarito da prova (8 respostas):");
        for (int i = 0; i < QUESTOES; i++) {
            System.out.print("Questao " + (i + 1) + ": ");
            gabarito[i] = sc.next().toUpperCase();
        }

        int aprovados = 0;

        for (int i = 0; i < ALUNOS; i++) {
            System.out.print("\nNumero do aluno: ");
            int numeroAluno = sc.nextInt();

            int nota = 0;
            System.out.println("Respostas do aluno " + numeroAluno + ":");

            for (int j = 0; j < QUESTOES; j++) {
                System.out.print("Questao " + (j + 1) + ": ");
                String resposta = sc.next().toUpperCase();

                if (resposta.equals(gabarito[j])) {
                    nota++;
                }
            }

            if (nota >= NOTA_MINIMA) {
                aprovados++;
            }

            System.out.println("Aluno " + numeroAluno + " - Nota: " + nota);
        }

        double porcentagemAprovacao = (aprovados * 100.0) / ALUNOS;
        System.out.printf("\nPorcentagem de aprovacao: %.2f%%%n", porcentagemAprovacao);

        sc.close();
    }
}
