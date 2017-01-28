package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.EmpresaDAO;
import entity.Departamento;
import exception.DaoException;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AlterarDepartamento extends JFrame {

	private JPanel contentPane;
	private JButton gravar;

	private JLabel codigo;
	private JTextField tnome;
	private JTextField tsigla;

	private JTextField tcodigo;
	private JLabel departamento;
	private JLabel nome;
	private JButton sair;

	/**
	 * Create the frame.
	 */
	public AlterarDepartamento() {
		setTitle("Alterar Departamento");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(220, 220, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		{
			gravar = new JButton();
			contentPane.add(gravar);
			gravar.setText("Gravar");
			gravar.setBounds(266, 472, 89, 23);
			gravar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						gravar();
						sair();
					} catch (DaoException e) {
						e.printStackTrace();
					}
				}
			});
		}
		{
			sair = new JButton();
			contentPane.add(sair);
			sair.setText("Sair");
			sair.setBounds(388, 472, 84, 23);
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					sair();
				}

			});
		}
		{
			codigo = new JLabel();
			contentPane.add(codigo);
			codigo.setText("Codigo");
			codigo.setBounds(182, 86, 39, 16);
		}
		{
			nome = new JLabel();
			contentPane.add(nome);
			nome.setText("Nome");
			nome.setBounds(182, 121, 33, 16);
		}

		{
			departamento = new JLabel();
			contentPane.add(departamento);
			departamento.setText("Departamento");
			departamento.setBounds(182, 188, 76, 16);
		}
		{
			tcodigo = new JTextField();
			contentPane.add(tcodigo);
			tcodigo.setBounds(278, 83, 143, 23);
		}
		{
			tnome = new JTextField();
			contentPane.add(tnome);
			tnome.setBounds(278, 118, 311, 23);
		}
		{
			tsigla = new JTextField();
			contentPane.add(tsigla);
			tsigla.setBounds(276, 188, 313, 23);
		}

	}

	private void sair() {
		this.dispose();
	}

	private void gravar() throws DaoException {
		EmpresaDAO dao = new EmpresaDAO();
		Departamento departamento = new Departamento(Integer.parseInt(tcodigo
				.getText()), tsigla.getText(), tnome.getText());
		dao.addDepartamento(departamento);
	}
}
