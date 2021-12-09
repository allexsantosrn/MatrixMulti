package core;

public class CalculoSequencial {

	//Implementa o algoritmo para cálculo sequencial.
		public int[][] MultriplicaMatrizes(int[][]A, int[][]B, int tamanho) {

			int[][] C = new int[tamanho][tamanho];

			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
					int soma = 0;
					for (int k = 0; k < tamanho; k++) {
						soma += A[i][k] * B[k][j];
					}
					C[i][j] = soma;
				}
			}
			return C;
		}
}
