/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adress_book;
import java.io.Serializable;
/**
 *
 * @author annip
 */
public class Contacto implements Serializable{
   
	private String numero;
        private String nombre;


	public Contacto(){
            
        }
	public Contacto(String numero, String nombre){
		this.nombre= nombre;
                this.numero=numero;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	

	
	public String toString() {
		return "CONTACTO {Número" + numero + "},{Nombre" + nombre +"}";

}
}
