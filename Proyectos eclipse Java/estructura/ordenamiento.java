package estructura;
import java.util.Scanner;
public class ordenamiento {
	
	Scanner jk=new Scanner(System.in);
	void leervector(int []vector) {
		for(int i=0;i<vector.length;i++) {
		  System.out.println("Dato en la posicion"+(i+1));
		   vector[i]=jk.nextInt();
		}
	}
	void imprimirvector(int []vector) {
		for(int i=0;i<vector.length;i++) {
			  System.out.print(" "+vector[i]); 
			}
	}
	public int[] InserccionAs(int [] vector) {
		int intera=0;
		int op=0;
		for(int i=1;i<vector.length;i++) {
			int j=i-1;
			int aux=vector[i];
			intera++;
			while(j>=0 && aux<vector[j]) {
				vector[j+1]=vector[j];
				j--;
				op=op+2;
			}
			vector[j+1]=aux;
			op=op+1;
			for(int n=0;n<vector.length;n++) {
				System.out.printf(vector[n]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Interaciones: "+intera);
		System.out.println("Operaciones: "+op);
		return vector;
	}
	public int[] InserccionDes(int [] vector) {
		int intera=0;
		int op=0;
		for(int i=0;i<vector.length;i++) {
			int j=i-1;
			int aux=vector[i];
			intera++;
			while(j>=0 && aux>vector[j]) {
				vector[j+1]=vector[j];
				j--;
				op=op+2;
			}
			vector[j+1]=aux;
			op=op+1;
			for(int n=0;n<vector.length;n++) {
				System.out.printf(vector[n]+" ");
			}
			System.out.println();
		}
		System.out.println("Interaciones: "+intera);
		System.out.println("Operaciones: "+op);
		return vector;
	}
	
	public int [] BurbujaAs(int[] vector) {
	
		int intera=0;
		int op=0;
		for( int i=0;i<vector.length-1;i++){
			 intera++;
			for(int j=i;j<vector.length;j++){
			 intera++;
			  if (vector[i]>vector[j]){
			    int aux=vector[i];
			   vector[i]=vector[j];
			   vector[j]=aux;
			   op=op+3;
			    for(int l=0;l<vector.length;l++) {
				 System.out.printf(vector[l]+" ");
			}
			System.out.println("");
			}
		
		}
			
	}
		System.out.println("interaciones: "+intera);
		System.out.println("Operaciones: "+op);
	return vector;
}

	public int [] BurbujaDes(int[] vector) {
		
		int intera=0;
		int op=0;
		for( int i=0;i<vector.length-1;i++){
			  intera++;
			for(int j=i;j<vector.length;j++){
			  intera++;
			   if (vector[i]<vector[j]){
			  int aux=vector[i];
			  vector[i]=vector[j];
			  vector[j]=aux;
			  op=op+3;
			for(int l=0;l<vector.length;l++) {
				System.out.printf(vector[l]+" ");
			}
			System.out.println("");
			}
		
		}
			
	}
		System.out.println("interaciones: "+intera);
		System.out.println("operaciones: "+op);
	return vector;
}
	public int [] seleccionAs(int A[]) {
        int i, j, menor, pos, aux;
        int op=0;
        int intera=0;
        for (i = 0; i < A.length - 2; i++) { 
              menor = A[i]; 
              pos = i; 
              intera++;
              op=op+2;
              for (j = i + 1; j < A.length; j++){ 
            	  intera++;
                    if (A[j] < menor) { 
                        menor = A[j]; 
                        pos = j;
                        op=op+2;
                        
                    }
              }
              if (i != menor){ 
                  aux = A[i];
                  A[i] = A[pos];
                  A[pos] = aux;
                  op=op+3;
                  for(int y=0;y<A.length;y++) {
                	  System.out.printf(A[y]+" ");
                  }
                  System.out.println();
              }
        }
        System.out.println("Operaciones: "+op);
        System.out.println("Interaciones: "+intera);
        return A;
}
	public int [] seleccionDes(int A[]) {
        int i, j, menor, pos, aux;
        int op=0;
        int intera=0;
        for (i = 0; i < A.length - 2; i++) { 
              menor = A[i]; 
              pos = i; 
              op=op+2;
              intera++;
              for (j = i + 1; j < A.length; j++){ 
            	  intera++;
                    if (A[j] > menor) { 
                        menor = A[j]; 
                        pos = j;
                        op=op+2;
                    }
              }
              if (i != menor){ 
                  aux = A[i];
                  A[i] = A[pos];
                  A[pos] = aux;
                  op=op+3;
                  for(int y=0;y<A.length;y++) {
                	  System.out.printf(A[y]+" ");
                  }
                  System.out.println();
              }
        }
        System.out.println("Operaciones: "+op);
        System.out.println("Interaciones: "+intera);
        return A;
}
}
