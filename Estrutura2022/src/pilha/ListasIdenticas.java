package pilha;

public class ListasIdenticas {
	public static void main(String[] args) {
		int[] pilhaAlpha = new int[5];
		int[] pilhaBeta = new int[5];
		boolean saoIdenticas = true;

		for (int i = 0; i < 5; i++) {
			pilhaAlpha[i] = GenerateRandom();
			pilhaBeta[i] = GenerateRandom();
		}
		int i = (pilhaAlpha.length -1 );
		
		while (i != 0){
			if (pilhaAlpha[i] != pilhaBeta[i]) {
				System.out.println("Listas não são idênticas");
				saoIdenticas = false;
				i = 0;
			}else{
				i--;
			}
		}

		for (int j = 0; j < pilhaAlpha.length; j++) {
			System.out.println("Lista Alpha ==> " + pilhaAlpha[j] + " <> "+ pilhaBeta[j] + " <== Lista Beta " );
		}
		System.out.println("São Idênticas ==>" +  saoIdenticas);
	}

	static int min = 1;
	static int max = 2;

	public static int  GenerateRandom() {
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
	}
}

