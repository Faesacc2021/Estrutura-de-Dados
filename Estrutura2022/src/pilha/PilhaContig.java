package pilha;

import dados.Item;

public class PilhaContig {
	private Item [] info;
	private int topo;
	public PilhaContig(int tamanho){
		this.topo = 0;
		this.info = new Item [tamanho];
	}
	public Item getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean eVazia(){
		return (this.topo == 0);
	}
	public boolean eCheia(){
		return (this.topo == this.info.length);
	}
	//inserir um novo dado no topo da pilha.
	public boolean empilhar (Item elem){
		if (this.eCheia())
			return false;
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}
	}
	//remove o dado que está no topo da pilha (somente um dado).
	public Item desempilhar(){
		if (this.eVazia())
			return null;
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}
}