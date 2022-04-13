package simplesmente;

import dados.Item;

public class TesteIdenticas {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		ListaSimples lista2 = new ListaSimples();
				
		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(11));
		lista1.inserirUltimo(new Item(12));
		lista2.inserirUltimo(new Item(10));
		lista2.inserirUltimo(new Item(11));
		lista2.inserirUltimo(new Item(11));		
		
		if (lista1.identificarIguais(lista2)) {
			System.out.println("são iguais");
		}else {
			System.out.println("são diferentes");
		}
		
	}

}
