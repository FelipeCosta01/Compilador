import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.TextArea;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class windowcompiler extends JFrame {
	Scanner ler = new Scanner(System.in);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // criando JFrame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowcompiler frame = new windowcompiler();
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
	public windowcompiler() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1171, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextArea Entrada = new TextArea(); // Criando o campo entrada
		Entrada.setBounds(10, 22, 1135, 379);
		contentPane.add(Entrada);

		TextArea Console = new TextArea(); // Criando o campo console
		Console.setBounds(10, 552, 1135, 231);
		contentPane.add(Console);

		JButton btnAnalise = new JButton("Compilar"); // Criando botao Compilar
		btnAnalise.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // evento de click no botao
				
				String[] quebra;
				String[] quebraPlus;
				int j=0;
				File caminho = new File("D:/src.txt");
				String receberTexto = Entrada.getText(); // criando a variavel que vai receber o conteudo do arquivo
				FileWriter arquivo; // o arquivo que vai ser lido é a variavel arquivo
				
				try {
					arquivo = new FileWriter(caminho); // variavel arquivo aponta pro caminho
					arquivo.write(receberTexto); // pegando a variavel e colocando dentro do arquivo
					arquivo.close(); // fechando o arquivo que esta em segundo
					
					quebra = receberTexto.split(" ");
					
					for(int i = 0; i < quebra.length; i++) {
						if(!quebra[i].isEmpty()) {
							quebraPlus[j] = quebra[i];
							j++;
						}
					}
				} catch (Exception exe) {
					exe.printStackTrace(); // Mostrando o traço do erro
				}

				Console.setText("Arquivo Processado!"); // inserindo mensagem no campo entrada

			}
		});

		btnAnalise.setBounds(519, 480, 89, 23);
		contentPane.add(btnAnalise);

		JButton btnOpen = new JButton("Abrir"); // Criando botao abrir
		btnOpen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // evento de click no botao

				JFileChooser fc = new JFileChooser(); // criando abertura da pasta pra selecionar arquivo
				int returnVal = fc.showOpenDialog(null);
				File selectedFile = fc.getSelectedFile();

				try {
					Scanner scanner = new Scanner(selectedFile);
					while (scanner.hasNext()) {
						Entrada.setText(Entrada.getText() + scanner.nextLine() + "\n");

					}
					scanner.close();
				} catch (IOException exe) {
					exe.printStackTrace();
				}

			}
		});
		btnOpen.setBounds(10, 0, 89, 23);
		contentPane.add(btnOpen);

	}
}
