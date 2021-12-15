package core;

public class CalculoConcorrente extends Thread {

	private static int[][] A;
	private static int[][] B;
	private static int[][] C;
	private static int dimensao;
	private int index;

	// Construtor
	public CalculoConcorrente(int[][] A, int[][] B, int dimensao) {
		CalculoConcorrente.A = A;
		CalculoConcorrente.B = B;
		CalculoConcorrente.C = new int[dimensao][dimensao];
		CalculoConcorrente.dimensao = dimensao;
	}

	// M�todo que retorna a matriz calculada.
	public int[][] getC() {
		return C;
	}

	public CalculoConcorrente(String nome, int index) {
		super(nome);
		this.index = index;
	}

	// M�todo para a multiplica��o de matrizes no modelo concorrente.
	public void MultiplicaMatrizes() {

		for (int index = 0; index < dimensao; index++) {
			String nome = "Thread" + index;
			Thread threadCalcular = new CalculoConcorrente(nome, index);
			threadCalcular.start();

			try {
				threadCalcular.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// M�todo run.
	public void run() {
		int resultado = 0;
		for (int linha = 0; linha < dimensao; linha++) {
			for (int coluna = 0; coluna < dimensao; coluna++) {
				resultado = CalculoConcorrente.A[linha][this.index] * CalculoConcorrente.B[this.index][coluna];
				CalculoConcorrente.C[linha][coluna] += resultado;

			}
		}
	}

}
