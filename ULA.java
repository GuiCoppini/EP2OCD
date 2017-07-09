import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class ULA{
	private static int[] portas = {17,18,19} ;//17 = entrada args , 18 = entrada operacao , 19 = saida
	public static boolean[] executa(String s){
		Principal.portas[(portas[0]-1)] = 1;
		Principal.portas[(portas[1]-1)] = 1;
		Principal.portas[(portas[2]-1)] = 1;
		String opcode = s.substring(0,5); //5 primeiros bits; // mov vai ser feito na ULA msm e foda-se // sapora vai de (n,x-1) maldito substring
		int aa = Principal.isRegistrador(s.substring(5,21));
		int bb = Principal.isRegistrador(s.substring(21,37));
		String a = s.substring(5,21);
		String b = s.substring(21,37);
		if(aa != -1){ // quer dizer q eh um reg
			if(aa == 0)a = Principal.axx.getAX();
			if(aa == 1)a = Principal.bxx.getBX();
			if(aa == 2)a = Principal.cxx.getCX();
			if(aa == 3)a = Principal.dxx.getDX();
			
		}
		if( bb!= -1){ // quer dizer q eh um reg
			if(bb == 0)b = Principal.axx.getAX();
			if(bb == 1)b = Principal.bxx.getBX();
			if(bb == 2)b = Principal.cxx.getCX();
			if(bb == 3)b = Principal.dxx.getDX();
		}// daqui pra baixo soh temos numeros, nada de registradores, apenas valores
		String[] resp = new String[3];
		resp[0] = "0";
		resp[1] = "0";
		resp[2] = "0";
		//if(opcode == "00001") mov(s.substring(5,20), s.substring(21,36)); // decide que bagaca de OP realizar e passar os args pra frente
		if(opcode.equalsIgnoreCase("00010"))resp = add(a, b);
		if(opcode.equalsIgnoreCase("00011"))resp = sub(a, b);
		if(opcode == "00100") resp[0] = b;
	//	if(opcode == "00101") return div(s.substring(5,20), s.substring(21,36));
		//if(opcode == "00110") inc(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "00111") return dec(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01000") return cmp(s.substring(5,20), s.substring(21,36)); // compare tem q setar um valor pros jumps, tipo CMP AX,42 
		//if(opcode == "01001") jmp(s.substring(5,20), s.substring(21,36));//                                                       JE ENDERECO
	//	if(opcode == "01010") je(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01011") jne(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01100") jg(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01101") jl(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01110") jge(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "01111") jle(s.substring(5,20), s.substring(21,36));
	//	if(opcode == "10000") return and(s.substring(5,20), s.substring(21,36)); // sei la comofaz
		//if(opcode == "10001") return or(s.substring(5,20), s.substring(21,36)); //tbm n sei
		// quer dizer q eh um reg
			String zero = "0";
			String um = "1";
			boolean[] resposta = new boolean[]{false,false,false};
			resposta[1] = resp[1].equalsIgnoreCase(um);
			resposta[2] = resp[2].equalsIgnoreCase(um);
			resposta[0] = true;//n importa essa
			if(aa == 0)Principal.axx.setAX(resp[0]);
			if(aa == 1)Principal.bxx.setBX(resp[0]);
			if(aa == 2)Principal.cxx.setCX(resp[0]);
			if(aa == 3)Principal.dxx.setDX(resp[0]);
		return(resposta);
	}//faz a div,o dec e o resto dos jumps, ja fiz os primeiros entao ja sabem a logica
	private static void jmp(String a , String b){ // se tiver uma condicao, ela vai estar em b
		PC.setPC(a);
	}
	private static String[] inc(String a , String b){
		int valor = Integer.parseInt(a,2)+1;
		a = Integer.toBinaryString(valor);
		String[] resp = new String[3];
		resp[0]=a;
		resp[1]="0";
		resp[2]="0";
		if(valor > 32767)resp[2]="1";
		return(resp);
	}
	private static String[] mul(String a , String b){
		int times = Integer.parseInt(b,2);
		boolean negativo = false;
		int valor = Integer.parseInt(a,2);
		if(times < 0) {
			times = times*-1;
			negativo = true;
		}
		else if(times == 0){
			String[] resp = new String[3];
			resp[0]="0000000000000000";
			resp[1]="0";
			resp[2]="1";
			return(resp);
		}
		else if(valor == 0){
			String[] resp = new String[3];
			resp[0]= a;
			resp[1]="0";
			resp[2]="1";
			return(resp);
			} 
		else if((times == 1)) {
			String[] resp = new String[3];
			resp[0]= a;
			resp[1]="0";
			resp[2]="0";
			return(resp);
			}
		String ret = a;
		String[] soma = new String[3];
		for(int i = 0 ; i < times ; i++){
			soma = add(ret,a);
			ret = soma[0];
		}
		if(negativo == true){
			int valor2 = (Integer.parseInt(ret,2)*(-1));
			String aux = Integer.toBinaryString(valor2);
			ret = aux.substring(15,32);
		} 
		boolean of = false;
		int aaa = Integer.parseInt(ret,2);
		if(aaa > 32767){of = true;}
		String[] respo = new String[3];
		respo[0] = ret;
		if(!of){respo[1]= "0";}
		else {respo[1] ="1";}
		respo[2]="0";
		return(respo);
	}
	private static String[] sub(String a , String b){
		int menos = Integer.parseInt(b,2) * -1;
		String c = Integer.toBinaryString(menos);
		b = c.substring(15,32); // saporra faz o complemento de dois automatico soh q fica com tamanho 32
		return (add(a,b)); //soma a+(-b)
	}
	private static String[] add(String a , String b){
		String r ="";
		int carry = 0;
		for (int i = a.length()-1; i >= 0 ; i--){
			if ((Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry) <= 1){
				r = r+(Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry);
				carry = 0;
			}
			else if ((Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry) == 2){
				r = r+0;
				//System.out.println("assasasss "+i);
				carry = 1;
			}
			else if ((Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry) == 3){
				r=r+1;
				carry = 1;
			}
		}
		String ret = new StringBuilder(r).reverse().toString();//faz de trs pra frente a soma e dps inverte pq binario eh da direita pra esquerda , daria pra fazer r = (Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry)+r mas foda-se;
		//System.out.println("sasasa "+ret);
		String of = Integer.toString(carry);
		String zf = null;
		if(ret =="0000000000000000") zf = "1";
		else zf = "0";
		String[] resp = new String[3];
		resp[0] = ret;
		resp[1] = of;
		resp[2] = zf;
		return (resp); //resultado +overflow+zeroflag a flag do sinal eh o primeiro bit(se for signed)
	}
}
//// inst = 5 bits do opcode+16bits do arg1+16bits do arg2 = 37bits
/*
 static String[] opCode = { "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010",
    "01011", "01100", "01101", "01110", "01111", "10000", "10001" };
    static String[] line = { "MOV", "ADD", "SUB", "MUL", "DIV", "INC", "DEC", "CMP", "JMP", "JE ", "JNE", "JG ", "JL ",
    "JGE", "JLE", "&", "|" }; // nao tira os espacos pfvr
	*/