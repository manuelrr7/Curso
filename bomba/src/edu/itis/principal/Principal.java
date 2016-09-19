package edu.itis.principal;

import edu.itis.clases.Reloj;
import edu.itis.pantallas.Explosion;
import edu.itis.pantallas.Pantalla;

public class Principal extends Thread{


	private static Reloj reloj=new Reloj(10);
	private static Pantalla pantalla;
	private static boolean hilo, cuenta,visi=true;
	private static Explosion subpantalla;
	



	public static void main(String args[]) {
		pantalla=new Pantalla();
		pantalla.setVisible(true);
        (new Principal()).inicio();
    }


	public void inicio(){
		hilo=true;
		new Thread(this).start();
	}

	public void parada(){
		hilo=false;
	}
	
	
	public void inicioCuenta(){
		cuenta=true;
		new Thread(this).start();
	}
	
	public void paradaCuenta(){
		cuenta=false;
	}
	
	
	

    public void run() {
     
    	int contador=reloj.getNumero();
    	int x=0, y=0;
    	
    	
    	while(hilo){
    		
    		
    		pantalla.parpadeoJlabel(visi);
    		reloj.imprimirValor();
    		try {
				this.sleep(500);
				if(visi==false){
					reloj.imprimirValor();
					visi=true;
				}else{
					reloj.imprimirValor();
					visi=false;
				}
				//pantalla.parpadeoJlabel(visi);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    			    	
    	
    	while(cuenta){
    		reloj.controlSegundo(contador);
    		reloj.imprimirValor();
    		pantalla.cambiarText(reloj.getNumero());
    		contador--;
    		
    		try{
    			
    			this.sleep(1000);
    			
    			if(contador<0){
    				paradaCuenta();
    				pantalla.setVisible(false);
    				
    				for(int i=0; i<100;i++){
    					subpantalla=new Explosion();
    					subpantalla.setBounds(x, y, subpantalla.getWidth(), subpantalla.getHeight());
    					subpantalla.setVisible(true);
    					Thread.sleep(150);
    					x=(int) (Math.random()*900);
    					y=(int) (Math.random()*500);
    				}
    				this.sleep(10000);
    				pantalla.fin();
    			}
    		}catch(InterruptedException e){
    			e.printStackTrace();
    		}
    		
    		
    	}
    	
    	
    }

	


		
		
	

}
