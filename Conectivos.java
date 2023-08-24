package apagar;

public class Conectivos extends TabelaVerdadeDois {
	public Conectivos(int numRow, int n) {
		super(numRow, n);
	}

	public static boolean[][] Negação(int coluna1) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = !tabelaVerdade[row][coluna1];
			}
		}
		return result;
	}

	public static boolean[][] NegaçãoOperação(boolean[][] result1) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			result[row][0] = !result1[row][0];
		}
		return result;
	}

	public static boolean[] Conjunção(boolean[] arr, boolean[] arr2) {
		System.out.println(numRow);
		boolean[] result = new boolean[numRow];
		for (int row = 0; row < numRow; row++) {
			result[row] = arr[row] && arr2[row];
		}
		return result;
	}

	public static boolean[][] ConjunçãoOperação(boolean[][] result1, boolean[][] result2) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = result1[row][column] && result2[row][column];
			}
		}
		return result;
	}

	public static boolean[][] ConjunçãoOperaçãoOperaçãoDois(boolean[][] res, int coluna) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = res[row][column] && tabelaVerdade[row][coluna];
			}
		}
		return result;
	}

	public static boolean[] Disjunção(boolean[] arr, boolean[] arr2) {
		boolean[] result = new boolean[numRow];
		for (int row = 0; row < numRow; row++) {
			result[row] = arr[row] || arr2[row];
		}
		return result;
	}

	public static boolean[][] DisjunçãoOperação(boolean[][] result1, boolean[][] result2) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = result1[row][column] || result2[row][column];
			}
		}
		return result;
	}

	public static boolean[][] DisjunçãoOperaçãoDois(boolean[][] res, int coluna) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = res[row][column] || tabelaVerdade[row][coluna];
			}
		}
		return result;
	}

	public static boolean[] Condicional(boolean[] arr, boolean[] arr2) {
		boolean[] result = new boolean[numRow];
		for (int row = 0; row < numRow; row++) {
			result[row] = !arr[row] || arr2[row];
		}

		return result;
	}

	public static boolean[][] CondicionalOperação(boolean[][] result1, boolean[][] result2) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = !result1[row][column] || result2[row][column];
			}
		}
		return result;
	}

	public static boolean[][] CondicionalOperaçãoDois(boolean[][] res, int coluna) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = !res[row][column] || tabelaVerdade[row][coluna];
			}
		}
		return result;
	}

	public static boolean[][] CondicionalOperaçãoTres(int coluna, boolean[][] res) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = !tabelaVerdade[row][coluna] || res[row][column];
			}
		}
		return result;
	}

	public static boolean[] BiCondicional(boolean[] arr, boolean[] arr2) {
		boolean[] result = new boolean[numRow];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row] = (arr[row] && arr2[row])
						|| (!arr[row] && !arr2[row]);
			}
		}

		return result;
	}

	public static boolean[][] BiCondicionalOperação(boolean[][] result1, boolean[][] result2) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = (result1[row][column] && result2[row][column])
						|| (!result1[row][column] && !result2[row][column]);
			}
		}
		return result;
	}

	public static boolean[][] BiCondicionalOperaçãoDois(boolean[][] res, int coluna) {
		boolean[][] result = new boolean[numRow][1];
		for (int row = 0; row < numRow; row++) {
			for (int column = 0; column < 1; column++) {
				result[row][column] = (res[row][column] && tabelaVerdade[row][coluna])
						|| (!res[row][column] && !tabelaVerdade[row][coluna]);
			}
		}
		return result;
	}

}