import java.util.Arrays;

public class Firmware {
    // Cuida das microInstrucoes (Criar, printar e organizar)
    private boolean[][] microInstrucoes = new boolean[400][64];
    String[] nomePorta = { "PCin", "PCout", "MARin", "MBRin", "MBRout", "AXin", "AXout", "BXin", "BXout", "CXin", "CXout",
    "IRin", "IRP2out", "IRP2in", "P1out", "P1in", "Xin", "ULAin", "ACout", "MARout", "MBRoutToMem",
    "MBRinFromMem", "MEMORIAin", "MEMORIAout", "DXin", "DXout", "ADRESS VALID", "READ", "WRITE" };
    private int linhaAtual =0;
    // aqui vai a matrizona que contem todas as micro instrucoes. @COPS favor
    // fazer uma funcao pra gente comecar a editar essa matrizona
    void abrePortas(int[] portas, int linha) {
        // vou pegar e criar linha a linha cada microInstrucao.
        // O vetor portas, eh um array que fala quais portas vou abrir.EX: 1,4.
        // coloca true
        for (int i = 0; i < portas.length; i++) {
            microInstrucoes[linha][portas[i] - 1] = true;
        }
    }
    
    void criaMatriz() {
        // vamos criar a matriz toda aqui.Vai ser hardcoded 1000 linhas ausuahs
        // MOV
        BUSCA();
        MOV();
        //ADD();
        //SUB();
        //MUL();
        //demais funcoes
        //JP();
    }
    
    private void MOV() {
        // TODO Auto-generated method stub
        //busca ja esta feita
        
    }
    
    private void MUL() {
        // TODO Auto-generated method stub
        
    }
    
    private void SUB() {
        // TODO Auto-generated method stub
        
    }
    
    private void ADD() {
        // TODO Auto-generated method stub
        
    }
    
    private void BUSCA() {
        int[] t1 = {2,3,18}; //abri portas x , y, z ..... quantas precisar.
        abrePortas(t1,linhaAtual);
        linhaAtual++;
        int[] t2 = {20,23}; //abri portas x , y, z ..... quantas precisar.
        abrePortas(t2,linhaAtual);
        linhaAtual++;
        int[] t3 = {7,19,24,22}; //abri portas x , y, z ..... quantas precisar.
        abrePortas(t3,linhaAtual);
        linhaAtual++;
        int[] t4 = {5,12}; //abri portas x , y, z ..... quantas precisar.
        abrePortas(t4,linhaAtual);
        linhaAtual++;
    }
    
    void leMicro(boolean[] micro, int tamanho) {
        // le o vetor da micro instrucao e chama as funcoes nescessarias para
        // executar o mesmo.
        int aux = 0;
        for (int i = 0; i < tamanho; i++) {
            if (micro[i] == true)
                aux = i;
        }
        System.out.println();
    }
    
    void printaPorta(int numeroDaPorta) {
        System.out.print(nomePorta[numeroDaPorta]+ " ");
    }
    
    public static void main(String[] args) {
        Firmware firm = new Firmware();
        firm.criaMatriz(); 
        firm.leMicro(firm.microInstrucoes[0], 64);
        firm.leMicro(firm.microInstrucoes[1], 64);
        firm.leMicro(firm.microInstrucoes[2], 64);
        firm.leMicro(firm.microInstrucoes[3], 64);
    }
}
