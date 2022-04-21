package pilha;

import java.util.Scanner;

public class RetirarMaiorQue10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[] pilhaInt = new int[100];
		int[] pilhaAux = new int[100];
				
		for (int i = 0; i < 100; i++) {
			pilhaInt[i] = GenerateRandom();
		}
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Valor " + i + " da Pilha == > " + pilhaInt[i]);
		}
		
		int z = 0;
		for (int i = 0; i < pilhaInt.length; i++) {
			if( pilhaInt[i] <= 10) {
				pilhaAux[i] = pilhaInt[i];
				z++;
			}
		}
		int k = 0;
		int[] pilhaFinal = new int[z];
		
		for (int i = 0; i < pilhaAux.length; i++) {
			if( pilhaAux[i] != 0) {
				pilhaFinal[k] = pilhaAux[i];
				k++;
			}
		}
		
		for (int i = 0; i < pilhaFinal.length; i++) {
			System.out.println("Valor " + i + " NOVA Pilha == > " + pilhaFinal[i]);
		}
	}
	
    static int min = 1;
    static int max = 20;
	
	public static int  GenerateRandom() {
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      return random_int;
	}
	
}
