package clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String databasename="cajero_manuel";
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String user="root";
	private static final String password="";
	private static Connection cn;
	private static Statement st;
	private static ResultSet rs;
	
	
	public void insertar(Usuario usuario){
		//establecemos la conexión con la base de datos
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url+databasename,user,password);
			st=cn.createStatement();
			int answ=st.executeUpdate("insert into usuario(id,pin,nombre)values('"+usuario.getId()+"','"+usuario.getPin()+"','"+usuario.getNombre()+"')");
			if(answ==0){
				System.out.println("No se ha grabado el dato");
			}else{
				System.out.println("Se ha grabado");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int entrar(String id){
		int pin=-11;
		//establecemos la conexión con la base de datos
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url+databasename,user,password);
			st=cn.createStatement();
			ResultSet answ=st.executeQuery("select pin from usuario where id='"+id+"'");
			answ.last();
			pin=answ.getInt("pin");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pin;
		
	}
	
	
	
	
	public void hacerMovimiento(Movimiento movimiento){
		//establecemos la conexión con la base de datos
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url+databasename,user,password);
			st=cn.createStatement();
			int answ=st.executeUpdate("insert into movimientos(id_tarjeta,concepto,cantidad,saldo)values('"
					+ ""+movimiento.getIdtarjeta()+"','"+movimiento.getConcepto()+"','"+movimiento.getCantidad()+"','"+movimiento.getSaldo()+"')");
			if(answ==0){
				System.out.println("No se ha grabado el dato");
			}else{
				System.out.println("Se ha grabado");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double consultarSaldo(int id){
		double saldo=-1;
		//establecemos la conexión con la base de datos
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url+databasename,user,password);
			st=cn.createStatement();
			ResultSet answ=st.executeQuery("select saldo from movimientos where id_tarjeta='"+id+"' order by id_movimiento desc limit 1");
			answ.last();
			saldo=answ.getInt("saldo");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}
	
	
	
	
	
	public String[][] consultarTodo(String id){
		//establecemos la conexión con la base de datos
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url+databasename,user,password);
			st=cn.createStatement();
			rs=st.executeQuery("select * from movimientos where id_tarjeta='"+id+"'");
			String [][] answ;
			rs.last();
			answ=new String [rs.getRow()][5];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				answ[i][0]=rs.getString(1);
				answ[i][1]=rs.getString(2);
				answ[i][2]=rs.getString(3);
				answ[i][3]=rs.getString(4);
				answ[i][4]=rs.getString(5);
				++i;
			}
			return answ;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
