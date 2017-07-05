public class Operation {
	/* TODO
	ARRUMAR AS SETAGENS DAS FLAGS NAS OPERACOES NECESSARIAS
	MOV
	CMP
	JUMPS
	MAPEAR O MICROCODIGO DE CADA OPERACAO
	*/
    //private String opCode;
	static String[] opCode = {"00001","00010","00011","00100","00101",
                       "00110","00111","01000","01001","01010","01011","01100","01101","01110",
                       "01111","10000","10001"};
					static    String[] line = {"MOV","ADD","SUB","MUL","DIV","INC","DEC","CMP","JMP","JE ","JNE",
                     "JG ","JL ","JGE","JLE","&","|"}; // nao tira os espacos pfvr
		//mapear pra cada operacao qual eh o microcodigo correspondente pfvr
	public static void executa(int pc){
		int posicao = find(pc);//encontra qual a funcao em string
		String[] parts = Principal.memoria[pc].substring(3).split(","); // pega a parte dos argumentos
		//System.out.print(parts[0].replaceAll("\\s+","")+" , "); 
		String arg1 = parts[0].replaceAll("\\s+",""); // pega tudo sem espacos
		String arg2 = null;
		try{arg2 = parts[1].replaceAll("\\s+","");} // nem sempre temos dois argumentos
		catch(Exception e){};
		criaPalavra(opCode[posicao]); 
		//temos que criar uma palavra pra enviar pro IR. Ela contem o op code, 
		//todas as portas que vao abrir e fechar e etc.
		//opCode[posicao] eh o opcode referente ao comando passado.
		System.out.println(Principal.memoria[pc]);
		System.out.println(opCode[posicao]);
		/*switch (posicao) {
			case 0: //mov(vale lembrar q temos 3 casos dentro do mov)
				//System.out.println("MOV");
				break;
			case 1: //add
			//	System.out.println("ADD"); // so serao usados registradores e constantes segundo o enunciado
				if(arg1.equalsIgnoreCase("AX")){ // falta arrumar a carryflag
					Principal.ax += Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx += Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx += Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx += Short.parseShort(arg2);
				}
				break;
			case 2: //sub
				//System.out.println("SUB");
				if(arg1.equalsIgnoreCase("AX")){
					Principal.ax -= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx -= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx -= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx -= Short.parseShort(arg2);
				}
				break;
			case 3:// mul
			//	System.out.println("MUL");
			if(arg1.equalsIgnoreCase("AX")){
					Principal.ax *= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx *= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx *= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx *= Short.parseShort(arg2);
				}
				break;
			case 4:// div
				//System.out.println("DIV");
				if(arg1.equalsIgnoreCase("AX")){
					Principal.ax /= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx /= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx /= Short.parseShort(arg2);
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx /= Short.parseShort(arg2);
				}
				break;
			case 5://inc
				//System.out.println("INC");
				if(arg1.equalsIgnoreCase("AX")){
					Principal.ax++;
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx++;
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx++;
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx++;
				}
				break;
			case 6://dec
				//System.out.println("DEC");
				if(arg1.equalsIgnoreCase("AX")){
					Principal.ax--;
				}
				if(arg1.equalsIgnoreCase("BX")){
					Principal.bx--;
				}
				if(arg1.equalsIgnoreCase("CX")){
					Principal.cx--;
				}
				if(arg1.equalsIgnoreCase("DX")){
					Principal.dx--;
				}
				break;
			case 7://cmp
				//System.out.println("CMP");
				break;
			case 8://jmp
				//System.out.println("JMP");
				break;
			case 9://je
				//System.out.println("JE");
				break;
			case 10://jne
				//System.out.println("JNE");
				break;
			case 11://jg
				//System.out.println("JG");
				break;
			case 12://jl
				//System.out.println("JL");
				break;
			case 13://jge
				//System.out.println("JGE");
				break;
			case 14://jle
				//System.out.println("JLE");
				break;
			case 15://&
				//System.out.println("&");
				break;
			case 16://|
				//System.out.println(" | ");
				break;
			
		}
		*/
		//imprime o microcodigo pfvr;
	}
	private static  int find(int a){ // encontra dentro do array de operacoes, qual estamos executando e retorna a posicao
		String comando = Principal.memoria[a].substring(0,3);
		for(int h = 0 ; h < line.length ; h++){
			if(comando.equals(line[h]) ) return h;
			//nao deve retornar a posicao apenas, e sim o op code para podermos trabalhar com ele.
		}
		System.out.println("äaaaaaaaaeeeeeeeeeeeeeeeeeehooooooooooooooooooooooooooooo nao achou a string"); // obviamente nao queremos chegar aqui
		return -1;
	}
	  private static void criaPalavra(String opCode) {
			// TODO Auto-generated method stub
			
		}

}