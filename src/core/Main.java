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

		// Ler o arquivo com o caminho especificado e cria as matrizes.
		int A[][] = lerArquivo.lerAquivo(arquivoA);
		int B[][] = lerArquivo.lerAquivo(arquivoB);

		// Caso o argumento passado seja do tipo sequencial
		if (args[1].equals("S")) {

			String metodo = "S";

			long inicioSequencial = System.currentTimeMillis();  // In�cio da contagem de tempo concorrente

			CalculoSequencial calculoSequencial = new CalculoSequencial(A, B, dimensao); 
			calculoSequencial.MultiplicaMatrizes();
			int C[][] = calculoSequencial.getC(); 

			long terminoSequencial = System.currentTimeMillis() - inicioSequencial; // T�rmino da contagem de tempo sequencial

			System.out.println("Tempo de execu��o: " + terminoSequencial); 
			
			
			// Salvando arquivo com resultado da multiplica��o.
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();
			salvarArquivo.salvarArquivo(C, dimensao, metodo);
			

			// Salvando arquivo com tempo de execu��o.
			ManipulaArquivo salvarTempo = new ManipulaArquivo();
			salvarTempo.salvarTempo(terminoSequencial, dimensao, metodo);

		}
		
		// Caso o argumento passado seja do tipo concorrente
		if (args[1].equals("C")) {

			String metodo = "C";

			long inicioConcorrente = System.currentTimeMillis(); // In�cio da contagem de tempo concorrente

			CalculoConcorrente calculoConcorrente = new CalculoConcorrente(A, B, dimensao);
			calculoConcorrente.MultiplicaMatrizes();
			int C[][] = calculoConcorrente.getC();

			long terminoConcorrente = System.currentTimeMillis() - inicioConcorrente; // T�rmino da contagem de tempo concorrente

			System.out.println("Tempo de execu��o: " + terminoConcorrente);
			
			
			// Salvando arquivo com resultado da multiplica��o.
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();
			salvarArquivo.salvarArquivo(C, dimensao, metodo);
			

			// Salvando arquivo com tempo de execu��o.
			ManipulaArquivo salvarTempo = new ManipulaArquivo();
			salvarTempo.salvarTempo(terminoConcorrente, dimensao, metodo);

		}

	}

}
