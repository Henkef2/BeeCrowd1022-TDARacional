import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat; 

public class Main {
    public static void main(String[] args) throws IOException {
        // Garante o uso do ponto (.) como separador decimal
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        // Lê a quantidade de casos de teste
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            // Lê a primeira fração: N1 / D1
            int n1 = input.nextInt();
            input.next(); // Ignora a barra '/'
            int d1 = input.nextInt();

            // Lê o operador matemático (+, -, * ou /)
            String operacao = input.next();

            // Lê a segunda fração: N2 / D2
            int n2 = input.nextInt();
            input.next(); // Ignora a barra '/'
            int d2 = input.nextInt();

            int numF = 0; // Numerador final
            int denF = 0; // Denominador final

            // Aplica as fórmulas fornecidas pelo enunciado
            if (operacao.equals("+")) {
                numF = (n1 * d2 + n2 * d1);
                denF = (d1 * d2);
            } else if (operacao.equals("-")) {
                numF = (n1 * d2 - n2 * d1);
                denF = (d1 * d2);
            } else if (operacao.equals("*")) {
                numF = (n1 * n2);
                denF = (d1 * d2);
            } else if (operacao.equals("/")) {
                numF = (n1 * d2);
                denF = (n2 * d1);
            }

            // Calcula o Máximo Divisor Comum para simplificar
            int mdcVal = mdc(numF, denF);

            int numSimp = numF / mdcVal;
            int denSimp = denF / mdcVal;

            // Correção de sinal: se o denominador ficar negativo, joga o sinal para o numerador
            if (denSimp < 0) {
                numSimp = -numSimp;
                denSimp = -denSimp;
            }

            // Imprime no formato exato exigido: original = simplificado
            System.out.print(numF + "/" + denF + " = " + numSimp + "/" + denSimp + "\n");
        }

        input.close();
    }

    // Método recursivo para calcular o MDC (Algoritmo de Euclides)
    public static int mdc(int a, int b) {
        if (b == 0) {
            return Math.abs(a); // Usa valor absoluto para não quebrar com negativos
        }
        return mdc(b, a % b);
    }
}
