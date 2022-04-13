package duplamente;

import dados.Item;

public class TestarPartirLista {

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		ListaDupla lista2;
		
		lista.inserirUltimo(new Item(20));
		lista.inserirUltimo(new Item(30));
		lista.inserirUltimo(new Item(40));
		lista.inserirUltimo(new Item(50));
		lista.inserirUltimo(new Item(60));
		System.out.println("lista1\n"+lista.toString());
		
		lista2 = lista.partirLista();
		
		System.out.println("lista1\n"+lista.toString());
		System.out.println("lista2\n"+lista2.toString());
		

	}

}
