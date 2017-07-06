import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Principal {
    static int wordSize = 36; // Tamanho da palavra
    static int regsize = 16; // reg nao precisa guardar uma word toda // na
    // memoria 5 bit pra opcode e 11 pra var //
    // enderecos 16bits // entende numeros ate 2048
    // unsigned, acho q cobre o escopo do problema
    static short ax; // short tem tamanho 16bit e ajuda nas operacoes
    static short bx;
    static short cx;
    static short dx;
    static boolean cf, zf, sf, of;
    // static HashMap<Boolean[], String> memory = new HashMap<Boolean[],
    // String>(); // pelo q eu pesquisei hashmap n serve aqui pq se perde a
    // posicao
    static String[] memoria = new String[32767]; // cobre todos os valores do
    // enderecamento //pesado
    // quase nada // vlw java
    // por n ter unsigned short
    static int pc = 0;
    /*
     * You can get a binary string from an integer like so:
     *
     * int i = 1234; String binString = Integer.toBinaryString(i); and you can
     * convert the string back to an integer this way:
     *
     * int iNew = Integer.parseInt(binString, 2);
     *
     */
    
    public static void main(String[] args) {
        // PC Settado pra primeira linha do codigo na memoria
        // "stack" do codigo cresce de cima pra baixo, stack das variaveis
        // cresce de baixo pra cima, logo primeira linha do codigo esta em
        // memoria[0] e a primeira var ta em memoria[memoria.length]
        // le_codigo_do_arquivo(); //metodo magico q n implementei, le o codigo
        // do arq e salva na memoria, adcionar operacao EXIT no fim do codigo se
        int count = 0;
        // while !exit
        Scanner scan = new Scanner(System.in);
        int a = 0;
        memoria[a] = scan.nextLine();
        a++;
        while (!Principal.memoria[count].substring(0, 3).equals("EXI")) {
            cf = false;
            zf = false;
            sf = false;
            of = false;
            pc = count; // pc guarda o endereco da instrucao na memoria
            cicloDeBusca(pc); // fazer um print hardcoded do ciclo de busca,
            // partindo de pc, pois nao podemos apenas dar
            // "++" nele.
            Operation.executa(pc); // a magica acontece aqui
            System.out.println("AX: " + ax);
            // imprime(ax);
            System.out.println("BX: " + bx);
            // imprime(bx);
            System.out.println("CX: " + cx);
            // imprime(cx);
            System.out.println("DX: " + dx);
            // imprime(dx);
            System.out.println("Cf:" + cf + " Zf:" + zf + " Sf:" + sf + " Of:" + of);
            // imprime(pc);
            System.out.println("PC: " + pc);
            System.out.println("Endereco da instrucao eh: " + count);
            System.out.println("/////////////////////////////////////////////////////////////////");
            count++;
            memoria[a] = scan.nextLine();
            a++;
        }
        System.out.println("Fim da execucao");
    }
    
    private static void cicloDeBusca(int pc2) {
        // TODO Auto-generated method stub
        
    }
    
    public static void imprime(boolean[] a) { // autoexplicativo
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] ? "1 " : "0 ");
        }
        System.out.println();
    }
    
    public static void le_codigo_do_arquivo() {
        try {
            // Lê o arquivo
            BufferedReader reader = new BufferedReader(new FileReader("codigo.txt"));
            String line;
            line = reader.readLine();
            int a = 0;
            while (line != null) {
                memoria[a] = line;
                a++;
                line = reader.readLine();
            }
            memoria[a] = "EXIT";
        } catch (Exception e) {
        }
        ;
    }
}
