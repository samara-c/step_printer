package principal;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class FramePrincipal  implements ActionListener {
     
    
	private final JButton botao = new JButton("Escolher pasta");
	private final JButton botaoIniciar = new JButton("Iniciar");
	private final JButton botaoCaptura = new JButton ("Capturar!");
	private final JTextField campo = new JTextField();
	private final JOptionPane janela = new JOptionPane ();

	private final ButtonGroup radioGroup = new ButtonGroup();
	private final JFileChooser chooser = new JFileChooser();	
	private final JLabel label = new JLabel();
	private final JFrame frame = new JFrame("Step Printer");
	private final JFrame frameCaptura = new JFrame("Step Printer");
	private final Image icone = Toolkit.getDefaultToolkit().getImage("C:\\Users\\samar\\eclipse-workspace\\Miniprint\\resources\\imagem.png");
	

	
	//private final JFileChooser chooser = new JFileChooser();	
    private Utils util = new Utils();
    int i=0;
    public String end;
   
     
    public FramePrincipal() {
		
        
        
        JLabel labelDiretorio = new JLabel();
        
       
        campo.setColumns(30);
        botaoIniciar.setEnabled(false);
        label.setText("Bem vindo ao Step Printer! Selecione onde quer salvar as capturas de tela:");
        campo.setToolTipText("Selecione onde quer salvar as capturas de tela");
        campo.setText("C:\\StepPrinter\\");
        
        
        label.setVisible(true);
        labelDiretorio.setVisible(true);
        
        frame.setLayout(new FlowLayout());
        frame.setSize(500,120);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icone);
        
        frame.add(label);
        frame.add(labelDiretorio);
        frame.add(campo);
        frame.add(botao);
        frame.add(botaoIniciar);
        frame.setVisible(true);
         
         //implementar funcao de tirar print com F11 e F12
        //REGISTRA O EVENTO
        botao.addActionListener(this);
        botaoIniciar.addActionListener(new Evento());
        botaoCaptura.addActionListener(new Captura());
        
 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    		try {
    		
    		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    		chooser.showDialog(null, "Escolha a pasta para guardar os arquivos");
    		File enderecoArquivo = chooser.getSelectedFile();
    		end = enderecoArquivo.toString();
    		System.out.println(end);	
    		campo.setText(end);
    		botaoIniciar.setEnabled(true);

    		
    		}
    		catch (Exception ex) {
    			ex.printStackTrace();
    			
    			
    		}
       
    }
    
    
    private class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String endereco = util.criarPasta(campo.getText());
			System.out.println(endereco);
			frame.setVisible(false);
			botaoCaptura.setVisible(true);
			frameCaptura.add(botaoCaptura);
			frameCaptura.setLayout(new FlowLayout());
			frameCaptura.setResizable(false);
			frameCaptura.setSize(200,70);
			frameCaptura.setIconImage(icone);
			frameCaptura.setVisible(true);
			
	
			
		}
		
	}

			private class Captura implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					frameCaptura.setVisible(false);
					Thread.sleep(100);
					util.capturaScreenshot("tela");
					Thread.sleep(100);
					frameCaptura.setVisible(true);
					
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					
					
					
				}
				
			}
	
				
				
			}

			
			
			
		
    	
    

     
    
	

		
		
	
	




