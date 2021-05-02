package practica_24;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Vista24 extends JPanel {

	private static final long serialVersionUID = -2077570115186163239L;
	
	
	//Variables de instancia
	private JTextField tablero [][];
	private JButton validar, generar, limpiar;
	private int dimension;
	private ImageIcon icono = new ImageIcon("recursos/baile.gif");
	
	
	/**
	 * Constructor
	 */
	public Vista24() {
		
		Dialogo24 d = new Dialogo24();
	
		dimension = d.getDimension();
		
		JPanel p1 = new JPanel (new BorderLayout(20, 20));
	//	this.setLayout(new BorderLayout(20, 20));
		
		JPanel pNorte = preparaPanelNorte();
		JPanel pCentro = preparaPanelCentro();
		JPanel pSur = preparaPanelSur();
	
		
		
		
		p1.add(pNorte, BorderLayout.NORTH);
		p1.add(pCentro, BorderLayout.CENTER);
		p1.add(pSur, BorderLayout.SOUTH);
	
		this.add(p1);
		
		
		
	}//end Constructor
	
	
	public JTextField[][] getTablero() {return tablero;}
	public JButton getValidar() {return validar;}
	public JButton getGenerar() {return generar;}
	public JButton getLimpiar() {return limpiar;}
	public int getDimension() {return dimension;}
	public ImageIcon getIcono() {return icono;}


	/**
	 * Método que prepara el panel del Norte
	 * @return
	 */
	private JPanel preparaPanelNorte() {
		
		JPanel p = new JPanel();
		JLabel etiq = new JLabel("Cuadrado mágico de " + this.dimension);
		Font fuente = new Font("Times New Roman", Font.BOLD, 20);
		
		etiq.setFont(fuente);
		
		p.add(etiq);
		
		return p;
	}
	
	
	/**
	 * Método que prepara el panel del Centro
	 * @return
	 */
	private JPanel preparaPanelCentro() {
		
		JPanel p = new JPanel();
		JPanel p1 = new JPanel(new GridLayout(dimension, dimension));
		
		this.tablero = new JTextField [dimension][dimension];
		
		for(int f=0; f<tablero.length; f++) {
			
			for(int c=0; c<tablero[f].length; c++) {
				
				JTextField tf = new JTextField(2);
				
				tf.setBorder(new BevelBorder(BevelBorder.RAISED));
				
				tablero[f][c] = tf;
				
				p1.add(tf);
				
			}
		}
		
		p.add(p1);
		
		return p;
	}


	/**
	 * Método que prepara el panel del Sur
	 * @return
	 */
	private JPanel preparaPanelSur() {
		
		JPanel p = new JPanel();
		this.validar = new JButton("Validar");
		this.generar = new JButton("Generar");
		this.limpiar = new JButton("Limpiar");
		
		p.add(validar);
		p.add(generar);
		p.add(limpiar);

		return p;
	}
	
		
	
	/**
	 * Método que añade el control
	 * @param ctr
	 */
	public void añadeControl(Controlador24 ctr) {
		
		this.validar.addActionListener(ctr);
		this.generar.addActionListener(ctr);
		this.limpiar.addActionListener(ctr);
		
	}
	
	
	
	
	

}//end Vista
