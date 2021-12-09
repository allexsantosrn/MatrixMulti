package core;

public class Main {

	public static void main(String[] args) {
		
		// Verifica se o n�mero de par�metros informados � diferente de 2 e encerra o
				// programa.
				if (args.length != 2) {

					System.out.println("Programa encerrado!!");
					System.out.println("Quantidade de par�metros informados inv�lida!!");
					System.exit(0);
				}

				// Verifica se os par�metros informados s�o diferentes de "S" ou "C" e encerra o
				// programa.
				if ((!args[1].equals("S")) && (!args[1].equals("C"))) {

					System.out.println("Programa encerrado!!");
					System.out.println("Par�metros informados s�o inv�lidos!!");
					System.exit(0);
				}

				// Recebendo primeira vari�vel do argumento e convertendo para inteiro.
				int tamMatriz = Integer.parseInt(args[0]);

				// Verifica se os par�metros de tamanho da matriz informados s�o diferente dos
				// tamanhos especificados.
				if ((tamMatriz != 4) && (tamMatriz != 8) && (tamMatriz != 16) && (tamMatriz != 32) && (tamMatriz != 64)
						&& (tamMatriz != 128) && (tamMatriz != 256) && (tamMatriz != 512) && (tamMatriz != 1024)
						&& (tamMatriz != 2048)) {

					System.out.println("Programa encerrado!!");
					System.out.println("Tamanho das matrizes informadas � inv�lido!!");
					System.exit(0);
				}

	}

}
