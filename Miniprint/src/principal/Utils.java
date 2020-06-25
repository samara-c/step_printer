package principal;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class Utils {
	
	String nomeEEnderecoPasta;
	int i =0;
	
	public String data (String format) { //pega a data atual e devolve uma string. precisa receber "dd/MM/yyyy" ou qualquer outro formato de data
		
		Date hoje = new Date();
		SimpleDateFormat hojeSimplificado = new SimpleDateFormat (format);
		String dataFinal = hojeSimplificado.format(hoje);
		
	return dataFinal;	
	
	}
	
	
	public String horario () { //pega o horario atual e devolve uma string
		Date horarioAtual = new Date ();
		SimpleDateFormat horarioSimplificado = new SimpleDateFormat("HH_mm");
		String horarioFinal = horarioSimplificado.format(horarioAtual);
		
		return horarioFinal;
	}
	
	public void criarPasta () { //cria uma pasta dentro do diretorio target
		
		try {
			nomeEEnderecoPasta = "D:\\"+data("dd_MM_yyyy")+"_"
		+horario();
			File pasta = new File (nomeEEnderecoPasta);
			pasta.mkdir();
			System.out.println("A pasta "+nomeEEnderecoPasta+" foi criada com sucesso!");
		
			
		} catch (Exception e) {
			
			System.out.println("Não foi possivel criar a pasta no destino especificado");
			e.printStackTrace();
		}
		
		
	}
	
	public void capturaScreenshot (String nomeTela) { //captura screenshot da tela e joga dentro da pasta nova criada
		
		 try {
	            
			 	  Robot robot = new Robot();
	            BufferedImage bi=robot.createScreenCapture(pegarDimensaoDaTela());
	            String nomeImagemSalva =  nomeEEnderecoPasta+"/Screencapture_"+nomeTela+"_"+this.i;
	            ImageIO.write(bi, "PNG", new File(nomeImagemSalva));
	            i+=1;
	            
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
	
	}
	
	public Rectangle pegarDimensaoDaTela () { 
		
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					int screenSizeW = (int) toolkit.getScreenSize().getWidth(); 
					int screenSizeH = (int) toolkit.getScreenSize().getHeight();
					Rectangle dimensaoTela = new Rectangle (screenSizeW,screenSizeH);
					
		return dimensaoTela;			
	}
}

