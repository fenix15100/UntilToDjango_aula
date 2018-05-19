import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Start {

	private static Scanner teclado=new Scanner(System.in);
	private static BufferedReader reader;
	private static File f;
	
	public static void main(String[] args) {
		
		//Pide el nombre del fichero a convertir
			System.out.println("Nombre fichero a convertir");
			f=new File(teclado.next());
			
			int i=0;
			
			try {
				
				//Leo el fichero linea a linea
				
				reader=new BufferedReader(new FileReader(f));
				String line="";
				String [] linevector;
				StringBuffer buffercsv=new StringBuffer();
				
				
				while((line=reader.readLine())!=null) {
					
					//Inicializo campos del CSV
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
					
					
				
					//Leo linea y extraigo campos
					linevector=line.split(",");
					
					if(linevector[1]!="")grupo=linevector[1];
					if(linevector[2]!="")profe=linevector[2];
					if(linevector[3]!="")materia=linevector[3];
					if(linevector[4]!="")aula=linevector[4];
					if(linevector[5]!="")dia=linevector[5];
					if(linevector[6]!="")franja=linevector[6];
					
					
					//Creo campos nuevos a partir del campo grupo
					
					if(grupo.contains("SMX")) {
						nivel=comilla1+"SMX"+comilla1;
						curso=comilla1+String.valueOf(grupo.charAt(grupo.length()-3))+comilla1;
						letra=comilla1+String.valueOf(grupo.charAt(grupo.length()-2))+comilla1;
							
					}else if(grupo.contains("DAW")) {
						nivel=comilla1+"DAW"+comilla1;
						curso=comilla1+String.valueOf(grupo.charAt(grupo.length()-2))+comilla1;
					}else if(grupo.contains("ASIX")) {
					nivel=comilla1+"ASIX"+comilla1;
					curso=comilla1+String.valueOf(grupo.charAt(grupo.length()-2))+comilla1;
					
					}else{
						nivel=grupo;
						curso=grupo;
					}
					
					//Monto los campos en el orden correcto dentro de un buffer
					buffercsv.append(materia+","+profe+","+grupo+","+mati_tarda+","+nivel+","+curso+","+letra+","+aula+","+unk2+","+comilla1+dia+comilla1+","+comilla1+franja+comilla1+","+unk3+"\n");
					
					System.out.println(grupo+"index:"+i);
					i++;
					
					
					
						
				}
				reader.close();
				
				//Escribo el buffer en el fichero de salida
				BufferedWriter writer=new BufferedWriter(new FileWriter("output.csv"));
				writer.write(buffercsv.toString());
				writer.close();
				
							
				
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
				

	}

}
