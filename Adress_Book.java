/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adress_book;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author annip
 */
public class Adress_Book { 
  
    public static void main(String[] args)throws Exception  
    {
        adressBook listado= new adressBook();
        int seleccion= 0; // Salida de circulación
		while(seleccion==0){
			 System.out.println("\n*----------------------------------------------------------*");
                         System.out.println("*           REGISTRO DE CONTACTOS TELEFÓNICOS              *");
                         System.out.println("*----------------------------------------------------------*\n");
                         System.out.println("----------------------BIENVENIDO---------------------------");
                         System.out.println("Selecciona la acción que deseas realizar");
                         System.out.println("-----------------------------------------------------------");
                         System.out.println("Presiona 1 para crear un contacto");
		         System.out.println("Presiona 2 para visualizar los contactos registrados");
                         System.out.println("Presiona 3 para eliminar un contacto");
                         System.out.println("Presiona 4 para leer los contactos");
                         System.out.println("Presiona 5 para guardar los contactos");
                         System.out.println("Presiona 0 para salir del programa");
		         System.out.println("-----------------------------------------------------------");
		
                
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
			case 1:
				listado.create();
				break;
			case 2:
				listado.list();
				break;
			case 3:
				listado.delete();
				break;
			
			case 4:
				listado.open1();listado.list();
				break;
			case 5:
				listado.save1();
				break;
			
			case 0:
				seleccion=1;
				break;
			default:
				break;
			}
		}
	}

}

    

       
