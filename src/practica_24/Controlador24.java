package practica_24;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Controlador24 implements ActionListener {
	
	
	//Variables de instancia
	private Vista24 miVista;
	
	public Controlador24(Vista24 v) {
		
		this.miVista = v;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == this.miVista.getValidar()) {
			
			valida();			
		}
		
		if(arg0.getSource() == this.miVista.getGenerar()) {

			genera();
		}
		
		
		if(arg0.getSource() == this.miVista.getLimpiar()) {
			
			limpia();
		}
		
	/*	if(arg0.getSource() == this.miVista.getTablero()[f][c]) {
			
			this.miVista.getTablero()[f][c].setForeground(Color.BLACK);
			
		}*/
		
		
	}
	
	
	
	/**
	 * Método que resuelve el Cuadrado Mágico
	 */
	private void genera() {
		
		int [][]magico = ModeloCuadradoMagico.cuadradoMagico(this.miVista.getDimension()); //genero una matriz con todos los números
		
		for(int f=0; f<magico.length; f++) {
			
			for(int c=0; c<magico[f].length; c++) {
				
				this.miVista.getTablero()[f][c].setText(String.valueOf(magico[f][c]));
			}			
		}
		
	}//end genera
	
	
	/**
	 * Método pone en blanco el cuadrado mágico
	 */
	private void limpia() {
		
		for(int f=0; f<this.miVista.getDimension(); f++) {
			
			for(int c=0; c<this.miVista.getDimension(); c++) {
				
				this.miVista.getTablero()[f][c].setText("");
			}
		}		
	}//end limpia
	
	
	
	private void valida() {
		
		int magico [][] = ModeloCuadradoMagico.cuadradoMagico(this.miVista.getDimension());
		int numUsuario, numMagico;
		byte contadorFallos =0;
		
		try {
			
			for(int f=0; f<this.miVista.getDimension(); f++) {
				
				for(int c=0; c<this.miVista.getDimension(); c++) {
					
					if(!this.miVista.getTablero()[f][c].getText().equals("")) { //es distinto de espacio en blanco
						
						numUsuario= Integer.parseInt(this.miVista.getTablero()[f][c].getText()); //intenta convertir a entero. Si no puede salta la excepcion
						numMagico= magico[f][c];
						
						if(numUsuario!= numMagico) { //si el nº introducido por el usuario es distinto al que hay en esa posición en el Mágico
							this.miVista.getTablero()[f][c].setForeground(Color.RED);
							contadorFallos++; //si hay un fallo, luego NO es mágico
						}
						else
							this.miVista.getTablero()[f][c].setForeground(Color.BLACK); //es correcto, se pone en negro
						
					}//end if ""
					else
						contadorFallos++; //hay uno vacío, luego NO es mágico
					
				}//end for c
			}//end for f
			
			if(contadorFallos ==0) {
				//JOptionPane.showMessageDialog(this.miVista, "El cuadrado ES MÁGICO", "ENHORABUENA", JOptionPane.INFORMATION_MESSAGE);				
				JOptionPane.showMessageDialog(this.miVista, "El cuadrado ES MÁGICO", "ENHORABUENA", JOptionPane.INFORMATION_MESSAGE, this.miVista.getIcono());
							
			}
				
			else
				JOptionPane.showMessageDialog(this.miVista, "El cuadrado NO es Mágico", "INTÉNTALO OTRA VEZ", JOptionPane.ERROR_MESSAGE);
			
		}
		catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this.miVista, "Debes introducir números", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	
	
	
	

}//end Controlador24
