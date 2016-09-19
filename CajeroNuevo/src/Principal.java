import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.CardLayout;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.Movimiento;
import clases.Usuario;
import clases.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldImporte;
	private JPanel centro;
	private JPanel panelLogin;
	private JPanel panelMenu;
	private JPanel panelFin;
	private JPanel lateral;
	private JPanel cabecera;
	private JPanel panelConsulta;
	private CardLayout card;
	private JTextField textField_id;
	private static int intento;
	private static double importe;
	private String cadena;
	private int idTranfe;
	private static double saldo;
	private static Conexion conexion;
	private static Usuario usuario;
	private static Movimiento movimiento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		conexion= new Conexion();
		//usuario= new Usuario(2,1234, "carlos");
		//conexion.insertar(usuario);
		intento= 3;
		//movimiento = new Movimiento();
		//conexion.hacerMovimiento(movimiento);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//codifo nimbus para retocar la apariencia de ventanas u bordes
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
						
					}
					
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cabecera = new JPanel();
		cabecera.setBounds(5, 5, 574, 85);
		cabecera.setMinimumSize(new Dimension(342, 60));
		cabecera.setOpaque(false);
		contentPane.add(cabecera);
		cabecera.setLayout(null);
		
		JLabel logo_cabecera = new JLabel("");
		logo_cabecera.setBounds(0, 5, 128, 74);
		logo_cabecera.setIcon(new ImageIcon(Principal.class.getResource("/img/logoBBVAx128.png")));
		cabecera.add(logo_cabecera);
		
		JLabel cabecera_servired = new JLabel("");
		cabecera_servired.setBounds(446, 5, 128, 75);
		cabecera_servired.setIcon(new ImageIcon(Principal.class.getResource("/img/logo_servired.png")));
		cabecera.add(cabecera_servired);
		
		lateral = new JPanel();
		lateral.setOpaque(false);
		lateral.setBounds(449, 90, 130, 367);
		contentPane.add(lateral);
		
		lateral.setVisible(false);
		
		JPanel panelSacar = new JPanel();
		panelSacar.setBackground(SystemColor.textHighlight);
		
		JPanel panel_Retirar = new JPanel();
		panel_Retirar.setBackground(SystemColor.textHighlight);
		
		JLabel label = new JLabel("Operaciones Rapidas");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTransferir = new JPanel();
		panelTransferir.setBackground(SystemColor.textHighlight);
		
		JLabel label_1 = new JLabel("Operaciones Rapidas");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) centro.getLayout();
				card.show(centro,"fin");
				lateral.setVisible(false);
			}
		});
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.WHITE);
		GroupLayout gl_lateral = new GroupLayout(lateral);
		gl_lateral.setHorizontalGroup(
			gl_lateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lateral.createSequentialGroup()
					.addGroup(gl_lateral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lateral.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panelSacar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_Retirar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130, Short.MAX_VALUE))
						.addComponent(panelTransferir, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_lateral.setVerticalGroup(
			gl_lateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lateral.createSequentialGroup()
					.addComponent(panelSacar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_Retirar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelTransferir, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
		);
		
		JButton btnTransferir = new JButton("Transferir \u20AC");
		btnTransferir.setForeground(Color.WHITE);
		btnTransferir.setBackground(Color.BLUE);
		GroupLayout gl_panelTransferir = new GroupLayout(panelTransferir);
		gl_panelTransferir.setHorizontalGroup(
			gl_panelTransferir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTransferir.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panelTransferir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTransferir.createSequentialGroup()
							.addGap(10)
							.addComponent(btnTransferir))
						.addComponent(label_1))
					.addGap(10))
		);
		gl_panelTransferir.setVerticalGroup(
			gl_panelTransferir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTransferir.createSequentialGroup()
					.addGap(5)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTransferir, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelTransferir.setLayout(gl_panelTransferir);
		
		JButton btnRetirar = new JButton("Retirar \u20AC");
		btnRetirar.setBackground(Color.BLUE);
		btnRetirar.setForeground(Color.WHITE);
		GroupLayout gl_panel_Retirar = new GroupLayout(panel_Retirar);
		gl_panel_Retirar.setHorizontalGroup(
			gl_panel_Retirar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Retirar.createSequentialGroup()
					.addContainerGap(9, Short.MAX_VALUE)
					.addGroup(gl_panel_Retirar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Retirar.createSequentialGroup()
							.addGap(10)
							.addComponent(btnRetirar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_Retirar.createSequentialGroup()
							.addComponent(label)
							.addGap(10))))
		);
		gl_panel_Retirar.setVerticalGroup(
			gl_panel_Retirar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Retirar.createSequentialGroup()
					.addGap(5)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRetirar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_Retirar.setLayout(gl_panel_Retirar);
		
		JLabel lblNewLabel = new JLabel("Operaciones Rapidas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		
		JButton btnSacar = new JButton("Sacar \u20AC");
		btnSacar.setForeground(Color.WHITE);
		btnSacar.setBackground(Color.BLUE);
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		GroupLayout gl_panelSacar = new GroupLayout(panelSacar);
		gl_panelSacar.setHorizontalGroup(
			gl_panelSacar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSacar.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panelSacar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSacar.createSequentialGroup()
							.addGap(10)
							.addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panelSacar.setVerticalGroup(
			gl_panelSacar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSacar.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSacar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelSacar.setLayout(gl_panelSacar);
		lateral.setLayout(gl_lateral);
		
		centro = new JPanel();
		centro.setOpaque(false);
		centro.setBounds(5, 90, 431, 367);
		contentPane.add(centro);
		centro.setLayout(new CardLayout(0, 0));
		
		JPanel panelTarjeta = new JPanel();
		panelTarjeta.setOpaque(false);
		centro.add(panelTarjeta, "inicio");
		panelTarjeta.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a su cajero autom\u00E1tico BBVA.");
		lblBienvenido.setBounds(105, 0, 326, 22);
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTarjeta.add(lblBienvenido);
		
		JLabel lblporfavor = new JLabel("Por favor, ingrese su tarjeta. ");
		lblporfavor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblporfavor.setBounds(176, 33, 184, 14);
		panelTarjeta.add(lblporfavor);
		
		JButton btnintarjeta = new JButton("");
		btnintarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) centro.getLayout();
				card.show(centro, "login");
				lateral.setVisible(true);
			}
		});
		btnintarjeta.setIcon(new ImageIcon(Principal.class.getResource("/img/tarjeta_sale.png")));
		btnintarjeta.setBackground(SystemColor.textHighlight);
		btnintarjeta.setBounds(121, 72, 300, 168);
		panelTarjeta.add(btnintarjeta);
		
		textField_id = new JTextField();
		textField_id.setBounds(236, 251, 86, 20);
		panelTarjeta.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblIdTarjeta = new JLabel("Id Tarjeta");
		lblIdTarjeta.setBounds(174, 250, 52, 22);
		panelTarjeta.add(lblIdTarjeta);
		
		//ocultamos los botones lateral
		
		btnSacar.setEnabled(false);
		btnRetirar.setEnabled(false);
		btnTransferir.setEnabled(false);
		
		panelLogin = new JPanel();
		panelLogin.setOpaque(false);
		centro.add(panelLogin, "login");
		panelLogin.setLayout(null);
		
		JLabel label_2 = new JLabel("Bienvenido a su cajero autom\u00E1tico BBVA.");
		label_2.setBounds(105, 0, 326, 22);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelLogin.add(label_2);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor, ingrese su c\u00F3digo pin. ");
		lblPorFavorIngrese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorFavorIngrese.setBounds(156, 33, 201, 22);
		panelLogin.add(lblPorFavorIngrese);
		
		JPanel panelpin = new JPanel();
		panelpin.setBackground(SystemColor.textHighlight);
		panelpin.setBounds(190, 59, 146, 51);
		panelLogin.add(panelpin);
		panelpin.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 11, 126, 20);
		panelpin.add(passwordField);
		
	
		
		JButton btnaceptar = new JButton("Aceptar");
		btnaceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				--intento;
				if (intento>0) {
					
				int pin =(int) conexion.entrar(textField_id.getText());
				String pas ="";
				
				for(Object a:passwordField.getPassword()){
					pas += a.toString();
					
				}
				if (pas.equals(pin+"")) {
					intento = 3;
					CardLayout card = (CardLayout) centro.getLayout();
					card.show(centro,"menu");
					btnSacar.setEnabled(true);
					btnRetirar.setEnabled(true);
					btnTransferir.setEnabled(true);

					
				}else{
					
					JOptionPane.showMessageDialog(panelpin, "Login incorrecto, le quedan "+intento+" intentos.", "Error de logueo", JOptionPane.ERROR_MESSAGE);
					
				}
				
				} else {
					JOptionPane.showMessageDialog(panelpin, "No hay más intentos, tarjeta anulada.", "Superado intentos de login", JOptionPane.INFORMATION_MESSAGE);
					
					CardLayout card = (CardLayout) centro.getLayout();
					card.show(centro,"fin");
					lateral.setVisible(false);
					intento=3;
				}
				
			}
		});
		btnaceptar.setBackground(Color.GREEN);
		btnaceptar.setIcon(new ImageIcon(Principal.class.getResource("/img/icono_vistox16.png")));
		btnaceptar.setBounds(285, 280, 146, 87);
		panelLogin.add(btnaceptar);
		
		panelFin = new JPanel();
		panelFin.setOpaque(false);
		centro.add(panelFin, "fin");
		panelFin.setLayout(null);
		
		JLabel lblBienvenidoASu = new JLabel("Gracias por usar nuestros cajeros");
		lblBienvenidoASu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenidoASu.setBounds(126, 0, 280, 22);
		panelFin.add(lblBienvenidoASu);
		
		JLabel lblPorFavorRecupere = new JLabel("Por favor, recupere su tarjeta ");
		lblPorFavorRecupere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorFavorRecupere.setBounds(173, 29, 189, 17);
		panelFin.add(lblPorFavorRecupere);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_id.setText("");
				textFieldImporte.setText("");
				passwordField.setText("");
				CardLayout card = (CardLayout) centro.getLayout();
				card.show(centro, "inicio");
			}
		});
		button.setIcon(new ImageIcon(Principal.class.getResource("/img/tarjeta_entra.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(121, 62, 300, 168);
		panelFin.add(button);
		
		panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		centro.add(panelMenu, "menu");
		panelMenu.setLayout(null);
		
		JPanel panelCajaCantidad = new JPanel();
		panelCajaCantidad.setBackground(new Color(135, 206, 235));
		panelCajaCantidad.setBounds(10, 81, 282, 51);
		panelMenu.add(panelCajaCantidad);
		panelCajaCantidad.setLayout(null);
		
		JLabel lblTecleeElImporte = new JLabel("Teclee el importe a realizar");
		lblTecleeElImporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTecleeElImporte.setBounds(10, 11, 158, 25);
		panelCajaCantidad.add(lblTecleeElImporte);
		
		textFieldImporte = new JTextField();
		textFieldImporte.setBounds(174, 14, 86, 20);
		panelCajaCantidad.add(textFieldImporte);
		textFieldImporte.setColumns(10);
		
		
		
		JLabel lbl€ = new JLabel("\u20AC");
		lbl€.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl€.setBounds(267, 17, 13, 14);
		panelCajaCantidad.add(lbl€);
		
		JButton btnretirarcentro = new JButton("Retirada de dinero");
		btnretirarcentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				importe = Double.parseDouble(textFieldImporte.getText());
				insertarMovimiento(importe, "Retirar");
			}
		});
		btnretirarcentro.setForeground(Color.WHITE);
		btnretirarcentro.setBackground(Color.BLUE);
		btnretirarcentro.setBounds(297, 81, 134, 51);
		panelMenu.add(btnretirarcentro);
		
		JButton btnTransferencias = new JButton("Transferencias");
		btnTransferencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadena=JOptionPane.showInputDialog("Indique el Id del usuario al que se le ingresara:");
				idTranfe=Integer.parseInt(cadena);
				importe = Double.parseDouble(textFieldImporte.getText());
				insertarMovimiento(importe, "Retirar");
				insertarMovimiento(importe, "Tranferir");
				
			}
		});
		btnTransferencias.setForeground(Color.WHITE);
		btnTransferencias.setBackground(Color.BLUE);
		btnTransferencias.setBounds(10, 143, 124, 39);
		panelMenu.add(btnTransferencias);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout card = (CardLayout) centro.getLayout();
				cargarTabla();
				card.show(centro,"consulta");
			}
		});
		btnConsultas.setForeground(Color.WHITE);
		btnConsultas.setBackground(Color.BLUE);
		btnConsultas.setBounds(154, 143, 124, 39);
		panelMenu.add(btnConsultas);
		
		JButton btnIngresoDeDinero = new JButton("Ingreso de dinero");
		btnIngresoDeDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				importe = Double.parseDouble(textFieldImporte.getText());
				insertarMovimiento(importe, "Ingresar");
			}
		});
		btnIngresoDeDinero.setForeground(Color.WHITE);
		btnIngresoDeDinero.setBackground(Color.BLUE);
		btnIngresoDeDinero.setBounds(297, 143, 134, 39);
		panelMenu.add(btnIngresoDeDinero);
		
		JButton btnRecibostributos = new JButton("Recibos-Tributos");
		btnRecibostributos.setForeground(Color.WHITE);
		btnRecibostributos.setBackground(Color.BLUE);
		btnRecibostributos.setBounds(10, 193, 124, 39);
		panelMenu.add(btnRecibostributos);
		
		JButton btnRecargas = new JButton("Recargas");
		btnRecargas.setForeground(Color.WHITE);
		btnRecargas.setBackground(Color.BLUE);
		btnRecargas.setBounds(154, 193, 124, 39);
		panelMenu.add(btnRecargas);
		
		JButton btnMsOperaciones = new JButton("M\u00E1s operaciones");
		btnMsOperaciones.setForeground(Color.WHITE);
		btnMsOperaciones.setBackground(Color.BLUE);
		btnMsOperaciones.setBounds(297, 193, 134, 39);
		panelMenu.add(btnMsOperaciones);
		
		JButton btnPreferencias = new JButton("Preferencias");
		btnPreferencias.setForeground(Color.WHITE);
		btnPreferencias.setBackground(Color.BLUE);
		btnPreferencias.setBounds(10, 243, 124, 39);
		panelMenu.add(btnPreferencias);
		
		JPanel panelConsulta = new JPanel();
		centro.add(panelConsulta, "consulta");
		panelConsulta.setLayout(null);
		panelConsulta.setOpaque(false);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(SystemColor.textHighlight);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout card = (CardLayout) centro.getLayout();
				card.show(centro,"menu");
			}
		});
		btnVolver.setBounds(157, 276, 118, 62);
		panelConsulta.add(btnVolver);
		table = new JTable();
		
		
		
		
		table.setBounds(381, 27, -337, 186);
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 35, 411, 230);
		panelConsulta.add(scrollPane);
		
		JLabel lblTodosLosMovimientos = new JLabel("TODOS LOS MOVIMIENTOS");
		lblTodosLosMovimientos.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblTodosLosMovimientos.setBounds(128, 11, 217, 14);
		panelConsulta.add(lblTodosLosMovimientos);
	
		
		
		
	}
	
	
	//metodo para insertar movimientos
	
	protected void cargarTabla() {
		table.setModel(new DefaultTableModel(
				conexion.consultarTodo(textField_id.getText()),
				new String[] {
					"Nº Movimiento", "Cuenta", "Concepto", "Cantidad", "Saldo"
				}
			));
		table.setVisible(true);
		repaint();
		
	}

	public void insertarMovimiento(double dinero, String insertar){
		
		
		switch (insertar) {
		case "Ingresar":
			saldo =conexion.consultarSaldo(Integer.parseInt(textField_id.getText()));
			movimiento=new Movimiento(Integer.parseInt(textField_id.getText()),"Ingreso",dinero,saldo+dinero);
			conexion.hacerMovimiento(movimiento);
			JOptionPane.showMessageDialog(panelMenu, "El saldo del que dispone ahora es de "+conexion.consultarSaldo(Integer.parseInt(textField_id.getText()))+" €.", "Operación realizada", JOptionPane.OK_OPTION);

			break;
		case "Retirar":
			
			saldo =conexion.consultarSaldo(Integer.parseInt(textField_id.getText()));			
			if(saldo>=dinero){
				
				movimiento=new Movimiento(Integer.parseInt(textField_id.getText()),"Retirado",dinero,saldo-dinero);
				conexion.hacerMovimiento(movimiento);
				JOptionPane.showMessageDialog(panelMenu, "El saldo del que dispone ahora es de "+conexion.consultarSaldo(Integer.parseInt(textField_id.getText()))+" €.", "Operación realizada", JOptionPane.OK_OPTION);
				}else{
			JOptionPane.showMessageDialog(panelMenu, "La cantidad que desea retirar "+dinero+" es mayor que su saldo disponible.", "Error de operación", JOptionPane.ERROR_MESSAGE);

			}
			
			break;
		case "Tranferir":
			saldo =conexion.consultarSaldo(idTranfe);
			movimiento=new Movimiento(idTranfe,"Tranferencia",dinero,saldo+dinero);
			conexion.hacerMovimiento(movimiento);

			break;
		default:
			break;
		}
	}
}
