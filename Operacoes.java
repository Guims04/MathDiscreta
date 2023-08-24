package apagar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operacoes extends Conectivos {

	public static final Character[] SimbolosPermitidos = {
			'^', 'v', '→', '↔'
	};
	public static final Character[] Parenthesis = {
			'(', ')'
	};

	public static Map<String, boolean[]> charArrayMap = new HashMap<>();

	public Operacoes(int numRow, int n) {
		super(numRow, n);
	}

	public static void verificar() {

	}

	public static boolean ProposiçõesValidas(String formula, ArrayList<Character> arraylist) {
		for (char i : formula.toCharArray()) {
			char iUpper = Character.toUpperCase(i);
			if (Character.isLetter(i) && !arraylist.contains(iUpper) && iUpper != 'V') {
				return false;
			}
		}
		return true;
	}

	public static boolean SimbolosValidos(String formula) {
		Stack<Character> stack = new Stack<>();
		boolean isConective = false;
		for (char f : formula.toCharArray()) {
			if (!isSimboloPermitido(f, Parenthesis)) {
				if (f == 'V')
					f = Character.toLowerCase(f);

				// System.out.println("Character: '" + f + "' is a connective? " +
				// isConective);

				if (!isConective) {
					if (!Character.isLetter(f) && f != '~') {
						System.out.println("Character not allowed: " + f);
						return false;
					}
					if (f == '~')
						isConective = false;
					else
						isConective = true;
				} else {
					if (!isSimboloPermitido(f, SimbolosPermitidos)) {
						System.out.println("Character not allowed: " + f);
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

			if (formula.contains("()")) {
				return false;
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

	public static boolean validador(String formula, ArrayList<Character> arraylist) {
		if (SimbolosValidos(formula) && ProposiçõesValidas(formula, arraylist)) {
			System.out.println("É válido");
			return true;
		} else {
			System.out.println("Não é válido");
			return false;
		}
	}

	public static void creatPropArrays(ArrayList<Character> propositons, int n) {
		for (int i = n - 1; i >= 0; i--) {
			int numRows = (int) Math.pow(2, n);
			Conectivos.setNumRow(numRows);

			boolean[] arr = new boolean[numRows];

			int res = (n - i - 1) * 2;
			if (res == 0)
				res = 1;
			boolean aux = false;

			for (int j = 0; j < arr.length; j++) {
				if (j % res == 0)
					aux = !aux;
				arr[j] = aux;
			}
			charArrayMap.put(propositons.get(i) + "", arr);
		}
	}

	public static void prepareToOperate(String formula) {
		String aux = "";
		boolean isConective = false;

		boolean isConjuntion = false;
		boolean isDisjunction = false;
		boolean isIfThen = false;
		boolean isIfandOnlyIf = false;

		for (char f : formula.toCharArray()) {

			if (isConjuntion) {
				boolean[] result = Conectivos.Conjunção(charArrayMap.get(aux), charArrayMap.get(f + ""));
				String index = aux + "^" + f;
				charArrayMap.put(index, result);
				isConjuntion = false;
			}

			if (f == ')')
				isConective = false;
			if (isConective) {
				switch (f) {
					case '^':
						isConjuntion = true;
						break;
					case 'v':
						isDisjunction = true;
						break;
					case '→':
						isIfThen = true;
						break;
					case '↔':
						isIfandOnlyIf = true;
						break;

				}
				isConective = false;
			}
			if (f == ')')
				isConective = true;

			if (Character.isLetter(f)) {
				aux = f + "";
				isConective = true;
			}

		}

		charArrayMap.forEach((key, value) -> {
			System.out.print(key + " | ");
		});
		System.out.println();
		int arrayLength = charArrayMap.values().iterator().next().length;
		for (int i = 0; i < arrayLength; i++) {
			StringBuilder row = new StringBuilder();
			for (boolean[] array : charArrayMap.values()) {
				row.append(array[i] ? 'T' : 'F').append(" | ");
			}
			System.out.println(row.toString().replaceAll(" \\| $", ""));
		}
	}

	public static void extractParenthesesExpressions(String input) {
		Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			String expression = matcher.group(1);
			System.out.println(expression);
		}
	}

}