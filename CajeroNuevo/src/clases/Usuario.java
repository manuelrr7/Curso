package clases;

public class Usuario {

	private int id;
	private int pin;
	private String nombre;
	
	
	
	public Usuario() {
		
	}
	
	public Usuario(int id, int pin, String nombre) {
		super();
		this.id = id;
		this.pin = pin;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
