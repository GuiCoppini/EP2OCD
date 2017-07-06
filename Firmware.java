import java.util.Arrays;

import javax.swing.text.AbstractDocument.LeafElement;

public class Firmware {
    // Cuida das microInstrucoes (Criar, printar e organizar)
    private boolean[][] microInstrucoes = new boolean[400][64];
    String[] nomePorta = { "PCin", "PCout", "MARin", "MBRin", "MBRout", "AXin", "AXout", "BXin", "BXout", "CXin",
    "CXout", "IRin", "IRP2out", "IRP2in", "P1out", "P1in", "Xin", "ULAin", "ACout", "MARout", "MBRoutToMem",
    "MBRinFromMem", "MEMORIAin", "MEMORIAout", "DXin", "DXout", "ADRESS VALID", "READ", "WRITE" };
    private int linhaAtual = 0;
    
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
    
    void criaMatriz(String parametro1, String parametro2) {
        // vamos criar a matriz toda aqui.Vai ser hardcoded 1000 linhas ausuahs
        // MOV
        BUSCA();
        MOV(parametro1, parametro2);
        //ADD(parametro1, parametro2);
        //SUB(parametro1, parametro2);
        //MUL(parametro1, parametro2);
        // demais funcoes
        // JP();
    }
    
    private void MOV(String parametro1, String parametro2) {
        // TODO Auto-generated method stub
        // busca ja esta feita
        int pr1 = checaParametro(parametro1, "in") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        if (pr1 != -1) {
            if (pr2 != -1) {
                int[] t1 = { pr1, pr2 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            } else {
                int[] t1 = { pr1, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            }
        } // abri portas x , y, z ..... quantas precisar.
    }
    
    int checaParametro(String parametro, String tipo) {
        for (int i = 0; i < nomePorta.length; i++) {
            if (nomePorta[i].contains(parametro.toUpperCase()))
                if (nomePorta[i].contains(tipo)) {
                    return i;
                }
        }
        return -1;
    }
    
    private void MUL(String parametro1, String parametro2) {
        int pr1 = checaParametro(parametro1, "in") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        if (pr1 != -1) {
            if (pr2 != -1) {
                int[] t1 = { pr1, pr2 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            } else {
                int[] t1 = { pr1, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            }
        } // abri portas x , y, z ..... quantas precisar.
    }
    
    private void SUB(String parametro1, String parametro2) {
        int pr1 = checaParametro(parametro1, "in") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        if (pr1 != -1) {
            if (pr2 != -1) {
                int[] t1 = { pr1, pr2 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            } else {
                int[] t1 = { pr1, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            }
        } // abri portas x , y, z ..... quantas precisar.
    }
    
    private void ADD(String parametro1, String parametro2) {
        // Adiciona o conteudo do primeiro no segundo
        int pr1 = checaParametro(parametro1, "in") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        if (pr1 != -1) {
            if (pr2 != -1) {
                //os dois existem, e sei quais sao.
                int[] t1 = {};
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            } else {
                int[] t1 = { pr1, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
            }
        }
    }
    
    private void BUSCA() {
        int[] t1 = { 2, 3, 18 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t1, linhaAtual);
        linhaAtual++;
        int[] t2 = { 20, 23 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t2, linhaAtual);
        linhaAtual++;
        int[] t3 = { 7, 19, 24, 22 }; // abri portas x , y, z ..... quantas
        // precisar.
        abrePortas(t3, linhaAtual);
        linhaAtual++;
        int[] t4 = { 5, 12 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t4, linhaAtual);
        linhaAtual++;
    }
    
    void leMicro(boolean[] micro, int tamanho) {
        // le o vetor da micro instrucao e chama as funcoes nescessarias para
        // executar o mesmo.
        int aux = -1;
        for (int i = 0; i < tamanho; i++) {
            if (micro[i] == true){
                if(aux!= -1)
                    imprimeAcao(nomePorta[aux], nomePorta[i]); // chama funcao do cops
                aux = i;
            }
        }
        System.out.println();
    }
    
    void printaPorta(int numeroDaPorta) {
        System.out.print(nomePorta[numeroDaPorta] + " ");
    }
    
    public static void main(String[] args) {
        Firmware firm = new Firmware();
        firm.criaMatriz("AX", "BX");
        for (int i = 0; i < firm.linhaAtual; i++) {
            firm.leMicro(firm.microInstrucoes[i], 29);
        }
    }
    static void imprimeAcao(String a, String b) {
        char impresso = 0;
        if(a.contains("MEM"))
            if(a.charAt(a.length()-1) == 'n'){
                System.out.print(a);
                impresso = 'a';
            } else {
                System.out.print(b);
                impresso = 'b';
            }
        System.out.print(" <- ");
        if (impresso == 'a') System.out.print(b);
        else System.out.print(a);
    }
}
