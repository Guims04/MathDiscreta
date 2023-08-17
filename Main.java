package apagar;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> operações = new ArrayList();
		//-----------------------------------------------------------------
		System.out.print("Informe o número de proposições: ");
		int n = sc.nextInt();
		Conectivos.setN(n);
		int numRow = (int) Math.pow(2, n);
		Conectivos.setNumRow(numRow);
		boolean[][] matriz = new boolean[numRow][n];
		Conectivos.setTabelaVerdade(matriz);
		//-----------------------------------------------------------------
		System.out.print("Escolha os símbolos das suas proposições: ");
		for (int i = 0; i < n; i++) {
			operações.add(sc.next().charAt(0));
		}
		operações.addAll(Operações.Caracteres());
		
		sc.nextLine();
		//-----------------------------------------------------------------
		System.out.print("Digite aqui sua fórmula: ");
		String formula = sc.nextLine();
		Operações.SimbolosValidos(formula, operações);
		Operações.validador(formula, operações);
		
		System.out.println("");
	
		//-----------------------------------------------------------------
		//Formula na mão
		Conectivos.Tabela(); 
		Conectivos.imprimirTabela(Conectivos.CondicionalOperaçãoDois(Conectivos.Conjunção(0, 1), 0));
	}
}
