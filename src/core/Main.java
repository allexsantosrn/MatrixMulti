package core;

public class Main {

	public static void main(String[] args) {
		
		// Verifica se o número de parâmetros informados é diferente de 2 e encerra o
				// programa.
				if (args.length != 2) {

					System.out.println("Programa encerrado!!");
					System.out.println("Quantidade de parâmetros informados inválida!!");
					System.exit(0);
				}

				// Verifica se os parâmetros informados são diferentes de "S" ou "C" e encerra o
				// programa.
				if ((!args[1].equals("S")) && (!args[1].equals("C"))) {

					System.out.println("Programa encerrado!!");
					System.out.println("Parâmetros informados são inválidos!!");
					System.exit(0);
				}

				// Recebendo primeira variável do argumento e convertendo para inteiro.
				int tamMatriz = Integer.parseInt(args[0]);

				// Verifica se os parâmetros de tamanho da matriz informados são diferente dos
				// tamanhos especificados.
				if ((tamMatriz != 4) && (tamMatriz != 8) && (tamMatriz != 16) && (tamMatriz != 32) && (tamMatriz != 64)
						&& (tamMatriz != 128) && (tamMatriz != 256) && (tamMatriz != 512) && (tamMatriz != 1024)
						&& (tamMatriz != 2048)) {

					System.out.println("Programa encerrado!!");
					System.out.println("Tamanho das matrizes informadas é inválido!!");
					System.exit(0);
				}

	}

}
