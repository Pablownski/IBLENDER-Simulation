import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        Blender blender = new Blender();
        String alimento = "nada"; // Para almacenar el objeto que se llena la licuadora, por default 'nada'.
        boolean loop = true;
        while (loop){
            System.out.println("-".repeat(50));
            System.out.println("\t\tSimulación de licuadora");
            System.out.println("-".repeat(50));
            System.out.println("1. Prender la licuadora");
            System.out.println("2. Llena la licuadora con lo que se desea licuar");
            System.out.println("3. Incrementa velocidad");
            System.out.println("4. Decrementa velocidad");
            System.out.println("5. Consulta en que velocidad esta la licuadora");
            System.out.println("6. Consulta si la licuadora esta llena.");
            System.out.println("7. Vaciar la licuadora");
            System.out.println("8. Salir");
            Scanner input = new Scanner(System.in);
            // Try catch para evitar ingresos de datos no numéricos
            try {
                System.out.print("Ingrese el número correspondiente a la opción que desee que la licuadora realice: \nR/ ");
                int opcion = input.nextInt();
                input.nextLine();
                switch (opcion){
                    case 1:
                        if (!blender.IsFull()) {
                            System.out.println("La licuadora no puede encenderse porque no está llena.");
                        } else if (blender.GetSpeed() == 0) {
                            blender.SpeedUp();
                            System.out.println("La licuadora se ha encendido. Velocidad actual: " + blender.GetSpeed());
                        } else {
                            System.out.println("La licuadora ya está encendida.");
                        }
                        break;
                    case 2:
                        if (blender.IsFull()){
                            System.out.println("La licuadora ya esta llena.");
                        }else{
                            System.out.print("Ingrese con qué desea llenar la licuadora: \nR/ ");
                            alimento = input.nextLine();
                            blender.Fill();
                            System.out.println("La licuadora se ha llenado exitosamente con: " + alimento);
                        }
                        break;
                    case 3:
                        if (blender.GetSpeed() == 0) {
                            System.out.println("La licuadora está apagada. Enciéndala primero (opción 1).");
                        } else if(blender.GetSpeed() == blender.getMaxSpeed()){
                            System.out.println("La licuadora ya está corriendo a la máxima velocidad.");
                        }else {
                            blender.SpeedUp();
                            System.out.println("La velocidad de la licuadora se ha incrementado a: " + blender.GetSpeed());
                        }
                        break;
                    case 4:
                        if (blender.GetSpeed() == 0) {
                            System.out.println("La licuadora ya está apagada.");
                        } else if (blender.GetSpeed() == 0){
                            System.out.println("No se puede decrementar más la velocidad de la licuadora, pues ya está en 0.");
                        }else {
                            blender.SpeedDown();
                            System.out.println("La velocidad de la licuadora se ha decrementado a: " + blender.GetSpeed());
                        }
                        break;
                    case 5:
                        System.out.println("La licuadora actualmente está corriendo con velocidad: " + blender.GetSpeed());
                        break;
                    case 6:
                        if(blender.IsFull()){
                            System.out.println("La licuadora está llena con: " + alimento);
                        }else{
                            System.out.println("La licuadora está vacía.");
                        }
                        break;
                    case 7:
                        if(!blender.IsFull()){
                            System.out.println("La licuadora ya está vacía.");
                        }else{
                            blender.Empty();
                            System.out.println("La licuadora se ha vaciado exitosamente!");
                        }
                        break;
                    case 8:
                        loop = false;
                        System.out.println("Gracias por utilizar nuestra licuadora :D");
                        break;
                    default:
                        System.out.println("Número ingresado no corresponde a ninguna acción de la licuadora.");
                        break;
                    }
            } catch (InputMismatchException e) {
                System.out.print("Debe de ingresar un dato numérico.");
                input.nextLine();
            }
            System.out.print("\nPresione Enter para continuar...");
            input.nextLine();
        }
    }
}
