package front;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import database.DeleteDB;
import database.MotorStock;
import database.VerificarDB;

public class FrontEgineStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEgineStock frame = new FrontEgineStock();
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
	private void atualizarTabela() {
        VerificarDB verificador = new VerificarDB();
        
        List<MotorStock> motores = verificador.Verificar();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (MotorStock motor : motores) {
            Object[] rowData = {
                motor.getId(),
                motor.getModelo(),
                motor.getMarca(),
                motor.getNumeroMotor(),
                motor.getPotencia()
            };
            model.addRow(rowData);
        }
    }
	public FrontEgineStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnAdicionar = new JButton("Adiconar");
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        int selectedRow = table.getSelectedRow(); // Obtenha a linha selecionada
				        
				        if (selectedRow != -1) {
				            // Exiba uma caixa de diálogo de confirmação
				            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o motor selecionado?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
				            
				            if (resposta == JOptionPane.YES_OPTION) {
				                DefaultTableModel model = (DefaultTableModel) table.getModel();
				                int idMotorExcluir = (int) model.getValueAt(selectedRow, 0); // Supondo que o ID está na primeira coluna (0)

				                DeleteDB deleteDB = new DeleteDB();
				                boolean exclusaoBemSucedida = deleteDB.deleteDb(idMotorExcluir);
				                
				                if (exclusaoBemSucedida) {
				                    // Remova a linha da tabela se a exclusão no banco de dados for bem-sucedida
				                    model.removeRow(selectedRow);
				                } else {
				                    // Lidere com a exclusão mal-sucedida, se necessário
				                    JOptionPane.showMessageDialog(null, "Exclusão mal-sucedida.", "Erro", JOptionPane.ERROR_MESSAGE);
				                }
				            }
				        } else {
				            // Exiba uma mensagem ao usuário informando que nenhuma linha foi selecionada.
				            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
				        }
				    }
			

			
		});
		
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar adicionar = new Adicionar();
				adicionar.setVisible(true);
				
				
				
		
					
			}
		});
		
		

		btnAdicionar.setBounds(802, 72, 87, 28);
		contentPane.add(btnAdicionar);
		
	;
		btnRemover.setBounds(802, 125, 87, 28);
		contentPane.add(btnRemover);
		
		table = new JTable();
		
		table.addAncestorListener(new AncestorListener() {
			
			public void ancestorAdded(AncestorEvent event) {
				atualizarTabela();
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Modelo", "Marca", "Nº Motor", "Potencia"
			}
		));
		table.setBounds(10, 72, 536, 428);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		scrollPane.setBounds(10, 72, 744, 569);

		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Motores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(349, 25, 70, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnAtualiza.setBounds(802, 178, 89, 28);
		contentPane.add(btnAtualiza);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        // Adicionar ouvinte de clique nas colunas do cabeçalho para permitir a classificação
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columnIndex = table.columnAtPoint(e.getPoint());
                sorter.setSortable(columnIndex, true);
                sorter.toggleSortOrder(columnIndex); // Alternar a direção da classificação
            }
        });
	}
}
