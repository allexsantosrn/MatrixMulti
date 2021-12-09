package core;

import java.io.BufferedReader;
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
	
	// Recebe uma matriz e seu tamanho e os exporta para um arquivo .txt.
		public void salvarArquivo(int C[][], int tamMatriz) {

			String tamanho = String.valueOf(tamMatriz);
			String conteudo = new String(tamanho + " " + tamanho + "\n");

			String path = new String("./resultados/C" + tamanho + "x" + tamanho + ".txt");

			for (int linhaAtual = 0; linhaAtual < tamMatriz; linhaAtual++) {

				for (int colunaAtual = 0; colunaAtual < tamMatriz; colunaAtual++) {
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

}
