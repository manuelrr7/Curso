import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acerca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Acerca dialog = new Acerca();
	JLabel lblCalculadora, lblEste, lblManuelRevueltaRodrguez, lblTodosLosDerechos;
	JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void cambiaEstilo(Color fondo, Color fondotext, Font fuente, Color textfil, Font textfuen) {
		contentPanel.setBackground(fondo);
		lblCalculadora.setFont(fuente);
		lblEste.setFont(fuente);
		lblManuelRevueltaRodrguez.setFont(fuente);
		lblTodosLosDerechos.setFont(fuente);
		okButton.setFont(fuente);
		
	}
	
	/**
	 * Create the dialog.
	 */
	public Acerca() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCalculadora = new JLabel("      Calculadora 2.0");
		lblCalculadora.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblCalculadora
				.setIcon(new ImageIcon(
						"C:\\Users\\al2633.CDC\\workspace\\Calculadora2.0\\img\\cal.png"));
		lblCalculadora.setBounds(29, 11, 358, 99);

		contentPanel.add(lblCalculadora);

		lblEste = new JLabel("Esta aplicación ha sido desarrollada por:");
		lblEste.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblEste.setBounds(76, 137, 286, 31);
		contentPanel.add(lblEste);

		 lblManuelRevueltaRodrguez = new JLabel(
				"Manuel Revuelta Rodr\u00EDguez");
		lblManuelRevueltaRodrguez.setFont(new Font("Comic Sans MS", Font.BOLD,
				14));
		lblManuelRevueltaRodrguez.setBounds(133, 165, 181, 26);
		contentPanel.add(lblManuelRevueltaRodrguez);

		lblTodosLosDerechos = new JLabel(
				"Todos los derechos reservados, a\u00F1o 2015");
		lblTodosLosDerechos.setBounds(90, 189, 286, 29);
		lblTodosLosDerechos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPanel.add(lblTodosLosDerechos);

		JSeparator separator = new JSeparator();
		separator.setBounds(409, 120, -385, 13);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(54, 121, 334, 5);
		contentPanel.add(separator_1);

		{

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

			}
		}
		
		
		
		
	}
}
