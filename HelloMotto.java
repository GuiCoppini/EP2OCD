
public class HelloMotto {
    public static boolean[] converteString(String numero1) {
		String conversao[] = numero1.split("");
		boolean[] binario = new boolean[conversao.length];
		for (int i = 0; i < conversao.length; i++) {
			if(numero1.charAt(i) == '1') binario[i] = true;
      else binario[i] = false;
      System.out.println(binario[i]);
		}
		return binario;
	}
}
