import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;

import java.awt.Panel;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;


public class Calculadora2 extends JFrame {

	

    
	
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private String num="";
	private String num1="";
	private LinkedList<String> listaNum;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton button, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, button_13, button_14, button_15, btnBorrar, btnX; 
	private JRadioButton rdbtnBasico, rdbtnFuturista, rdbtnRomano, rdbtnBroadway, rdbtnInfantil, rdbtnSesenta, rdbtnMilitar,  rdbtnAntiguo;
	private JMenuItem mntmAcercaDe, mntmAyuda;
	private JMenu mnVer, mnAyuda;
	private Acerca ac;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora2 frame = new Calculadora2();
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
	
	
	public Calculadora2() {
		setResizable(false);
		ac= new Acerca();
		
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/cal.png"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\al2633.CDC\\workspace\\Calculadora2.0\\img\\cal.png"));
	    setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 300);
		listaNum=new LinkedList<String>();
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		setJMenuBar(menuBar);
		
		mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		
		
		rdbtnBasico = new JRadioButton("basico");
		rdbtnBasico.setSelected(true);
		buttonGroup.add(rdbtnBasico);
		rdbtnBasico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cambiaEstilo(Color.black, Color.GREEN, new Font("Arial", Font.PLAIN, 12), Color.BLACK, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		mnVer.add(rdbtnBasico);
		
		rdbtnFuturista = new JRadioButton("futurista");
		buttonGroup.add(rdbtnFuturista);
		rdbtnFuturista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c1= new Color(129,159,247);
				
				cambiaEstilo(c1, Color.BLUE, new Font("Verdana", Font.PLAIN, 12), Color.WHITE, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		mnVer.add(rdbtnFuturista);
		
		rdbtnRomano = new JRadioButton("romano");
		rdbtnRomano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cambiaEstilo(Color.red, Color.yellow, new Font("Tahoma", Font.PLAIN, 12), Color.BLACK, new Font("Comic Sans MS", Font.PLAIN, 10));				
			}
		});
		buttonGroup.add(rdbtnRomano);
		mnVer.add(rdbtnRomano);
		
		rdbtnBroadway = new JRadioButton("broadway");
		rdbtnBroadway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c2= new Color(13,21,92);
				cambiaEstilo(c2, Color.BLUE, new Font("Times New Roman", Font.PLAIN, 12), Color.WHITE, new Font("Comic Sans MS", Font.PLAIN, 10));			}
		});
		buttonGroup.add(rdbtnBroadway);
		mnVer.add(rdbtnBroadway);
		
		rdbtnInfantil = new JRadioButton("infantil");
		rdbtnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cambiaEstilo(Color.YELLOW, Color.GREEN, new Font("Comic Sans MS", Font.PLAIN, 12), Color.BLACK, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		buttonGroup.add(rdbtnInfantil);
		mnVer.add(rdbtnInfantil);
		
		rdbtnSesenta = new JRadioButton("sesenta");
		rdbtnSesenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c3= new Color(105,235,240);
				Color c4= new Color(253,82,247);
				cambiaEstilo(c3, c4, new Font("SansSerif", Font.PLAIN, 12), Color.WHITE, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		buttonGroup.add(rdbtnSesenta);
		mnVer.add(rdbtnSesenta);
		
		rdbtnMilitar = new JRadioButton("militar");
		rdbtnMilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c5= new Color(41,105,27);
				cambiaEstilo(c5, Color.GREEN, new Font("Monospaced", Font.PLAIN, 12), Color.BLACK, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		buttonGroup.add(rdbtnMilitar);
		mnVer.add(rdbtnMilitar);
		
		rdbtnAntiguo = new JRadioButton("antiguo");
		rdbtnAntiguo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c6= new Color(228,172,18);
				cambiaEstilo(c6, Color.ORANGE, new Font("Comic Sans MS", Font.PLAIN, 12), Color.BLACK, new Font("Comic Sans MS", Font.PLAIN, 10));
			}
		});
		buttonGroup.add(rdbtnAntiguo);
		mnVer.add(rdbtnAntiguo);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnAyuda.add(mntmAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			 
			ac.setVisible(true);
				
				
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);

		
		button = new JButton("1");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="1";
					textField.setText(num);
				}else {
				num+="1";				
				textField.setText(num);
				}
			
			}
		});
		button.setBounds(0, 0, 47, 38);
		panel_1.add(button);
		
		button_1 = new JButton("2");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="2";
					textField.setText(num);
				}else {
				num+="2";
				textField.setText(num);
				}
			
			}
		});
		button_1.setBounds(50, 0, 47, 38);
		panel_1.add(button_1);
		
		button_2 = new JButton("3");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="3";
					textField.setText(num);
				}else {
				num+="3";
				textField.setText(num);
				}
			
			}
		});
		button_2.setBounds(100, 0, 47, 38);
		panel_1.add(button_2);
		
		button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (num.equals("+")) {
					
					listaNum.add(num);
					
					listaNum.add("+");					
					
					num="+";
					
					textField.setText(num);
				} else if (num.equals("-") || num.equals("*") || num.equals("/")) {
					
					listaNum.removeLast();
					
					listaNum.add("+");					
					
					num="+";
					
					textField.setText(num);
					
				} else {
				listaNum.add(num);
				listaNum.add("+");
				num="+";
				textField.setText(num);
				}
			
			}
		});
		button_3.setBounds(151, 0, 47, 38);
		panel_1.add(button_3);
		
		button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="4";
					textField.setText(num);
				}else {
				num+="4";
				textField.setText(num);
				}
			
			}
		});
		button_4.setBounds(0, 42, 47, 38);
		panel_1.add(button_4);
		
		button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="5";
					textField.setText(num);
				}else {
				num+="5";
				textField.setText(num);
				}
			
			}
		});
		button_5.setBounds(50, 42, 47, 38);
		panel_1.add(button_5);
		
		button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="6";
					textField.setText(num);
				}else {
				
				num+="6";
				textField.setText(num);
				}
			
			}
		});
		button_6.setBounds(100, 42, 47, 38);
		panel_1.add(button_6);
		
		button_7 = new JButton("-");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (num.equals("-")) {
					listaNum.add(num);
					
					listaNum.add("-");					
					
					num="-";
					
					textField.setText(num);
				} else	if (num.equals("+") || num.equals("*") || num.equals("/")) {
					
					listaNum.removeLast();
					
					
					listaNum.add("-");					
					
					num="-";
					
					textField.setText(num);
					
				} else {
					listaNum.add(num);
					
					listaNum.add("-");
					
					num="-";
					
					textField.setText(num);
				}
							}
		});
		button_7.setBounds(151, 42, 47, 38);
		panel_1.add(button_7);
		
		button_8 = new JButton("7");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="7";
					textField.setText(num);
				}else {
					num+="7";
					textField.setText(num);
				}			
			
			}
		});
		button_8.setBounds(0, 84, 47, 38);
		panel_1.add(button_8);
		
		button_9 = new JButton("8");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="8";
					textField.setText(num);
				}else {
				num+="8";
				textField.setText(num);
				}
			
			}
		});
		button_9.setBounds(50, 84, 47, 38);
		panel_1.add(button_9);
		
		button_10 = new JButton("9");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("0") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="9";
					textField.setText(num);
				}else {
				num+="9";
				textField.setText(num);
				}
			
			}
		});
		button_10.setBounds(100, 84, 47, 38);
		panel_1.add(button_10);
		
		btnX = new JButton("*");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.equals("*")) {
					listaNum.add(num);
					
					listaNum.add("*");					
					
					num="*";
					
					textField.setText(num);
				} else if (num.equals("+") || num.equals("-") || num.equals("/")) {
					
					listaNum.removeLast();
					
					listaNum.add("*");					
					
					num="*";
					
					textField.setText(num);
					
				} else {
				
				listaNum.add(num);
				listaNum.add("*");
				num="*";
				textField.setText(num);
				}
			
			}
		});
		btnX.setBounds(152, 84, 47, 38);
		panel_1.add(btnX);
		
		button_11 = new JButton(".");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textField.getText().equals("")) {
					num="0.";
					textField.setText(num);
				} else if (textField.getText().contains(".")==false) {							
					num+=".";
					textField.setText(num);
				}
				
			
			}
		});
		button_11.setBounds(0, 125, 47, 38);
		panel_1.add(button_11);
		
		button_12 = new JButton("0");
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (num.equals("0") || textField.getText().equals("") || num.equals("+") || num.equals("-") || num.equals("/") || num.equals("*")) {
					num="";
					textField.setText(num);
					num="0.";
					textField.setText(num);
				}else

				num+="0";
				textField.setText(num);
			
			}
		});
		button_12.setBounds(50, 125, 47, 38);
		panel_1.add(button_12);
		
		button_13 = new JButton("=");
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ope1=0;
				double ope2=0;
				boolean suma= false;
				boolean resta=false;
				boolean multi=false;
				boolean div=false;
				
				if (num.equals("")) {
					num="";
					textField.setText(num);
				} else {

				
				
				listaNum.add(num);
				
				for (int i = 0; i < listaNum.size(); i++) {
					
					if(i==0){
						ope1=Double.parseDouble(listaNum.get(i));
					}else{
						if (i%2==0) {
							ope2 = Double.parseDouble(listaNum.get(i));
							if(suma){
								ope1+=ope2;
								suma=false;
							}
							if(resta){
								ope1-=ope2;
								resta=false;
							}
							if(multi){
								ope1*=ope2;
								multi=false;
							}
							if(div){
								ope1/=ope2;
								div=false;
							}
							
							
						}else {
							switch(listaNum.get(i)){
							case "+":
								suma=true;
								break;
							case "-":
								resta=true;
								break;
							case "*":
								multi=true;
								break;
							case "/":
								div=true;
								break;
							}
							
						}
						
					}
					
				}
				
				
				
				textField.setText(""+ope1);
				num=""+ope1;
				listaNum.removeAll(listaNum);
				
				}
			
			}
		});
		button_13.setBounds(100, 125, 47, 38);
		panel_1.add(button_13);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num="0";
				textField.setText(num);
				listaNum.removeAll(listaNum);
				
			
			}
		});
		btnBorrar.setBounds(0, 165, 134, 33);
		panel_1.add(btnBorrar);
		
		button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (num.equals("/")) {
					
					listaNum.add(num);
					
					listaNum.add("/");					
					
					num="/";
					
					textField.setText(num);
				} else if (num.equals("+") || num.equals("*") || num.equals("-")) {
					
					listaNum.removeLast();
					
					listaNum.add("/");					
					
					num="/";
					
					textField.setText(num);
					
				} else {
				
				listaNum.add(num);
				listaNum.add("/");
				num="/";
				textField.setText(num);
				}
			
			}
		});
		button_14.setBounds(151, 125, 47, 38);
		panel_1.add(button_14);
		
		button_15 = new JButton("\u2190");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (num.equals("")) {
					num = "";
					textField.setText(num);
				}else {

					num=num.substring(0, num.length() - 1 );
					textField.setText(num);
				}

				
			}
		});
		button_15.setBounds(141, 165, 57, 33);
		panel_1.add(button_15);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.GREEN);
		textField.setBounds(0, 0, 188, 38);
		panel.add(textField);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 188, 38);
		panel.add(textField);
		textField.setColumns(10);
		textField.setColumns(10);
		contentPane.setLayout(gl_contentPane);
		
	
	}

	protected void cambiaEstilo(Color fondo, Color fondotext, Font fuente, Color textfil, Font textfuen) {
		
		contentPane.setBackground(fondo);
		
		textField.setBackground(fondotext);
		
		textField.setFont(textfuen);
		
		textField.setForeground(textfil);
		
		button.setFont(fuente);
		button_1.setFont(fuente);
		button_2.setFont(fuente);
		button_3.setFont(fuente);
		button_4.setFont(fuente);
		button_5.setFont(fuente);
		button_6.setFont(fuente);
		button_7.setFont(fuente);
		button_8.setFont(fuente);
		button_9.setFont(fuente);
		button_10.setFont(fuente);
		button_11.setFont(fuente);
		button_12.setFont(fuente);
		button_13.setFont(fuente);
		button_14.setFont(fuente);
		button_15.setFont(fuente);
		btnX.setFont(fuente);
		btnBorrar.setFont(fuente);
		
		
		rdbtnBasico.setFont(fuente);
		rdbtnFuturista.setFont(fuente);
		rdbtnRomano.setFont(fuente);
		rdbtnBroadway.setFont(fuente);
		rdbtnInfantil.setFont(fuente);
		rdbtnSesenta.setFont(fuente);
		rdbtnMilitar.setFont(fuente);
		rdbtnAntiguo.setFont(fuente);
		
		mntmAcercaDe.setFont(fuente);
		mntmAyuda.setFont(fuente);
		
		mnVer.setFont(fuente);
		mnAyuda.setFont(fuente);
		
		ac.cambiaEstilo(fondo, fondotext, fuente, textfil, textfuen);
		
	}
	
}
