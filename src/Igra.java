import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Igra extends Frame{

	private Polje polja[][];
	private Panel gornji;
	private Panel donji;
	private Label igrac;
	private Pobeda pobeda;
	private char player='X';
	
	public Igra()
	{
		this.setTitle("Tic Tac Toe");
		this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-200 , 400, 400);
		polja=new Polje[3][3];
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e)
			{
		         dispose();
			}
		});
		this.dodajKomponente();
		this.setResizable(false);
		this.setVisible(true);
		pobeda=new Pobeda(this,true);
		
	}
	
	class Pobeda extends Dialog
	{

		private Button dugme;
		private Label pobednik;
		
		public Pobeda(Frame owner, boolean modal) {
			super(owner, modal);
			this.setBounds(Igra.this.getX()+Igra.this.getWidth()/2-100, Igra.this.getY()+Igra.this.getHeight()/2-50,200,100);
			dugme=new Button("Zapocni novu");
			pobednik=new Label("");
			pobednik.setAlignment(Label.CENTER);
			pobednik.setFont(new Font("Arial",Font.BOLD,20));
			dugme.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Igra.this.dispose();
					new Igra();
				}
			});
			
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					Igra.this.dispose();
				}
			});
			this.setLayout(new GridLayout(2, 1));
			this.add(pobednik);
			this.add(dugme);
			this.setVisible(false);
		}

		public Label getPobednik() {
			return pobednik;
		}
		
		
		
	}

	public void dodajKomponente() {
		gornji=new Panel();
		gornji.setBackground(Color.WHITE);
		igrac=new Label(player+" je na potezu");
		igrac.setForeground(Color.RED);
		igrac.setFont(Font.decode("Helvetica-BOLD-24"));
		gornji.add(igrac);
		
		this.add(gornji,BorderLayout.NORTH);
		
		donji=new Panel(new GridLayout(3,3,2,2));
		donji.setBackground(Color.BLACK);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				polja[i][j]=new Polje(this);
				polja[i][j].setBackground(Color.WHITE);
				donji.add(polja[i][j]);
			}
		}
		
		this.add(donji,BorderLayout.CENTER);
	}
	
	public char getPlayer() {
		return player;
	}
	
	public void setPlayer(char c) {
		// TODO Auto-generated method stub
		player=c;
	}

	public Label getIgrac() {
		return igrac;
	}
	
	public Polje[][] getPolja()
	{
		return this.polja;
	}

	public static void main(String[] args)
	{
		new Igra();
	}

	public Pobeda getPobeda() {
		return pobeda;
	}

}
