package core;

public class CalculoSequencial {

	private int[][] A;
	private int[][] B;
	private int[][] C;
	private int dimensao;

	//Construtor
	public CalculoSequencial(int[][] A, int[][] B, int dimensao) {
		this.A = A;
		this.B = B;
		this.C = new int[dimensao][dimensao];
		this.dimensao = dimensao;
	}

	//Método que retorna a matriz calculada
	public int[][] getC() {
		return C;
	}

	// Implementa o algoritmo para cálculo sequencial.
	public void MultiplicaMatrizes() {

		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				int soma = 0;
				for (int k = 0; k < dimensao; k++) {
					soma += A[i][k] * B[k][j];
				}
				C[i][j] = soma;
			}
		}

	}
}
