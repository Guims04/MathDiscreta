package apagar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> operations = new ArrayList();

		// ---------------------------------------------------------

		// String input = "((A ^ B) ^ (A v B))";
		// Operacoes.extractParenthesesExpressions(input);

		// -----------------------------------------------------------------
		System.out.print("Informe o número de proposições: ");
		int n = sc.nextInt();
		System.out.print("Escolha os símbolos das suas proposições: ");
		for (int i = 0; i < n; i++) {
			operations.add(sc.next().charAt(0));
		}
		Operacoes.creatPropArrays(operations, n);

		sc.nextLine();

		System.out.print("Digite aqui sua fórmula: ");
		String formula = sc.nextLine();
		formula = (formula.replaceAll("\\s", "")).toUpperCase();
		boolean isValidate = false;
		if (formula != "")
			isValidate = Operacoes.validador(formula, operations);
		if (isValidate) {
			Operacoes.prepareToOperate(formula);
		}

		// boolean[][] matriz = new boolean[numRow][n];
		// Conectivos.setTabelaVerdade(matriz);
		// -----------------------------------------------------------------
		/*
		 * sc.nextLine();
		 * 
		 * // -----------------------------------------------------------------
		 * /*
		 * Operacoes.SimbolosValidos(formula);
		 * Operacoes.ProposiçõesValidas(formula, operações);
		 * Operacoes.validador(formula, operações);
		 * 
		 * // System.out.println("");
		 * // -----------------------------------------------------------------
		 * // Formula na mão
		 * 
		 */
		Conectivos.Tabela();

		// 1), 0));
	}

}