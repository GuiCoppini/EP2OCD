
public class Firmware {
    // Cuida das microInstrucoes (Criar, printar e organizar)
    private boolean[][] microInstrucoes = new boolean[100][64];
    String[] nomePorta = { "PCin", "PCout", "MARin", "MBRin", "MBRout", "AXin", "AXout", "BXin", "BXout", "CXin",
    "CXout", "IRin", "IRP2out", "IRP2in", "P1out", "P1in", "Xin", "ULAin", "ACout", "MARout", "MBRoutToMEM",
    "MBRinFromMEM", "MEMORIAin", "MEMORIAout", "DXin", "DXout", "ADRESS VALID", "READ", "WRITE",
    "OPERACAOout" };
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
        BUSCA();
        MOV(parametro1, parametro2);
        ADD(parametro1, parametro2);
        SUB(parametro1, parametro2);
        // MUL(parametro1, parametro2);
        // demais funcoes
        // JP();
    }
    
    private void MOV(String parametro1, String parametro2) {
        // TODO Auto-generated method stub
        inicioDasMicro[1] = linhaAtual;
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
        fimDasMicro[1] = linhaAtual; // 1 pois eh o opcode dela
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
        // FAZER ESSE.
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
        // Adiciona o conteudo do primeiro no segundo
        inicioDasMicro[3] = linhaAtual;
        int pr1 = checaParametro(parametro1, "out") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        if (pr1 != -1) {
            if (pr2 != -1) {
                // os dois existem, e sei quais sao.
                int[] t1 = { 17, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
                int[] t2 = { 18, pr2 };
                abrePortas(t2, linhaAtual);
                linhaAtual++;
                pr1 = checaParametro(parametro1, "in") + 1;
                int[] t3 = { 19, pr1 };
                abrePortas(t3, linhaAtual);
                linhaAtual++;
            }
        }
        fimDasMicro[3] = linhaAtual;
        
    }
    
    private void ADD(String parametro1, String parametro2) {
        // Adiciona o conteudo do primeiro no segundo
        inicioDasMicro[2] = linhaAtual;
        int pr1 = checaParametro(parametro1, "out") + 1;
        int pr2 = -1;
        try {
            pr2 = checaParametro(parametro2, "out") + 1;
        } catch (Exception e) {
        }
        // if(parametro2.charAt(0))
        if (pr1 != -1) {
            if (pr2 != -1) {
                // os dois existem, e sei quais sao.
                int[] t1 = { 17, pr1 };
                abrePortas(t1, linhaAtual);
                linhaAtual++;
                int[] t2 = { 18, pr2, 30 };
                abrePortas(t2, linhaAtual);
                linhaAtual++;
                pr1 = checaParametro(parametro1, "in") + 1;
                int[] t3 = { 19, pr1 };
                abrePortas(t3, linhaAtual);
                linhaAtual++;
            }
        }
        fimDasMicro[2] = linhaAtual;
    }
    
    private void BUSCA() {
        // sempre a primeira coisa
        inicioDasMicro[0] = linhaAtual;
        int[] t1 = { 2, 3, 18 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t1, linhaAtual);
        linhaAtual++;
        int[] t2 = { 20, 23 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t2, linhaAtual);
        linhaAtual++;
        int[] t3 = { 1, 19, 24, 22 }; // abri portas x , y, z ..... quantas
        // precisar.
        abrePortas(t3, linhaAtual);
        linhaAtual++;
        int[] t4 = { 5, 12 }; // abri portas x , y, z ..... quantas precisar.
        abrePortas(t4, linhaAtual);
        linhaAtual++;
        fimDasMicro[0] = linhaAtual;
    }
    
    void leMicro(boolean[] micro, int tamanho) {
        // le o vetor da micro instrucao e chama as funcoes nescessarias para
        // executar o mesmo.
        for (int i = 0; i < tamanho; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (i != j)
                    if (micro[i] == true && micro[j] == true)
                        imprimeAcao(nomePorta[i], nomePorta[j]);
            }
        }
    }
    
    void printaPorta(int numeroDaPorta) {
        System.out.print(nomePorta[numeroDaPorta] + " ");
    }
    
    static int[] fimDasMicro = new int[100];
    static int[] inicioDasMicro = new int[100];
    
    static int linhaOpCode(String opCode) {
        // retorna a linha da matriz que comeca essa instrucao
        int foo = (int) Integer.parseInt(opCode, 2);
        return inicioDasMicro[foo];
    }
    
    static int fimLinhaOpCode(String opCode) {
        int foo = (int) Integer.parseInt(opCode, 2);
        return fimDasMicro[foo];
    }
    
    public static void principal(String arg1, String arg2, String opCode) {
        Firmware firm = new Firmware();
        firm.criaMatriz(arg1, arg2);
        for (int i = 0; i < fimLinhaOpCode(opCode); i++) {
            firm.leMicro(firm.microInstrucoes[i], 29);
        }
        for (int j = linhaOpCode(opCode); j < fimLinhaOpCode(opCode); j++)
            firm.leMicro(firm.microInstrucoes[j], 29);
    }
    
    public static void main(String[] args) {
        Firmware firm = new Firmware();
        firm.criaMatriz("AX", "BX");
        for (int i = 0; i < fimLinhaOpCode("00000"); i++) {
            firm.leMicro(firm.microInstrucoes[i], 29);
        }
        for (int j = linhaOpCode("0010"); j < fimLinhaOpCode("0010"); j++)
            firm.leMicro(firm.microInstrucoes[j], 29);
    }
    
    static void imprimeAcao(String a, String b) {
        char impresso = 0;
        if (a.contains("out") && b.contains("out"))
            return;
        if ((a.contains("MEM") && b.contains("MEM")) && (a.contains("in") || b.contains("in"))) {
            return;
        }
        if (a.contains("in")) {
            System.out.print(a);
            impresso = 'a';
        } else {
            System.out.print(b);
            impresso = 'b';
        }
        System.out.print(" <- ");
        if (impresso == 'a')
            System.out.print(b + "\n");
        else
            System.out.print(a + "\n");
    }
}
