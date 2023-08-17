package apagar;

import java.util.ArrayList;
import java.util.Stack;

public class Operações {
	
	public static final Character[] SimbolosPermitidos = {
			'~', '^', 'v', '→', '↔', '(', ')', ' '
	};
	
	public static ArrayList<Character> Caracteres() {
		ArrayList<Character> list = new ArrayList();
		for (char add : SimbolosPermitidos) {
			list.add(add);
		}
		return list;
	}
	
	public static boolean SimbolosValidos(String formula, ArrayList<Character> arraylist) {
		for (char i : formula.toCharArray()) {
			char simboloChar = i;
			boolean validador = false; 
			for (char j : arraylist) {
				if(j == simboloChar) {
					validador = true;
					break;
				}
			}
			if (!validador) {
	            return false;
	        }
		}
		return true; 
	}
	
	public static void validador(String formula, ArrayList<Character> operações) {
		if (SimbolosValidos(formula, operações)) {
			System.out.println("É válido");
		} else {
			System.out.println("Não é válido");
		}
	}
	
}
