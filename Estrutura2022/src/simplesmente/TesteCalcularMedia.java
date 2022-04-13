package simplesmente;

import dados.Item;

public class TesteCalcularMedia {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
				
		lista1.inserirUltimo(new Item(1));
		lista1.inserirUltimo(new Item(2));
		lista1.inserirUltimo(new Item(3));
		System.out.println("lista1:\n"+lista1.toString());
		System.out.println();
		System.out.println("a média é "+lista1.calcularMedia());
	}

}
