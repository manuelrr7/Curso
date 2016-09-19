package edu.itis.clases;

public class Reloj {

	
	//atributos
	
	private int numero;
	
	
	//constructor
	
	public Reloj(int numero){
		this.numero=numero;
	}


	
	//GET&SET
	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	//metodos
	
	
	//control segundo
	public void controlSegundo(int segundo){
		if(segundo>=0 && segundo <=10){
			this.numero=segundo;
			
		}else{
			this.numero=0;
		}
	}
	
	
	//imprimir 
	
	public void imprimirValor(){
		System.out.println("este es el valor de la variable numero:"+ numero);
	}
	
	
	
	
	
	
}
