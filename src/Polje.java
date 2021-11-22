import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Polje extends Panel {

	private char XO='N';
	private Igra igra;
	private BufferedImage imgX;
	private BufferedImage imgO;
	private static int brojac=0;
	
	public Polje(Igra i)
	{
		this.igra=i;
		try {
			imgX=ImageIO.read(getClass().getClassLoader().getResource("redX2.png"));
			imgO=ImageIO.read(getClass().getClassLoader().getResource("redO2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        		this.addMouseListener(new MouseAdapter()
				{
				public void mouseClicked(MouseEvent e)
				{
					if(Polje.this.XO=='N')
					{
					brojac++;
					if(Polje.this.igra.getPlayer()=='X')
					{
						Polje.this.setXO('X');
						Polje.this.igra.setPlayer('O');
						/*while(!*/Polje.this.getGraphics().drawImage(imgX, 0, 0,Polje.this.getWidth(),Polje.this.getHeight(), null);/*)
						{}*/
					}
					else if(Polje.this.igra.getPlayer()=='O')
					{
						Polje.this.setXO('O');
						Polje.this.igra.setPlayer('X');
						/*while(!*/Polje.this.getGraphics().drawImage(imgO, 0, 0,Polje.this.getWidth(),Polje.this.getHeight(), null);/*)
						{}*/
					}

						Polje.this.igra.getIgrac().setText(Polje.this.igra.getPlayer()+" je na potezu");

						if(pobeda('X') || pobeda('O'))
						{
							igra.getPobeda().getPobednik().setText("Pobedio je "+(XO=='X'?'X':'O'));
							igra.getPobeda().setVisible(true);
							brojac=0;
						}
						else if(brojac==9)
						{
							igra.getPobeda().getPobednik().setText("Nereseno je");
							igra.getPobeda().setVisible(true);
							brojac=0;
						}
					}
				}
				}
				);
	}
	

	private boolean pobeda(char pl)
	{
		if(igra.getPolja()[0][0].XO==pl && igra.getPolja()[0][1].XO==pl && igra.getPolja()[0][2].XO==pl) return true;
		if(igra.getPolja()[1][0].XO==pl && igra.getPolja()[1][1].XO==pl && igra.getPolja()[1][2].XO==pl) return true;
		if(igra.getPolja()[2][0].XO==pl && igra.getPolja()[2][1].XO==pl && igra.getPolja()[2][2].XO==pl) return true;
		if(igra.getPolja()[0][0].XO==pl && igra.getPolja()[1][0].XO==pl && igra.getPolja()[2][0].XO==pl) return true;
		if(igra.getPolja()[0][1].XO==pl && igra.getPolja()[1][1].XO==pl && igra.getPolja()[2][1].XO==pl) return true;
		if(igra.getPolja()[0][2].XO==pl && igra.getPolja()[1][2].XO==pl && igra.getPolja()[2][2].XO==pl) return true;
		if(igra.getPolja()[0][0].XO==pl && igra.getPolja()[1][1].XO==pl && igra.getPolja()[2][2].XO==pl) return true;
		if(igra.getPolja()[0][2].XO==pl && igra.getPolja()[1][1].XO==pl && igra.getPolja()[2][0].XO==pl) return true;
		return false;
	}
	
	public char getXO() {
		return XO;
	}

	public void setXO(char xO) {
		XO = xO;
	}

}
