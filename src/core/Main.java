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
		int dimensao = Integer.parseInt(args[0]);

		// Verifica se os par�metros de tamanho da matriz informados s�o diferente dos
		// tamanhos especificados.
		if ((dimensao != 4) && (dimensao != 8) && (dimensao != 16) && (dimensao != 32) && (dimensao != 64)
				&& (dimensao != 128) && (dimensao != 256) && (dimensao != 512) && (dimensao != 1024)
				&& (dimensao != 2048)) {

			System.out.println("Programa encerrado!!");
			System.out.println("Tamanho das matrizes informadas � inv�lido!!");
			System.exit(0);
		}

		// Cria as Strings com o caminho dos arquivos escolhidos.
		String arquivoA = new String("dados/A" + dimensao + "x" + dimensao + ".txt");
		String arquivoB = new String("dados/B" + dimensao + "x" + dimensao + ".txt");

		ManipulaArquivo lerArquivo = new ManipulaArquivo();

		// Ler o arquivo e cria as matrizes.
		int A[][] = lerArquivo.lerAquivo(arquivoA);
		int B[][] = lerArquivo.lerAquivo(arquivoB);

		// Caso o argumento passado seja do tipo Sequencial
		if (args[1].equals("S")) {

			String metodo = "S";

			long inicioSequencial = System.currentTimeMillis();

			CalculoSequencial calculoSequencial = new CalculoSequencial(A, B, dimensao);
			calculoSequencial.MultiplicaMatrizes();
			int C[][] = calculoSequencial.getC();

			long terminoSequencial = System.currentTimeMillis() - inicioSequencial;

			System.out.println("Tempo de execu��o: " + terminoSequencial);

			// Salvando arquivo
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();

			salvarArquivo.salvarArquivo(C, dimensao, metodo);

			ManipulaArquivo salvarTempo = new ManipulaArquivo();

			salvarTempo.salvarTempo(terminoSequencial, dimensao, metodo);

		}

		if (args[1].equals("C")) {

			long inicioConcorrente = System.currentTimeMillis();
			// int C[][] = calculoSequencial.MultriplicaMatrizes(A, B, dimensao);

			long terminoConcorrente = System.currentTimeMillis() - inicioConcorrente;

			System.out.println("Tempo de execu��o: " + terminoConcorrente);

		}

	}

}
