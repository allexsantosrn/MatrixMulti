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
		int dimensao = Integer.parseInt(args[0]);

		// Verifica se os parâmetros de tamanho da matriz informados são diferente dos
		// tamanhos especificados.
		if ((dimensao != 4) && (dimensao != 8) && (dimensao != 16) && (dimensao != 32) && (dimensao != 64)
				&& (dimensao != 128) && (dimensao != 256) && (dimensao != 512) && (dimensao != 1024)
				&& (dimensao != 2048)) {

			System.out.println("Programa encerrado!!");
			System.out.println("Tamanho das matrizes informadas é inválido!!");
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

			long inicioSequencial = System.currentTimeMillis();  // Início da contagem de tempo concorrente

			CalculoSequencial calculoSequencial = new CalculoSequencial(A, B, dimensao); 
			calculoSequencial.MultiplicaMatrizes();
			int C[][] = calculoSequencial.getC(); 

			long terminoSequencial = System.currentTimeMillis() - inicioSequencial; // Término da contagem de tempo sequencial

			System.out.println("Tempo de execução: " + terminoSequencial); 
			
			
			// Salvando arquivo com resultado da multiplicação.
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();
			salvarArquivo.salvarArquivo(C, dimensao, metodo);
			

			// Salvando arquivo com tempo de execução.
			ManipulaArquivo salvarTempo = new ManipulaArquivo();
			salvarTempo.salvarTempo(terminoSequencial, dimensao, metodo);

		}
		
		// Caso o argumento passado seja do tipo concorrente
		if (args[1].equals("C")) {

			String metodo = "C";

			long inicioConcorrente = System.currentTimeMillis(); // Início da contagem de tempo concorrente

			CalculoConcorrente calculoConcorrente = new CalculoConcorrente(A, B, dimensao);
			calculoConcorrente.MultiplicaMatrizes();
			int C[][] = calculoConcorrente.getC();

			long terminoConcorrente = System.currentTimeMillis() - inicioConcorrente; // Término da contagem de tempo concorrente

			System.out.println("Tempo de execução: " + terminoConcorrente);
			
			
			// Salvando arquivo com resultado da multiplicação.
			ManipulaArquivo salvarArquivo = new ManipulaArquivo();
			salvarArquivo.salvarArquivo(C, dimensao, metodo);
			

			// Salvando arquivo com tempo de execução.
			ManipulaArquivo salvarTempo = new ManipulaArquivo();
			salvarTempo.salvarTempo(terminoConcorrente, dimensao, metodo);

		}

	}

}
