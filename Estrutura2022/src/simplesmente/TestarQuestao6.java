package simplesmente;

import dados.Item;

public class TestarQuestao6 {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		
		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(11));
		lista1.inserirUltimo(new Item(12));
		lista1.inserirUltimo(new Item(13));
		lista1.inserirUltimo(new Item(14));
		System.out.println("Lista1:\n "+lista1.toString());
		lista1.remover3Nos();
		System.out.println("Lista1:\n "+lista1.toString());
		

	}

}
