package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.EstadoService;
import service.PaisService;
import service.Tabelavel;
import dto.EstadoDTO;
import entity.Pais;
import exception.DaoException;
import exception.ServiceException;


public class JanelaCadastroEstado extends JFrame implements ActionListener{



	private JPanel contentPane;
	private JTable table;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnListarCadastro;
	private JButton btnVoltar;
	private JScrollPane scrollPane;
	private static EstadoService estadoService = new EstadoService();
	private static PaisService paisService = new PaisService(estadoService);
	private Pais pais;
	private EstadoDTO estadoDTO;
	private JLabel lbFundo;
	


	public JanelaCadastroEstado() {
		
		
		this.lbFundo = new JLabel(new ImageIcon("image/mundo.png"));
		this.lbFundo.setBounds(0, 0, 412, 334);
		this.add(lbFundo);
		
		setTitle("Estados");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200,200,435,360);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(10, 232, 89, 23);
		this.lbFundo.add(btnIncluir);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(109, 232, 89, 23);
		this.lbFundo.add(btnExcluir);
		
		btnListarCadastro = new JButton("Listar");
		btnListarCadastro.setBounds(308, 232, 89, 23);
		this.lbFundo.add(btnListarCadastro);
		
		btnAlterar = new JButton("Alterar");	
		btnAlterar.setBounds(208, 232, 89, 23);
		this.lbFundo.add(btnAlterar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(156, 262, 89, 23);
		this.lbFundo.add(btnVoltar);
		
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 386, 212);
		this.lbFundo.add(scrollPane);

		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Sigla", "Capital", "Area"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane.setViewportView(table);
					
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
	this.btnIncluir.addActionListener(this);
	this.btnAlterar.addActionListener(this);
	this.btnExcluir.addActionListener(this);
	this.btnVoltar.addActionListener(this);
	this.btnListarCadastro.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//if (arg0.getSource() == this.btnListarCadastro) {

		//DefaultTableModel model = (DefaultTableModel) this.table.getModel();

		//if (table.getRowCount() > 0) {
		//while (table.getRowCount() > 0)
		//model.removeRow(0);
		//}

		//this.btnListarCadastro.setEnabled(false);
		//	btnExcluir.setEnabled(true);
		//	btnIncluir.setEnabled(true);//
		
		if (arg0.getSource() == this.btnIncluir){
			JanelaEstado j = new JanelaEstado();
			
		}
		if (arg0.getSource() == this.btnAlterar){
			JanelaCadastroEstado jc = new JanelaCadastroEstado();
			this.dispose();
		}
		if (arg0.getSource() == this.btnVoltar)
		{
			dispose();
		}
	}
	
	
	public void Limpar(){
		DefaultTableModel dtm = (DefaultTableModel)this.table.getModel();
		while(dtm.getRowCount() > 0)
			dtm.removeRow(0);
		
	}
		public void incluirLinha(Tabelavel objeto) {
			DefaultTableModel dtm = (DefaultTableModel)this.table.getModel();
			dtm.addRow(objeto.getData());
		}
		
		
			
				
	}

		

	


