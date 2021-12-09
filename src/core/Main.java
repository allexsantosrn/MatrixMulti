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

		// Cria as Strings com o caminho dos arquivos escolhidos.
		String arquivoA = new String("dados/A" + tamMatriz + "x" + tamMatriz + ".txt");
		String arquivoB = new String("dados/B" + tamMatriz + "x" + tamMatriz + ".txt");

		ManipulaArquivo lerArquivo = new ManipulaArquivo();

		// Ler o arquivo e cria as matrizes.
		int A[][] = lerArquivo.lerAquivo(arquivoA);
		int B[][] = lerArquivo.lerAquivo(arquivoB);

		// Caso o argumento passado seja do tipo Sequencial
		if (args[1].equals("S")) {

			CalculoSequencial calculoSequencial = new CalculoSequencial();

			long inicioSequencial = System.currentTimeMillis();
			int C[][] = calculoSequencial.MultriplicaMatrizes(A, B, tamMatriz);

			long terminoSequencial = System.currentTimeMillis() - inicioSequencial;

			System.out.println("Tempo de execu��o: " + terminoSequencial);

			/*
			 * for (int linhaAtual = 0; linhaAtual < tamMatriz; linhaAtual++) {
			 * 
			 * for (int colunaAtual = 0; colunaAtual < tamMatriz; colunaAtual++) {
			 * 
			 * System.out.print(C[linhaAtual][colunaAtual]); System.out.print(" "); }
			 * 
			 * System.out.println("");
			 * 
			 * }
			 */

			// Salvando arquivo
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();

			salvarArquivo.salvarArquivo(C, tamMatriz);

		}

		if (args[1].equals("C")) {

		}

	}

}
