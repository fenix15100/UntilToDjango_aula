import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

	private static Scanner teclado=new Scanner(System.in);
	private static BufferedReader reader;
	private static File f;
	public static void main(String[] args) {
		
		System.out.println("Que hacer 1.Convertir csv a formato kronowin 2.Unir dos horarios Kronowin 3.Convertir csvCiclos a formato kronowin(Chapu)");
		//int op=teclado.nextInt();
		int op=1;
		
		if(op==1) {
			
			System.out.println("Nombre fichero a convertir");
			//f=new File("horarios/"+teclado.next());
			f=new File(args[0]);
			
			try {
				reader=new BufferedReader(new FileReader(f));
				String line="";
				String [] linevector;
				
				do {
					String materia="";
					String profe="";
					String grupo="";
					final String mati_tarda="";
					String nivel="";
					String curso="";
					String letra="";
					String aula="";
					final String unk2="";
					String dia="";
					String franja="";
					final String unk3="";
					
					
					
					line=reader.readLine();
					linevector=line.split(",");
					grupo=linevector[1];
					profe=linevector[2];
					materia=linevector[3];
					aula=linevector[4];
					dia=linevector[5];
					franja=linevector[6];//
					System.out.println(line);
						
					
					
					
				}while(reader.readLine()!=null);
					
					
						
				
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			
			
			
			
		}else if(op==2) {
			
		}else if(op==3) {
			
		}
		else {
			System.out.println("Opcion no valida");
			System.exit(0);
		}
		
		
		

	}

}
