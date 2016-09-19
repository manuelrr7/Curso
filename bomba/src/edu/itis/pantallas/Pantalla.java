package edu.itis.pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

import edu.itis.clases.Reloj;
import edu.itis.principal.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pantalla extends JFrame {

	private JPanel contentPane;
	private JLabel parpadeo;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public static JPanel pantalla_principal;
	private JPanel intro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
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
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		intro = new JPanel();
		contentPane.add(intro, "pantallaIntro");
		intro.setLayout(null);
		
		
		
		parpadeo = new JLabel("PULSA PARA CONTINUAR");
		parpadeo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				intro.setVisible(false);
				pantalla_principal.setVisible(true);
				
			}
		});
		parpadeo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		parpadeo.setFont(new Font("Tahoma", Font.BOLD, 19));
		parpadeo.setBounds(77, 355, 255, 23);
		intro.add(parpadeo);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Pantalla.class.getResource("/edu/itis/resources/Logo_Grande.png")));
		logo.setBounds(52, 74, 309, 259);
		intro.add(logo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Pantalla.class.getResource("/edu/itis/resources/fondo.jpg")));
		fondo.setBounds(10, 0, 419, 415);
		intro.add(fondo);
		
		pantalla_principal = new JPanel();
		contentPane.add(pantalla_principal, "pantallaPrincipal");
		pantalla_principal.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setEnabled(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 32));
		textField.setBackground(Color.GREEN);
		textField.setBounds(50, 240, 108, 78);
		pantalla_principal.add(textField);
		textField.setColumns(10);
		
		JLabel tnt = new JLabel("");
		tnt.setIcon(new ImageIcon(Pantalla.class.getResource("/edu/itis/resources/dinamita.png")));
		tnt.setBounds(0, 0, 200, 437);
		pantalla_principal.add(tnt);
		
		JLabel lblInstrucciones = new JLabel("Instrucciones:");
		lblInstrucciones.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblInstrucciones.setBounds(221, 27, 144, 39);
		pantalla_principal.add(lblInstrucciones);
		
		JLabel lblActiveLa = new JLabel("1. Active la bomba pusando ");
		lblActiveLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblActiveLa.setBounds(221, 78, 193, 14);
		pantalla_principal.add(lblActiveLa);
		
		JLabel lblElBotnDe = new JLabel("el bot\u00F3n de incio situado abajo.");
		lblElBotnDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblElBotnDe.setBounds(210, 101, 204, 14);
		pantalla_principal.add(lblElBotnDe);
		
		JLabel lblIntenteDesactivarlo = new JLabel("2. Intente desactivarlo");
		lblIntenteDesactivarlo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblIntenteDesactivarlo.setBounds(221, 142, 166, 14);
		pantalla_principal.add(lblIntenteDesactivarlo);
		
		JLabel lblEnMenosDe = new JLabel("en menos de 10 segundos.");
		lblEnMenosDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEnMenosDe.setBounds(221, 165, 193, 14);
		pantalla_principal.add(lblEnMenosDe);
		
		JLabel lblParaDesactivarlo = new JLabel("3. Para desactivarlo debe pulsar");
		lblParaDesactivarlo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblParaDesactivarlo.setBounds(220, 206, 204, 14);
		pantalla_principal.add(lblParaDesactivarlo);
		
		JLabel lblElBotnDe_1 = new JLabel("el bot\u00F3n de desactivar.");
		lblElBotnDe_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblElBotnDe_1.setBounds(221, 231, 150, 14);
		pantalla_principal.add(lblElBotnDe_1);
		
		JLabel lblFacilno = new JLabel("F\u00E1cil, \u00BFno?");
		lblFacilno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblFacilno.setBounds(221, 272, 78, 14);
		pantalla_principal.add(lblFacilno);
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(false);
				Principal p=new Principal();
				p.parada();
				p.inicioCuenta();
				btnNewButton_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(257, 297, 89, 44);
		pantalla_principal.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Desactivar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(true);
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(199, 352, 89, 49);
		pantalla_principal.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Desactivar");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_2.setVisible(false);
				btnNewButton_1.setVisible(true);
				
			}
		});
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(327, 352, 97, 49);
		pantalla_principal.add(btnNewButton_2);
	}

	
	public void fin(){
		System.exit(EXIT_ON_CLOSE);
	}
	
	public void cambiarText(int i){
		String txt=String.valueOf(i);
		textField.setText(txt);
	}
	
	public void pintarReloj(int contador){
		
		
		
	}
	
	
	
	
	public void parpadeoJlabel(boolean visi){
		if(visi==true){
			parpadeo.setForeground(Color.BLACK);
		
		}else{
			parpadeo.setForeground(Color.WHITE);
		
		}
		
	}
}
