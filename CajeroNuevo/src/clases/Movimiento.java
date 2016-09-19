package clases;

public class Movimiento {

	
	private int idmovimiento;
	private int idtarjeta;
	private String concepto;
	private double cantidad;
	private double saldo;
	
	

	public Movimiento() {
		
	}
	
	public Movimiento(String concepto,
			double cantidad, double saldo) {
		super();
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.saldo = saldo;
	}
	public Movimiento(int idtarjeta, String concepto,
			double cantidad, double saldo) {
		super();
		this.idtarjeta = idtarjeta;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.saldo = saldo;
	}
	
	
	
	public Movimiento(int idmovimiento, int idtarjeta, String concepto,
			double cantidad, double saldo) {
		super();
		this.idmovimiento = idmovimiento;
		this.idtarjeta = idtarjeta;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.saldo = saldo;
	}

	public int getIdmovimiento() {
		return idmovimiento;
	}

	public void setIdmovimiento(int idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public int getIdtarjeta() {
		return idtarjeta;
	}

	public void setIdtarjeta(int idtarjeta) {
		this.idtarjeta = idtarjeta;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
	
	
	
}
