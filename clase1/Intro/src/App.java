import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        
      //FileReader fr = new FileReader("src/arquivo.txt");
        // int[] numeros = {1,2,3};
        // System.out.println(numeros[5]);
        // System.out.println("Otras instrucciones...");
        // System.out.println("Fin do programa");
        

        // int resultado = 10 / 0; // ArithmeticException: / by zero
        // System.out.println("El resultado es: " + resultado);
        // System.out.println("Otras instrucciones...");

        // String nombre = null;
        // System.out.println("El nombre es: " + nombre.length()); // NullPointerException: Cannot invoke "String.length()" because "nombre" is null

        // try {
        //     Thread.sleep(5000);
        //     System.out.println("Fin do programa");

        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

       
        // String textoLeido = "123";
        // try {
        //      int numero = Integer.parseInt(textoLeido); // NumberFormatException: For input string: "abc"
        //      System.out.println("El número es: " + numero);
        //      int resultado = 10 / numero; // ArithmeticException: / by zero
        //      int[] numeros = {1,2,3};
        //      System.out.println(numeros[5]); // ArrayIndexOutOfBoundsException: Index
        //      FileReader fr = new FileReader("src/arquivo.txt"); // FileNotFoundException: src/arquivo.txt (No such file or directory)
        // } catch ( NumberFormatException e) {
        //     // System.out.println("Error: El texto no se puede convertir a número. " + e.getMessage());
        //     int resultado = 0; // Valor predeterminado en caso de error
        //     System.out.println("El número es: " + resultado);
        // } catch (ArithmeticException e) {
        //     System.out.println("Error: No se puede dividir por cero. " + e.getMessage());
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     System.out.println("Error: Índice fuera de los límites del array. " + e.getMessage());
        // }
        // catch (Exception e) {
        //     System.out.println("Error inesperado: " + e.getMessage());
        // }


        // System.out.println("Otras instrucciones...");
       

            Cuenta cuenta = new Cuenta(100);
            try {
                cuenta.retirar(150);

            } catch (SaldoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Saldo actual: " + cuenta.getSaldo());
    }
}
