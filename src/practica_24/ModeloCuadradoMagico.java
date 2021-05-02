package practica_24;

public class ModeloCuadradoMagico {
	

/**
 * Método que resuelve el cuadrado mágico
 * @param n
 * @return
 */
public static int [][] cuadradoMagico(int n){
		
		if(n%2==0) { //compruebo si n es impar
			return null;
		}
		
		//creo la matriz		
		int [][] magico = new int [n][n];
		
		magico[0][n/2]=1; //le asigno el 1 a su posición fija
		
		int f=0;
		int c= n/2;
		
		for(int i= 2; i<=Math.pow(n, 2); i++) {			
			
			if(((i-1)%n)!=0) { //si el anterior número NO es múltiplo de n				
				
				if(f-1<0) { //si estoy en la primera fila (NO puedo hacer f-1)
					f=magico.length-1;  //f ahora es la última fila
					
					if(c+1>magico[0].length-1) { //si estoy en la última columna (NO puedo hacer c+1);
						c=0; //c ahora es la primera columna
						
						magico[f][c]= i;					
					}
					else { //aquí solo puedo hacer c+1
						magico[f][c+1]=i;
						c++;
					}				
				}
				else {//si NO estoy en la primera fila (puedo hacer f-1)
					
					if(c+1>magico[0].length-1) { //si estoy en la última columna (NO puedo hacer c+1)
						c=0;						
						magico[f-1][c]=i;
						f--;
					}
					else { // aquí puedo hacer f-1 y c+1
						magico[f-1][c+1]=i;
						c++;
						f--;
					}					
				}				
			}
			else {	//si el anterior es múltiplo de n	(c se queda igual)		
				if((f+1)>magico.length-1) { //si estoy en la última fila  (NO puedo hacer f-1)
					f=0;					
					magico[f][c]=i;
				}
				else { //aquí puedo hacer f+1
					magico[f+1][c]=i;
					f++;
				}				
			}			
		}				
		return magico;		
	}
	
	
	
	

}
