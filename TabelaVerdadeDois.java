package apagar;

public class TabelaVerdadeDois {
	static int n; //colunas
	static int numRow; //linhas
	static boolean[][] tabelaVerdade;
	
	public TabelaVerdadeDois() {}
	
	public TabelaVerdadeDois(int numRow,int n) {
		this.n = n;
		this.numRow = numRow;
		this.tabelaVerdade = new boolean[numRow][n];
	} 
	
	public static void Tabela() {
		for (int row = 0; row < numRow; row++) { 
			
			int[] binario = Binario(row);
			int total = n - 1;
			
			for (int column = 0; column < n; column++) {
				 tabelaVerdade[row][total] = (binario[column] != 0);				
				 total--;
			}
		}
	}
	public static void imprimirTabela(boolean[][] result) {
        for (int row = numRow - 1; row >= 0; row--) {
            for (int column = 0; column < n; column++) {
                System.out.print(tabelaVerdade[row][column] + " | ");
            }
            System.out.println(" - " + result[row][0]);
        }
    }
	public static int[] Binario(int row) {
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = row % 2;
            row = row / 2;
        }
        return array;
    }

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		TabelaVerdadeDois.n = n;
	}

	public static int getNumRow() {
		return numRow;
	}

	public static void setNumRow(int numRow) {
		TabelaVerdadeDois.numRow = numRow;
	}

	public static boolean[][] getTabelaVerdade() {
		return tabelaVerdade;
	}

	public static void setTabelaVerdade(boolean[][] tabelaVerdade) {
		TabelaVerdadeDois.tabelaVerdade = tabelaVerdade;
	}
}
