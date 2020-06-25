package principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class FramePrincipal  implements ActionListener {
     
    
	private final JButton botao = new JButton("Tirar print");
	private final JButton botao1 = new JButton("Botao");
	private final JTextField campo = new JTextField();
    private Utils util = new Utils();
    int i=0;
   
     
    public void janela(){
        JFrame frame = new JFrame("Step Printer");
        JLabel label = new JLabel();
       
        
        label.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        frame.setVisible(true);
        campo.setColumns(50);
        frame.add(botao);
        frame.add(botao1);
        frame.add(campo);
      
        
         
        //REGISTRA O EVENTO
        botao.addActionListener(this);
        botao1.addActionListener(new Evento());
        
 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if (this.i < 1) {
    		util.criarPasta();
    		i++;
    	}
       util.capturaScreenshot("Tela");    
    }
    
    
    private class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			botao1.setText("fui clicado");
			String str = campo.getText();
			System.out.println(str);
			
			
			
			
			
			
			
		}
    	
    
}
     
    
	

		
		
	
	

}


