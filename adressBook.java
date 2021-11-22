/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adress_book;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author annip
 */
public class adressBook {
    
    final static String filePath
        = "C:\\adress_book\\lista_contactos.txt";
    private  Scanner sc;
    Map<String,String> registro = new HashMap<>();
    
    public void create(){
		sc = new Scanner(System.in);
		System.out.println("------------------------CREAR CONTACTO---------------------");
		System.out.println ("Ingresa el número del cliente");
		String numero=sc.nextLine();
		System.out.println ("Ingresa el nombre del cliente");
		String nombre=sc.nextLine();
               
                if(!registro.containsKey(numero)){
                    Contacto newOne = new Contacto (numero, nombre);
                    registro.put(numero,nombre);
		System.out.println ("El contacto se ha añadido correctamente");
                System.out.println("-----------------------------------------------------------");
                
                }
             
                else{
                    System.out.println("El contacto ya existe");
                System.out.println("-----------------------------------------------------------");
                }
	}

    public void delete(){
		sc = new Scanner(System.in);
		System.out.println("--------------------ELIMINAR CONTACTO-----------------------");
		System.out.println ("Ingrese el numero que se eliminará:");
		String numero=sc.nextLine();
		if (registro.containsKey (numero)) {
			System.out.println(registro.get(numero).toString());
			System.out.println ("¿Esta seguro de eliminar el teléfono? Presione 1 para confirmar");
			int decision=sc.nextInt();
			if(decision==1){
				registro.remove(numero);
		System.out.println ("El número fue eliminado con éxito");
                System.out.println("-----------------------------------------------------------");
			}else{
		System.out.println ("No se ha cancelado el número");
                System.out.println("-----------------------------------------------------------");
			}
		}else{
		System.out.println ("El número no existe");
                System.out.println("-----------------------------------------------------------");
		}

	}
    
    public void list(){
		System.out.println("----------------VISUALIZAR CONTACTOS-----------------------");
                if (registro.entrySet().isEmpty()){
                    System.out.println("No existen contactos en el registro");
                System.out.println("-----------------------------------------------------------");
                }
                else{
                    for(Map.Entry<String,String> i: registro.entrySet()){
                System.out.println ("CONTACTO {Nombre " + i.getValue() + " },{Numero " +i.getKey()+" }");
                System.out.println("-----------------------------------------------------------");
                    }
                    
                }
		
		}
    public void load() throws IOException{
		System.out.println ("Leer ...");
		DataInputStream in=new DataInputStream(new FileInputStream("C:\\adress_book\\lista_contactos.txt"));
		boolean validar=true;
		while(validar){
			try{
				String numero=in.readUTF();
				String nombre=in.readUTF();
				
			 Contacto newOne = new Contacto (numero, nombre);
				registro.put (numero, nombre); 
			}catch(EOFException e){
				validar=false;
			}
		}
		in.close();
	}
    public void save() throws IOException{
		System.out.println ("Guardar ...");
		DataOutputStream out=new DataOutputStream(new FileOutputStream("C:\\adress_book\\lista_contactos.txt"));
		Iterator i = registro.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry entry = (Map.Entry) i.next();
			Contacto val = (Contacto) entry.getValue();
			out.writeUTF(val.getNumero());
			out.writeUTF(val.getNombre());
			
		}
		out.close();
		System.out.println ("Guardar correctamente");
	}
   public void open1() throws Exception{
		System.out.println ("Leer ...");
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\adress_book\\lista_contactos.txt"));
		boolean validar=true;
		while(validar){
			try{
				Contacto newOne=(Contacto) in.readObject();
				registro.put (newOne.getNumero (), newOne.getNombre()); 
			}catch(EOFException e){
				validar=false;
			}
		}
		in.close();
	}
   public void save1() throws Exception{
		System.out.println ("Guardar ...");
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("C:\\adress_book\\lista_contactos.txt"));
		Iterator iter = registro.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Contacto val = (Contacto) entry.getValue();
			out.writeObject(val);
		}
		out.close();
		System.out.println ("Guardar correctamente");
	}

	}




