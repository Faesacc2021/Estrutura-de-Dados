package simplesmente;

import dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	//verificar se a lista está vazia
	public boolean eVazia (){
		return (this.prim == null);
	}
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere o primeiro nó na lista
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (int chave) {
		No atual = this.prim;
		No ant = null;
		if (eVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getChave()!= chave)){
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			}
			else{
				if (atual == this.prim){
					if (this.prim == this.ult){
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult){
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}
	//outra forma de escrever o método para remover determinado Nó
	public boolean removerNó(int x){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim.getInfo().getChave()==x){
				if (this.prim.getProx()==null){//se for único nó da lista
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
			}else{
				No atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getChave()!=x)){
					atual = atual.getProx();
				}
				if (atual.getProx()==null){//não achou o valor na lista
					return false;
				}else{
					if (atual.getProx()==this.ult){//se for o último nó
						atual.setProx(null);
						this.ult = atual;
					}else{	//remove o nó no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
				}
			}
			this.quantNos--;
			return true;

		}
	}
	//mostra todo o conteúdo da lista
	public String toString(){
		String msg="";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	public String mostrarImpar(){
		String msg="";
		No atual = this.prim;
		for (int i=1 ; i<= this.getQuantNos(); i++){
			if (atual.getInfo().getChave()%2 == 1) {
				msg += atual.getInfo().getChave()+"\n";
			}
			atual = atual.getProx();
		}
		return msg;
	}
//atividade 02 - questão 7
	public void concatenarListas(ListaSimples lista2) {
		if (this.eVazia() && !lista2.eVazia()) {
			this.prim = lista2.prim;
			this.ult = lista2.ult;
			this.quantNos = lista2.quantNos;
		}else {
			if (!lista2.eVazia()) {
				this.ult.setProx(lista2.prim);
				this.ult = lista2.ult;
				this.quantNos += lista2.quantNos;
			}
		}
		lista2.prim = null;
		lista2.ult = null;
		lista2.quantNos = 0;
	}
//atividade 02 - questão 8
	public void partirLista(ListaSimples lista2) {
		if (!this.eVazia()) {
			No atual = this.prim;
			for (int i=1; i<this.quantNos/2;i++) {
				atual = atual.getProx();
			}
			lista2.prim = atual.getProx();
			lista2.ult = this.ult;
			this.ult = atual;
			this.ult.setProx(null);
			lista2.quantNos = this.quantNos - this.quantNos/2;
			this.quantNos = this.quantNos/2;
		}
	}
	//atividade 02 - questão 9	
	public double calcularMedia() {
		double soma=0;
		No atual = this.prim;
		for (int i=1 ; i<= this.quantNos; i++){
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}
		return soma/this.quantNos;
	}
	//atividade 02 - questão 10
		public boolean identificarIguais(ListaSimples lista2) {
			if (this.quantNos != lista2.quantNos) {
				return false;
			}else {
				No atualL1 = this.prim;
				No atualL2 = lista2.prim;
				for (int i=1; i <= this.quantNos;i++) {
					if (atualL1.getInfo().getChave()!= atualL2.getInfo().getChave()) {
						return false;
					}
					atualL1 = atualL1.getProx();
					atualL2 = atualL2.getProx();
				}
				return true;
			}

		}
		//atividade 02 - questão 11
		//n1 é o número para ser procurado
		//n2 é o novo valor
		public int efetuarTrocas(int n1, int n2){
			No atual = this.prim;
			int soma = 0;
			while (atual!=null){
				if (atual.getInfo().getChave()==n1){
					atual.getInfo().setChave(n2);
					soma++;
				}
				atual = atual.getProx();
			}
			return soma;
		}
		//atividade 02 - questão 12
		public int procurarInserirNo(int valor){
			if (this.eVazia()){
				//se a lista está vazia, inserir o valor na lista
				this.inserirUltimo(new Item(valor));
				return 1;
			}else{
				No atual = this.prim;
				int cont=0;
				//procurar quantas vezes o valor foi encontrado na lista
				while (atual!= null){
					if (atual.getInfo().getChave()==valor){
						cont++;
					}
					atual = atual.getProx();
				}
				//se não encontrar, inserir no final da lista
				if (cont==0){
					this.inserirUltimo(new Item(valor));
					return 1;
				}else{
					return cont;   //total de vezes encontrado
				}
			}
		}
		//atividade 02 - questão 13
		public boolean estarContida(ListaSimples lista2) {
			if (this.eVazia() || lista2.eVazia()) {
				return false;
			}else {
				if (this.quantNos > lista2.quantNos) {
					return false;
				}else {
					No atualL1 = this.prim;
					No atualL2;
					boolean achou;
					while (atualL1 != null) {   //ou for(int i=1;i<=this.quantNos;i++){
						atualL2 = lista2.prim;
						achou = false;
						//percorre várias vezes a lista2 procurando
						//cada valor da lista1
						while (atualL2 != null && !achou) {
							if (atualL1.getInfo().getChave()==
									atualL2.getInfo().getChave()) {
								achou = true;
							}
							atualL2 = atualL2.getProx();
						}
						if (!achou) { //se não encontrou o valor
							return false;
						}
						//caminha para o próximo na lista1
						atualL1 = atualL1.getProx();
					}
					return true;
				}
			}
		}
		//prova 1 questão 5
		public boolean verificarValor(int valor) {
			if (this.eVazia()) {
				return false;
			}else {
				No atual = this.prim;
				while ((atual != null)&&(atual.getInfo().getChave()!=valor)){
					atual = atual.getProx();
				}
				if (atual == null) {
					this.inserirUltimo(new Item(valor));
					return false;
				}else {
					return true;
				}
			}
		}
		//prova 1 questão 6
		public void remover3Nos() {
			if (this.quantNos<=3) {
				this.prim = null;
				this.ult = null;
				this.quantNos = 0;
			}else {
				for (int i=1; i<=3; i++) {
					this.prim = this.prim.getProx();
					this.quantNos--;
				}
				//ou this.prim = this.prim.getProx().getProx().getProx();
				//this.quantNos -= 3; //this.quantNos = this.quantNos - 3;
			}
		}
		
	
}
