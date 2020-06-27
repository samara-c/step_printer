package principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
public class FramePrincipal  implements ActionListener {
     
    
	private final JButton botao = new JButton("Escolher pasta");
	private final JButton botaoIniciar = new JButton("Iniciar");
	private final JTextField campo = new JTextField();
	private final JOptionPane janela = new JOptionPane ();
	private final JRadioButton opcaoF12 = new JRadioButton("F12", false);
	private final JRadioButton opcaoF11 = new JRadioButton("F11",false);
	private final ButtonGroup radioGroup = new ButtonGroup();
	private final JFileChooser chooser = new JFileChooser();	
	//private final JFileChooser chooser = new JFileChooser();	
    private Utils util = new Utils();
    int i=0;
   
     
    public FramePrincipal() {
		
        JFrame frame = new JFrame("Step Printer");
        JLabel label = new JLabel();
        JLabel labelDiretorio = new JLabel();
        
        
        radioGroup.add(opcaoF12);
        radioGroup.add(opcaoF11);
        campo.setColumns(30);
        botaoIniciar.setEnabled(false);
        label.setText("Bem vindo ao Step Printer! Selecione onde quer salvar as capturas de tela:");
        campo.setToolTipText("Selecione onde quer salvar as capturas de tela");
        campo.setText("C:\\StepPrinter\\");
        
        
        label.setVisible(true);
        labelDiretorio.setVisible(true);
        
        frame.setLayout(new FlowLayout());
        frame.setSize(500,200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        frame.add(label);
        frame.add(labelDiretorio);
        frame.add(campo);
        frame.add(botao);
        frame.add(botaoIniciar);
        
        
      
        
         //implementar funcao de tirar print com F11 e F12
        //REGISTRA O EVENTO
        botao.addActionListener(this);
        botaoIniciar.addActionListener(new Evento());
        
 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    		try {
    		
    		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    		chooser.showDialog(null, "Escolha a pasta para guardar os arquivos");
    		File enderecoArquivo = chooser.getSelectedFile();
    		String end = enderecoArquivo.toString();
    		System.out.println(end);	
    		String endereco = util.criarPasta(end);
    		campo.setText(endereco);
    		botaoIniciar.setEnabled(true);
//    		janela.showMessageDialog(null, "A pasta foi criada com sucesso");
    		
    		}
    		catch (Exception ex) {
    			ex.printStackTrace();
    			
    			
    		}
       
    }
    
    
    private class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			util.capturaScreenshot("tela");
			
			
			
			
			
			
			
			
			
		}
		
	
				
				
				
					
		
				
				
			}

			
	
				
				
			}

			
			
			
		
    	
    

     
    
	

		
		
	
	




