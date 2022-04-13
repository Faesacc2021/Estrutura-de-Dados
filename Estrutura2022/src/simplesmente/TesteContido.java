package simplesmente;

import dados.Item;

public class TesteContido {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		ListaSimples lista2 = new ListaSimples();
				
		lista1.inserirUltimo(new Item(11));
		lista1.inserirUltimo(new Item(12));
		lista2.inserirUltimo(new Item(10));
		lista2.inserirUltimo(new Item(11));
		lista2.inserirUltimo(new Item(12));		
		
		if (lista1.estarContida(lista2)) {
			System.out.println("está contida");
		}else {
			System.out.println("não está contida");
		}
	}
}
