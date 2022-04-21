package pilha;

import java.util.*;

import dados.*;

public class InvertePalavra {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite uma palavra:");
		String palavra = teclado.next();
		
		PilhaContigChar pilha = new PilhaContigChar(palavra.length());
		
		for (int i = 0; i < palavra.length(); i++) {
			pilha.empilhar(new ItemChar (palavra.charAt(i)));
		}
		
		palavra = "";
		
		while (!pilha.eVazia()) {
			palavra += pilha.desempilhar().getChave();
		}
		
		System.out.println("Palava invertida:\n"+ palavra);
		teclado.close();
	}
}
