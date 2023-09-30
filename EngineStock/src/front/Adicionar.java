package front;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.AddDB;
import javax.swing.JComboBox;
import java.awt.Component;

public class Adicionar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textNumeroMotor;
	private JTextField textPotencia;

	/**
	 * Launch the application.
	 */
	FrontEgineStock front = new FrontEgineStock();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adicionar frame = new Adicionar();
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
	public Adicionar() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 283, 383);
		contentPane = new JPanel();
		contentPane.setAlignmentY(50.0f);
		contentPane.setAlignmentX(50.0f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Motor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 11, 139, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 83, 46, 14);
		contentPane.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textModelo.setBounds(76, 80, 176, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(76, 118, 117, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 121, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblNewLabel_1 = new JLabel("Nº Motor");
		lblNewLabel_1.setBounds(10, 156, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		textNumeroMotor = new JTextField();
		textNumeroMotor.setBounds(76, 153, 176, 20);
		contentPane.add(textNumeroMotor);
		textNumeroMotor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Potencia");
		lblNewLabel_2.setBounds(10, 201, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		textPotencia = new JTextField();
		textPotencia.setBounds(76, 198, 46, 20);
		contentPane.add(textPotencia);
		textPotencia.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Adicionar.this.dispose();
			}
		});
		btnCancelar.setBounds(21, 274, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDB addDb = new AddDB();
				addDb.adicionarMotor(textModelo.getText(),textMarca.getText(),textNumeroMotor.getText(),Integer.valueOf(textPotencia.getText()));
				JOptionPane.showMessageDialog(null, "Motor Adicionado Com sucesso!");
				Adicionar.this.dispose();
				
				
			}
		});
		btnAdicionar.setBounds(133, 274, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
