package apagar;

import java.util.ArrayList;
import java.util.Stack;

public class Operações {

	public static final Character[] SimbolosPermitidos = {
			'^', 'v', '→', '↔'
	};
	public static final Character[] Parenthesis = {
			'(', ')'
	};

	public static ArrayList<Character> Caracteres() {
		ArrayList<Character> list = new ArrayList();
		for (char add : SimbolosPermitidos) {
			list.add(add);
		}
		return list;
	}

	public static boolean SimbolosValidos(String formula) {
		Stack<Character> stack = new Stack<>();
		boolean isConective = false;
		for (char f : formula.toCharArray()) {
			if (!isSimboloPermitido(f, Parenthesis)) {
				if (f == 'V')
					f = Character.toLowerCase(f);

				System.out.println("Character: '" + f + "' is a connective? " +
						isConective);

				if (!isConective) {
					if (!Character.isLetter(f) && f != '~') {
						System.out.println("Caracter não permitido: " + f);
						return false;
					}
					if (f == '~')
						isConective = false;
					else
						isConective = true;
				} else {
					if (!isSimboloPermitido(f, SimbolosPermitidos)) {
						System.out.println("Caracter não permitido: " + f);
						return false;
					}
					isConective = false;
				}
			}

			if (f == '(') {
				stack.push(f);
			} else if (f == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}

		}

		if (!stack.isEmpty())
			System.out.println("Parentheses unclosed or wrong positioned");
		return stack.isEmpty();
	}

	private static boolean isSimboloPermitido(char c, Character[] simbols) {
		for (char permitido : simbols) {
			if (c == permitido) {
				return true;
			}
		}
		return false;
	}

	public static void validador(String formula) {
		if (SimbolosValidos(formula)) {
			System.out.println("É válido");
		} else {
			System.out.println("Não é válido");
		}
	}

}
