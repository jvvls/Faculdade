package lista00;

public class ex10 {

    public static void main(String[] args) {
        double[][] calendario = new double[12][4];

        String[] meses = {
            "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        double totalMes;
        double totalSemana;
        double totalAnual = 0;

        for (int i = 0; i < 12; i++) {
            totalMes = 0;
            for (int j = 0; j < 4; j++) {
                totalMes += calendario[i][j];
            }
            System.out.printf("Total do mes %s: %.2f%n", meses[i], totalMes);
            totalAnual += totalMes;
        }

        for (int i = 0; i < 4; i++) {
            totalSemana = 0;
            for (int j = 0; j < 12; j++) {
                totalSemana += calendario[j][i];
            }
            System.out.printf("Total da semana %d: %.2f%n", (i + 1), totalSemana);
        }

        System.out.printf("Total anual: %.2f%n", totalAnual);
    }
}
