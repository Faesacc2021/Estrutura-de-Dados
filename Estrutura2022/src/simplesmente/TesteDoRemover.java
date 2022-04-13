package simplesmente;

import dados.Item;

public class TesteDoRemover {

	public static void main(String[] args) {
		//testar o método removerNo

		ListaSimples lista = new ListaSimples();
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(7));
		lista.inserirUltimo(new Item(50));
		
		if (lista.removerNo(77)) {
			System.out.println("removeu");
		}else {
			System.out.println("não removeu");
		}
	}

}
