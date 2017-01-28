package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class FramePesquisa extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePesquisa frame = new FramePesquisa();
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
	public FramePesquisa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciador de Empresas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 64, 758, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblResultadosDaPesquisa = new JLabel("Resultados da pesquisa:");
		lblResultadosDaPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultadosDaPesquisa.setBounds(100, 199, 182, 35);
		contentPane.add(lblResultadosDaPesquisa);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(186, 279, 81, 16);
		contentPane.add(lblDepartamento);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setBounds(380, 279, 81, 16);
		contentPane.add(lblFuncionrio);
		
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setBounds(580, 279, 56, 16);
		contentPane.add(lblEditar);
		
		table = new JTable();
		table.setBackground(SystemColor.scrollbar);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(100, 260, 597, 205);
		contentPane.add(table);
	}
}
