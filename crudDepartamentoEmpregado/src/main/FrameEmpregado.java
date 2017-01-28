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

import service.DepartamentoService;
import service.EmpregadoService;
import dao.EmpresaDAO;
import entity.Empregado;

public class FrameEmpregado extends JFrame {

	private JPanel contentPane;
	private JTable tableEmpregado;
	private static EmpregadoService empregadoService = new EmpregadoService();
	private static DepartamentoService departamentoService = new DepartamentoService();
	
	/**
	 * Create the frame.
	 */
	public FrameEmpregado() {
		setTitle("Frame Empregado");
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
			public void actionPerformed(ActionEvent e) {
				new AlterarEmpregado();
			}

		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(313, 430, 97, 25);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				/**
				
				String[] linhaSelecionada = new String[] {};
				DefaultTableModel model = (DefaultTableModel) tableEmpregado.getModel();
				
				for (int i = 0; i <= tableEmpregado.getColumnCount(); i++) 
					linhaSelecionada[i] = (String) model.getValueAt(tableEmpregado.getSelectedRow(), i);
				try {
					empregadoService.removerEmpregado(Integer.parseInt(linhaSelecionada[1]));
				} catch (DaoException e1) {
					e1.printStackTrace();
				}
				try {
					departamentoService.removerDepartamento(Integer.parseInt(linhaSelecionada[4]));
				} catch (DaoException e2) {
					e2.printStackTrace();
				}
				model.removeRow(tableEmpregado.getSelectedRow());
				**/
			}

		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(434, 430, 97, 25);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlterarEmpregado();
				atualizarTabela();
			}

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 758, 405);
		contentPane.add(scrollPane);

		tableEmpregado = new JTable();
		EmpresaDAO dao = new EmpresaDAO();
		
		Object lista[] = dao.getEmpregados().toArray();

		for (Object object : lista) {
			Empregado empregado = (Empregado) object;

			tableEmpregado.setModel(new DefaultTableModel(new Object[][] { {
					empregado.getCodigo(), empregado.getNome(), empregado.getIdade(), empregado.getDepartamento().getNome() }, }, new String[] { "C\u00F3digo",
					"Nome", "Idade", "Departamento" }));
			empregado = null;
			lista = null;
		}

		scrollPane.setViewportView(tableEmpregado);
		LayoutManager gl_contentPane = null;
		contentPane.setLayout(gl_contentPane);
		// tableEmpregado.removeColumn(tableEmpregado.getColumn("Departamento"));

	}
	
	public void atualizarTabela(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 758, 405);
		contentPane.add(scrollPane);
		
		tableEmpregado = new JTable();
		EmpresaDAO dao = new EmpresaDAO();
		Object lista[] = dao.getEmpregados().toArray();

		for (Object object : lista) {
			Empregado empregado = (Empregado) object;

			tableEmpregado.setModel(new DefaultTableModel(new Object[][] { {
					empregado.getCodigo(), empregado.getNome(), empregado.getIdade(), empregado.getDepartamento().getNome() }, }, new String[] { "C\u00F3digo",
					"Nome", "Idade", "Departamento" }));
			empregado = null;
			lista = null;
		}

		scrollPane.setViewportView(tableEmpregado);
		LayoutManager gl_contentPane = null;
		contentPane.setLayout(gl_contentPane);
	}

}
