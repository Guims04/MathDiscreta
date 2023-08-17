package apagar;

import java.util.ArrayList;
import java.util.Stack;

public class Caracteres {
	
	/* public static boolean validateFormula(String formula) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : formula.toCharArray()) {
	            if (isConnective(ch)) {
	                if (stack.isEmpty()) {
	                    return false; // Conectivo no início da fórmula
	                }
	                char prev = stack.pop();
	                if (isConnective(prev)) {
	                    return false; // Dois conectivos consecutivos
	                }
	            }
	            stack.push(ch);
	        }

	        return true;
	    }

	    public static boolean isConnective(char c) {
	    	if (c == '~' || c == '^' || c == 'v' || c == '-' || c == '↔') {
	    		return true;
	    	}
	    	return false;
	        
	    }*/

    public static boolean verificaExpressao(String expressao) {
    	  Stack<Character> stack = new Stack<>();

	        for (char ch : expressao.toCharArray()) {
	            if (ch == '(') {
	                stack.push(ch);
	            } else if (ch == ')') {
	                if (stack.isEmpty() || stack.pop() != '(') {
	                    return false; // Parênteses desbalanceados
	                }
	            }
	        }

	        return stack.isEmpty(); 
    }

    public static void main(String[] args) {
        String expressao = "()A^";


        if (verificaExpressao(expressao) /*&& verificarExpressao2(expressao)*/) {
            System.out.println("A expressão é válida.");
        } else {
            System.out.println("A expressão não é válida.");
        }
        
       /* String formula = "AvBBv"; // Sua fórmula proposicional aqui

        boolean isValid = validateFormula(formula);
        if (isValid) {
            System.out.println("Fórmula válida.");
        } else {
            System.out.println("Fórmula inválida.");
        }*/
        
    }
}
