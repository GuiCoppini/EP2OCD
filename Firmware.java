import java.util.Arrays;

public class Firmware {
    //Cuida das microInstrucoes (Criar, printar e organizar)
    private boolean[][] microInstrucoes = new boolean[400][64];
    String[] nomePorta = {"PCin","PCout","MAR","MBRin","MBRout","AXin","AXout","BXin","BXout","CXin","CXout","IRin","IRP2out","IRP2in","P1out","P1in"
    ,"Xin","ULAin","ACout","MARout","MBRoutToMem","MBRinFromMem","MEMORIAin","MEMORIAout","DXin","DXout","ADRESS VALID", "READ","WRITE"};
    //aqui vai a matrizona que contem todas as micro instrucoes. @COPS favor fazer uma funcao pra gente comecar a editar essa matrizona
    void criaMicroInstrucao(int[] portas, int linha){
        //vou pegar e criar linha a linha cada microInstrucao.
        //O vetor portas, eh um array que fala quais portas vou abrir.EX: 1,4. coloca true
        for (int i = 0; i < portas.length; i++) {
            microInstrucoes[linha][portas[i] -1] = true;
        }
    }
    
    void leMicro(boolean[] micro, int tamanho){
        //le o vetor da micro instrucao e chama as funcoes nescessarias para executar o mesmo.
        for (int i = 0; i < tamanho; i++) {
            if(micro[i] == true)
                printaPorta(i);
        }
    }
    
    void printaPorta(int numeroDaPorta){
        System.out.println(nomePorta[numeroDaPorta]);
    }
}
