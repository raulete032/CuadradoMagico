package practica_24;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialogo24 extends JDialog implements ActionListener {

	private static final long serialVersionUID = -8094315539433071880L;
	
	//Variables de instancia
	private JComboBox<Integer> combo;
	private JButton comenzar, salir;
	private int dimension;
	
	
	
	public Dialogo24 () {
		
		this.setModal(true);
		this.setTitle("Dimensiones del cuadrado");
		this.setLayout(new BorderLayout(20, 20));
		
		Font fuente = new Font ("Times New Roman", Font.ITALIC, 18);
		
		//Parte Norte
		JPanel pInfo = new JPanel(new GridLayout(3, 1));
		
		JLabel info1 = new JLabel("A continuación debe seleccionar la dimensión que ", JLabel.CENTER);
		JLabel info2 = new JLabel("tendrá el cuadrado mágico, dicha dimensión deberá ", JLabel.CENTER);
		JLabel info3 = new JLabel("ser un número entero positiov e impar.", JLabel.CENTER);
		
		info1.setFont(fuente);
		info2.setFont(fuente);
		info3.setFont(fuente);
		
		pInfo.add(info1);
		pInfo.add(info2);
		pInfo.add(info3);
		
		//Parte Centro
		JPanel pCentro = new JPanel();
		JLabel etiq = new JLabel ("Seleccione la dimensión del cuadrado");
		
		etiq.setFont(fuente);
		
		Integer [] array = {3, 5, 7, 9, 11, 13, 15};
		
		this.combo = new JComboBox<Integer>(array);
		
		pCentro.add(etiq);
		pCentro.add(combo);
		
		//Parte Sur
		JPanel pSur = new JPanel();
		
		this.comenzar = new JButton("Comenzar");
		this.salir = new JButton("Salir");
		comenzar.setSize(20, 50);
		salir.setSize(20, 50);
		
		pSur.add(comenzar);
		pSur.add(salir);
		
		
		this.add(pInfo, BorderLayout.NORTH);
		this.add(pCentro, BorderLayout.CENTER);
		this.add(pSur, BorderLayout.SOUTH);
		
		comenzar.addActionListener(this);
		salir.addActionListener(this);
		
		
		this.setPreferredSize(new Dimension(450, 220));
		this.setLocation(700, 400);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		
		
		
	}// end constructor


	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == this.salir)
			System.exit(0);
		
		if(arg0.getSource() == this.comenzar) {
			
			this.dimension = (int)this.combo.getSelectedItem();
			
	//		dimension = ((Integer)combo.getSelectedItem()).intValue();
			
			this.setVisible(false);
		}
		
	}




	//GETTERS
	public int getDimension() {return dimension;}


	
	
	
	
	
	
	
	

}//end class Dialogo
