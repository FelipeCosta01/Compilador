package src;

import java.util.Map;
import java.util.Stack;

public class Lexico {
	Stack<String> pilha = new Stack<String>();
	Map<String, Integer> termos = Biblioteca.retornaTermos();

	public boolean tipoCaracter(char c) {

		return Character.isDigit(c) || Character.isLetter(c);
	}

	public String verificaTermo(String termo) {
		int posicao;


		if (termos.containsKey(termo)) {
			posicao = termos.get(termo);
		} else {

			if (eNumero(termo)) {
				posicao = 26;
			} else
				posicao = 25;
		}

		return String.valueOf(posicao)+"#"+termo;
	}

	private boolean eNumero(String texto) {
		try {
			Integer.parseInt(texto);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public String quebra(String texto) {
		String termo = new String();
		char listaCaracteres[] = texto.toCharArray();

		for (int i = 0; i < listaCaracteres.length; i++) {
			char c = listaCaracteres[i];

			if (!String.valueOf(c).trim().equals("")) {

				if (tipoCaracter(c) && listaCaracteres.length > i + 1) {
					if (!tipoCaracter(listaCaracteres[i + 1]) && listaCaracteres[i + 1] != '_') {
						termo += c;
						pilha.push(verificaTermo(termo));
						termo = "";
					} else
						termo += c;
				} else {
					if (c == '.' && eNumero(String.valueOf(listaCaracteres[i - 1])) && listaCaracteres[i + 1] == '.') {
						pilha.push(verificaTermo(".."));
						i++;
					}

					else if (c == '_' && termo.length() > 0)
						termo += c;
					
					else if (c == ':' &&  listaCaracteres[i + 1] == '=') {
						pilha.push(verificaTermo(":="));
						i++;
					}
					else if (c == '>' &&  listaCaracteres[i + 1] == '=') {
						pilha.push(verificaTermo(">="));
						i++;
					}
					else if (c == '<' &&  listaCaracteres[i + 1] == '=') {
						pilha.push(verificaTermo("<="));
						i++;
					}
					else if (termo.length() > 0) {
						termo += c;
						pilha.push(verificaTermo(termo));
						termo = "";
					} else
						pilha.push(verificaTermo(String.valueOf(c)));
				}
			}
		}

		return "TESTE";

	}

}
