package src;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {

	public final char[] termosQuebra = {';', ',', '(', ')', '.'};
	
	static Map<String, Integer> token = new HashMap<String, Integer>() {
	        { // criando hashmap

	            put("PROGRAM", 1); // definindo codigo 1 = Program e assim sucessivamente
	            put("LABEL", 2);
	            put("CONST", 3);
	            put("VAR", 4);
	            put("PROCEDURE", 5);
	            put("BEGIN", 6);
	            put("END", 7);
	            put("INTEGER", 8);
	            put("ARRAY", 9);
	            put("OF", 10);
	            put("CALL", 11);
	            put("GOTO", 12);
	            put("IF", 13);
	            put("THEN", 14);
	            put("ELSE", 15);
	            put("WHILE", 16);
	            put("DO", 17);
	            put("REPEAT", 18);
	            put("UNTIL", 19);
	            put("READLN", 20);
	            put("WRITELN", 21);
	            put("OR", 22);
	            put("AND", 23);
	            put("NOT", 24);
	            put("IDENTIFICADOR", 25);
	            put("INTEIRO", 26);
	            put("FOR", 27);
	            put("TO", 28);
	            put("CASE", 29);
	            put("+", 30);
	            put("-", 31);
	            put("*", 32);
	            put("/", 33);
	            put("[", 34);
	            put("]", 35);
	            put("(", 36);
	            put(")", 37);
	            put(":=", 38);
	            put(":", 39);
	            put("=", 40);
	            put(">", 41);
	            put(">=", 42);
	            put("<", 43);
	            put("<=", 44);
	            put("< >", 45);
	            put(",", 46);
	            put(";", 47);
	            put("LITERAL", 48);
	            put(".", 49);
	            put("..", 50);
	            put("$", 51);
	   }
	};
	
	public static Map<String, Integer> retornaTermos() {
		return token;
	}
}
