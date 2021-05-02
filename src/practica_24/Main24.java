package practica_24;


import javax.swing.JFrame;

public class Main24 {

	public static void main(String[] args) {

		
		Vista24 miVista = new Vista24();
		
		JFrame ventana = new JFrame();
		Controlador24 ctr = new Controlador24(miVista);
		miVista.añadeControl(ctr);
		
		
		
		ventana.setContentPane(miVista);
		
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.pack();		
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
