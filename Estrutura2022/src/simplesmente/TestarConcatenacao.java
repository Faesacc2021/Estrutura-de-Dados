package simplesmente;

import dados.Item;

public class TestarConcatenacao {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		ListaSimples lista2 = new ListaSimples();
		
		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(11));
		lista1.inserirUltimo(new Item(12));
		lista2.inserirUltimo(new Item(13));
		lista2.inserirUltimo(new Item(14));
		System.out.println("Lista1:\n "+lista1.toString());
		System.out.println();
		System.out.println("Lista2:\n "+lista2.toString());
				
		lista1.concatenarListas(lista2);
				
		System.out.println("Lista1:\n "+lista1.toString());
		System.out.println();
		System.out.println("Lista2:\n "+lista2.toString());
		
		
		

	}

}
