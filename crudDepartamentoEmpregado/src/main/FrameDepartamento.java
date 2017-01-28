package main;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.EmpresaDAO;
import entity.Departamento;

public class FrameDepartamento extends JFrame {

	private JPanel contentPane;
	private JTable tableDepartamento;

	/**
	 * Create the frame.
	 */
	public FrameDepartamento() {
		setTitle("Frame Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Clique no 'x' para voltar \u00E0 tela inicial...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 468, 758, 72);
		contentPane.add(lblNewLabel);

		JButton btnIncluir = new JButton("Incluir");

		btnIncluir.setBounds(192, 430, 97, 25);
		contentPane.add(btnIncluir);
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AlterarDepartamento();
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(313, 430, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(434, 430, 97, 25);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AlterarDepartamento();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 758, 405);
		contentPane.add(scrollPane);

		tableDepartamento = new JTable();

		EmpresaDAO dao = new EmpresaDAO();
		Object lista[] = dao.getDepartamentos().toArray();

		for (Object object : lista) {
			Departamento departamento = (Departamento) object;
			tableDepartamento.setModel(new DefaultTableModel(new Object[][] { {
					departamento.getCodigo(), departamento.getSigla(),
					departamento.getNome() }, }, new String[] { "C\u00F3digo",
					"Sigla", "Nome" }));
			departamento = null;
			lista = null;
		}
		scrollPane.setViewportView(tableDepartamento);
		LayoutManager gl_contentPane = null;
		contentPane.setLayout(gl_contentPane);

	}

}
