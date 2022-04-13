package simplesmente;

import dados.Item;

public class TestarQuestao5 {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		
		
		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(11));
		lista1.inserirUltimo(new Item(12));
		
		System.out.println("Lista1:\n "+lista1.toString());
		
		if (lista1.verificarValor(2)) {
			System.out.println("achou o valor");
					
		}else {
			System.out.println("não achou e inseriu no final");
			System.out.println("Lista1:\n "+lista1.toString());
		}
	}

}
