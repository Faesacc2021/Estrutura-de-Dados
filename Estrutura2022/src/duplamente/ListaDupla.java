package duplamente;

import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public NoDupla getPrim(){
		return this.prim;
	}
	public NoDupla getUlt(){
		return this.ult;
	}
	public void setQuantNos(int valorNovo){
		this.quantNos = valorNovo;
	}
	public void setPrim(NoDupla novoNo){
		this.prim = novoNo;
	}
	public void setUlt(NoDupla novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirUltimo (Item elem){
		NoDupla novoNo = new NoDupla (elem);
		if (this.eVazia())
			this.prim = novoNo;
		else { 
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}	
		this.ult = novoNo;
		this.quantNos++;
	}
	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public NoDupla pesquisarNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;  //se retornar null é porque não achou
	}

	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave()!= chave)){
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else 
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null) //se a lista tem somente um nó
					this.ult=null;
				else 
					this.prim.setAnt(null);
			}
			else 
				if (atual == this.ult){
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				}
				else {
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
		this.quantNos--;
		return true;
	}
	public String toString(){
		String msg="";
		NoDupla atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	//atividade 04 - questão 6 letra a
	public void concatenar(ListaDupla lista2) {
		if (!lista2.eVazia()) {
			if (this.eVazia()) {
				this.prim = lista2.prim;
				this.ult = lista2.ult;
				this.quantNos = lista2.quantNos;
			}else {
				this.ult.setProx(lista2.prim);
				lista2.prim.setAnt(this.ult);
				this.ult = lista2.ult;
				this.quantNos += lista2.quantNos;
			}
			lista2.prim = null;
			lista2.ult = null;
			lista2.quantNos = 0;
		}
	}
	//atividade 04 - questão 6 letra b
	public ListaDupla partirLista() {
		ListaDupla nova = new ListaDupla();
		NoDupla atual = this.prim;
		for (int i=1; i< this.quantNos/2;i++) {
			atual = atual.getProx();
		}
		nova.prim = atual.getProx();
		nova.ult = this.ult;
		this.ult = atual;
		this.ult.setProx(null);
		nova.prim.setAnt(null);
		nova.quantNos = this.quantNos - this.quantNos/2;
		this.quantNos = this.quantNos - nova.quantNos;
		return nova;
	}
	//atividade 04 - questão 6 letra c
	public void inserirOrdenado(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		this.quantNos++;
		if (this.eVazia()) {
			this.prim = novoNo;
			this.ult = novoNo;
		}else{
			if (elem.getChave() < this.prim.getInfo().getChave()){
				//inserir antes do primeiro nó
				novoNo.setProx(this.prim);
				this.prim.setAnt(novoNo);
				this.prim = novoNo;
			}else {
				if (elem.getChave() > this.ult.getInfo().getChave()) {
					//inserir depois do ultimo nó
					novoNo.setAnt(this.ult);
					this.ult.setProx(novoNo);
					this.ult = novoNo;
				}else {
					//inserir no meio da lista
					NoDupla atual = this.prim.getProx();
					while (atual.getInfo().getChave() < elem.getChave()) {
						atual = atual.getAnt();
					}
					novoNo.setAnt(atual.getAnt());
					novoNo.setProx(atual);
					atual.getAnt().setProx(novoNo);
					atual.setAnt(novoNo);
				}					
			}
		}
	}
}
