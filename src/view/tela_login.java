package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import acao.Validador;

public class tela_login implements ActionListener{

	private JFrame tela;
	private JTextField caixa1;
	private JTextField caixa2;
	
	/**
	 * Chama a tela.
	 */
	public tela_login() throws Exception{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		inicializa();
	}
	
	/**
	 * public tela_login() {
	 *
	 *	
	 * } 
	 */

	/**
	 * Executa a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_login window = new tela_login();
					window.tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa os componentes do frame.
	 */
	
	JLabel labelResultado;
	
	private void inicializa() {
		tela = new JFrame();
		tela.setResizable(false);
		tela.setBounds(100, 100, 890, 592);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 876, 1);
		tela.getContentPane().add(panel);
		panel.setLayout(null);
		
		caixa1 = new JTextField();
		caixa1.setFont(new Font("Berlin Sans FB", Font.BOLD, 40));
		caixa1.setBounds(58, 239, 154, 51);
		tela.getContentPane().add(caixa1);
		caixa1.setColumns(10);
		caixa1.setDocument(new Validador(5));
		
		
		JLabel labelMais = new JLabel("+");
		labelMais.setFont(new Font("Berlin Sans FB", Font.BOLD, 50));
		labelMais.setBounds(227, 239, 36, 51);
		tela.getContentPane().add(labelMais);
		
		caixa2 = new JTextField();
		caixa2.setFont(new Font("Berlin Sans FB", Font.BOLD, 40));
		caixa2.setColumns(10);
		caixa2.setBounds(273, 239, 154, 51);
		tela.getContentPane().add(caixa2);
		caixa2.setDocument(new Validador(5));
		
		JButton btnIgual = new JButton("=");
		btnIgual.setBackground(new Color(240, 240, 240));
		btnIgual.setFont(new Font("Berlin Sans FB", Font.BOLD, 50));
		btnIgual.setBounds(450, 239, 89, 51);
		tela.getContentPane().add(btnIgual);
		btnIgual.addActionListener(this);
		
		labelResultado = new JLabel("");
		labelResultado.setFont(new Font("Berlin Sans FB", Font.BOLD, 50));
		labelResultado.setBounds(549, 239, 296, 51);
		tela.getContentPane().add(labelResultado);
		
		JButton btnApagar = new JButton("Limpar");
		btnApagar.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		btnApagar.setBounds(58, 460, 154, 84);
		tela.getContentPane().add(btnApagar);
		btnApagar.addActionListener(this :: btnApagar);
	}
	
	private String getCaixa1() {
		return caixa1.getText();
	}
	
	private String getCaixa2() {
		return caixa2.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(getCaixa1());
		double num2 = Double.parseDouble(getCaixa2());
		
		labelResultado.setText(String.valueOf(num1 + num2));
		
	}
	
	public void btnApagar(ActionEvent actionEvent) {
		caixa1.setText("");
		caixa2.setText("");
		labelResultado.setText("");
	}
	
	
}
