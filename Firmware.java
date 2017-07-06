import java.util.Arrays;

public class Firmware {
    // Cuida das microInstrucoes (Criar, printar e organizar)
    private boolean[][] microInstrucoes = new boolean[400][64];
    String[] nomePorta = { "PCin", "PCout", "MARin", "MBRin", "MBRout", "AXin", "AXout", "BXin", "BXout", "CXin", "CXout",
    "IRin", "IRP2out", "IRP2in", "P1out", "P1in", "Xin", "ULAin", "ACout", "MARout", "MBRoutToMem",
    "MBRinFromMem", "MEMORIAin", "MEMORIAout", "DXin", "DXout", "ADRESS VALID", "READ", "WRITE" };
    
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
        // Micro Instrucao 1
        int[] teste = { 2, 3 };
        abrePortas(teste, 1);
    }
    
    void leMicro(boolean[] micro, int tamanho) {
        // le o vetor da micro instrucao e chama as funcoes nescessarias para
        // executar o mesmo.
        for (int i = 0; i < tamanho; i++) {
            if (micro[i] == true)
                printaPorta(i);
        }
        System.out.println();
    }
    
    void printaPorta(int numeroDaPorta) {
        System.out.print(nomePorta[numeroDaPorta]+ " ");
    }
    
    public static void main(String[] args) {
        Firmware firm = new Firmware();
        firm.criaMatriz(); 
        firm.leMicro(firm.microInstrucoes[1], 64);
    }
}
