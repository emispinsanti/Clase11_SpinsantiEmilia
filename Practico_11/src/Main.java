import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner= new Scanner(System.in);
		File archivo= new File("chat.txt");
		
		while(true) {
			
			System.out.println("Ingrese una opcion: \n1-Escribir un mensaje \n2-Leer mensajes anteriores \n3-Salir");
			
			int opcion= scanner.nextInt();
			scanner.nextLine();
			
			if(opcion == 1 ) {
				System.out.println("Ingrese su nombre: ");
				String nombre= scanner.nextLine();
				
				System.out.println("Ingrese el mensaje: ");
				String mensaje= scanner.nextLine();
				FileWriter escribir= new FileWriter(archivo, true);
				escribir.write(nombre + ": " + mensaje + "\n");
				escribir.close();
				
			} else if (opcion == 2 ) {
				
				if(!archivo.exists()) {
					System.out.println("No hay mensajes anteriores");
					
				} else {
					Scanner leer = new Scanner(archivo);
					
					while(leer.hasNextLine()) {
						System.out.println(leer.nextLine());		
					}
					leer.close();
				}
				
			} else if (opcion == 3 ) {
				System.exit(0);
			
			} else {
				System.out.println("Opcion invalida!");
				archivo.delete();
				break;
			}
		}
	}
}