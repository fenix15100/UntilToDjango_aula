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
				StringBuffer buffercsv=new StringBuffer();
				
				do {
					String comilla2="\"\"";
					String comilla1="\"";
					String materia=comilla2;
					String profe=comilla2;
					String grupo=comilla2;
					final String mati_tarda=comilla2;
					String nivel=comilla2;
					String curso=comilla2;
					String letra=comilla2;
					String aula=comilla2;
					final String unk2=comilla2;
					String dia=comilla2;
					String franja=comilla2;
					final String unk3=comilla2;
					
					
					
					
					line=reader.readLine();
					linevector=line.split(",");
					
					if(linevector[1]!="")grupo=linevector[1];
					if(linevector[2]!="")profe=linevector[2];
					if(linevector[3]!="")materia=linevector[3];
					if(linevector[4]!="")aula=linevector[4];
					if(linevector[5]!="")dia=linevector[5];
					if(linevector[6]!="")franja=linevector[6];
					
					
					if(grupo.contains("ESO")) {
						nivel=comilla1+"ESO"+comilla1;
						curso=comilla1+String.valueOf(grupo.charAt(1))+comilla1;
						letra=comilla1+String.valueOf(grupo.charAt(grupo.length()-2))+comilla1;
						buffercsv.append(materia+","+profe+","+grupo+","+mati_tarda+","+nivel+","+curso+","+letra+","+aula+","+unk2+","+dia+","+franja+","+unk3+"\n");
						
						
					}else if(grupo.contains("BTX")) {
						nivel=comilla1+"BTX"+comilla1;
						curso=comilla1+String.valueOf(grupo.charAt(1))+comilla1;
						buffercsv.append(materia+","+profe+","+grupo+","+mati_tarda+","+nivel+","+curso+","+letra+","+aula+","+unk2+","+dia+","+franja+","+unk3+"\n");						
					}else{
						nivel=grupo;
						curso=grupo;
						buffercsv.append(materia+","+profe+","+grupo+","+mati_tarda+","+nivel+","+curso+","+letra+","+aula+","+unk2+","+dia+","+franja+","+unk3+"\n");						
					}
					
					
					
					
					
					
					
					
				}while(reader.readLine()!=null);
				
				System.out.println(buffercsv.toString());
					
					
						
				
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
