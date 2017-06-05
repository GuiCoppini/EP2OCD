public class Operation {
    //private String opCode;
	static String[] opCode = {"00001","00101","00110","00111","01000",
                       "01001","01010","01011","01100","01101","01110","01111","10000","10001",
                       "10010","10011","10100"};
					static    String[] line = {"MOV","ADD","SUB","MUL","DIV","INC","DEC","CMP","JMP","JE ","JNE",
                     "JG ","JL ","JGE","JLE","&","|"}; // nao tira os espacos pfvr
		//mapear pra cada operacao qual eh o microcodigo correspondente pfvr
	public static void executa(int op){
		int posicao = find(op);
		switch (posicao) {
			case 0: //mov(vale lembrar q temos 3 casos dentro do mov)
			System.out.println("MOV");
			break;
			case 1: //add
			System.out.println("ADD");
			break;
			case 2: //sub
			System.out.println("SUB");
			break;
			case 3:// mul
			System.out.println("MUL");
			break;
			case 4:// div
			System.out.println("DIV");
			break;
			case 5://inc
			System.out.println("INC");
			break;
			case 6://dec
			System.out.println("DEC");
			break;
			case 7://cmp
			System.out.println("CMP");
			break;
			case 8://jmp
			System.out.println("JMP");
			break;
			case 9://je
			System.out.println("JE");
			break;
			case 10://jne
			System.out.println("JNE");
			break;
			case 11://jg
			System.out.println("JG");
			break;
			case 12://jl
			System.out.println("JL");
			break;
			case 13://jge
			System.out.println("JGE");
			break;
			case 14://jle
			System.out.println("JLE");
			break;
			case 15://&
			System.out.println("&");
			break;
			case 16://|
			System.out.println(" | ");
			break;
		}
		//imprime o microcodigo pfvr;
	}
	private static  int find(int a){ // encontra dentro do array de operacoes, qual estamos executando e retorna a posicao
		String comando = Principal.memoria[a].substring(0,3);
		for(int h = 0 ; h < line.length ; h++){
			if(comando.equals(line[h]) ) return h;
		}
		System.out.println("äaaaaaaaaeeeeeeeeeeeeeeeeeehooooooooooooooooooooooooooooo nao achou a string"); // obviamente nao queremos chegar aqui
		return -1;
	}
}