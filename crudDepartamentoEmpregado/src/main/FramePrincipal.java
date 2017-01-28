package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastrar;
	private JButton btnEmpregado;
	private JButton btnDepartamento;
	private JLabel lblGerenciadorDeEmpresas;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new java.awt.Dimension(784, 398));

		lblCadastrar = new JLabel("Selecione:");
		lblCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastrar.setBounds(60, 144, 88, 16);
		contentPane.add(lblCadastrar);
		
		btnEmpregado = new JButton("Empregado");
		btnEmpregado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmpregado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarEmpregado();
				
			}
		});
		btnEmpregado.setBounds(191, 140, 125, 25);
		contentPane.add(btnEmpregado);
		
		btnDepartamento = new JButton("Departamento");
		btnDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarDepartamento();
				
			}
		});
		btnDepartamento.setBounds(367, 140, 125, 25);
		contentPane.add(btnDepartamento);
		
		lblGerenciadorDeEmpresas = new JLabel("Gerenciador de Empresas");
		lblGerenciadorDeEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGerenciadorDeEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciadorDeEmpresas.setBounds(12, 67, 758, 37);
		contentPane.add(lblGerenciadorDeEmpresas);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnSair.setBounds(577, 140, 97, 25);
		contentPane.add(btnSair);
	}
	
	private void sair() {
		this.dispose();
	}
	
	private void cadastrarEmpregado() {
		new FrameEmpregado();
		
	}
	
	private void cadastrarDepartamento() {
		new FrameDepartamento();
	}	
}
