package src;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;



public class windowcompiler extends JFrame {
	Scanner ler = new Scanner(System.in);

	Biblioteca biblioteca = new Biblioteca();

	private JPanel contentPane;

	tabelaModel tabelamodel = new tabelaModel();
	private JTable infoTable;

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

	public windowcompiler() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1477, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(1164, 453, 287, 330);
        contentPane.add(scrollPane);
        infoTable = new JTable();
        scrollPane.setViewportView(infoTable);
        infoTable.setModel(tabelamodel);
		

		TextArea Entrada = new TextArea(); // Criando o campo entrada
		Entrada.setBounds(10, 22, 1135, 379);
		contentPane.add(Entrada);

		TextArea Console = new TextArea(); // Criando o campo console
		Console.setBounds(10, 552, 1135, 231);
		contentPane.add(Console);

		JButton btnAnalise = new JButton("Compilar"); // Criando botao Compilar
		btnAnalise.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // evento de click no botao

				
				Lexico lexico = new Lexico();
				String receberTexto = Entrada.getText();
				File caminho = new File("d:/src.txt");
				FileWriter arquivo;
				Stack<String> pilha = new Stack<String>();

				try {
					arquivo = new FileWriter(caminho); // variavel arquivo aponta pro caminho
					arquivo.write(receberTexto); // pegando a variavel e colocando dentro do arquivo
					arquivo.close(); // fechando o arquivo que esta em segundo

					lexico.quebra(receberTexto);

					while (!lexico.pilha.isEmpty()) {
						pilha.push(lexico.pilha.pop());
					}

					

				} catch (Exception exe) {
					exe.printStackTrace(); // Mostrando o traço do erro
				}

				if(tabelamodel.getLines() > 0) {

					tabelamodel.clearTable();
                }
				Stack<String> aux = pilha;
				
              while(!aux.isEmpty()) {
            	  
                    informacao i = new informacao();
                    String string = aux.pop().toString();
                    System.out.println(string);
                    String splitString[] = string.split("#");
                    i.setCodigo(splitString[0]);
                    i.setTermo(splitString[1]);
                    tabelamodel.addRow(i);
                    
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
