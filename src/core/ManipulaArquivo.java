package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulaArquivo {

	// Lê o arquivo através do caminho informado e retorna uma matriz.
	public int[][] lerAquivo(String arquivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String[] dimMatrix = br.readLine().split(" ");

			int linhaMatriz = Integer.parseInt(dimMatrix[0]);
			int colunaMatriz = Integer.parseInt(dimMatrix[1]);

			int matriz[][] = new int[linhaMatriz][colunaMatriz];

			for (int linhaAtual = 0; linhaAtual < linhaMatriz; linhaAtual++) {

				String[] vect = br.readLine().split(" ");

				for (int colunaAtual = 0; colunaAtual < colunaMatriz; colunaAtual++) {

					matriz[linhaAtual][colunaAtual] = Integer.parseInt(vect[colunaAtual]);

				}

			}

			return matriz;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// Recebe a matriz com o resultado da multiplicação e a exporta para um arquivo
	// .txt.
	public void salvarArquivo(int C[][], int dimensao, String metodo) {

		String tamanho = String.valueOf(dimensao);
		String conteudo = new String(tamanho + " " + tamanho + "\n");
		String path = "";

		if (metodo.equals("S")) {

			path = new String("./resultados/sequencial/C" + tamanho + "x" + tamanho + ".txt");
		}

		if (metodo.equals("C")) {

			path = new String("./resultados/concorrente/C" + tamanho + "x" + tamanho + ".txt");
		}

		for (int linhaAtual = 0; linhaAtual < dimensao; linhaAtual++) {

			for (int colunaAtual = 0; colunaAtual < dimensao; colunaAtual++) {
				conteudo += String.valueOf(C[linhaAtual][colunaAtual]) + " ";
			}
			conteudo += "\n";
		}

		FileWriter writer = null;

		try {
			writer = new FileWriter(path);
			writer.write(conteudo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Cria o arquivo .txt com o tempo de execução.
	public void salvarTempo(long tempo, int dimensao, String metodo) {

		String tamanho = String.valueOf(dimensao);
		String time = String.valueOf(tempo);

		String conteudo = "";
		String path = "";

		if (metodo.equals("S")) {

			path = new String("tempos/sequencial/C" + tamanho + "x" + tamanho + ".txt");
		}

		if (metodo.equals("C")) {

			path = new String("tempos/concorrente/C" + tamanho + "x" + tamanho + ".txt");
		}

		File file = new File(path);

		// Verifica se o arquivo existe para recuperar os tempos salvos no arquivo.
		if (file.exists()) {

			String vect[] = lerTempos(path);

			for (int i = 0; i < vect.length; i++) {
				conteudo += vect[i] + " ";
			}

		}

		conteudo += time;

		FileWriter writer = null;

		try {
			writer = new FileWriter(path);
			writer.write(conteudo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Recebe o caminho do arquivo e recupera os tempos salvos no arquivo.
	public String[] lerTempos(String arquivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String[] vect = br.readLine().split(" ");

			return vect;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
