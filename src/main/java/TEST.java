import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TEST {

	public static void main(String[] args) {

		ArrayList<Autor> AutorenAL = new ArrayList<Autor>();
		ArrayList<Buch> BuecherAL = new ArrayList<Buch>();
		ArrayList<Zeitschrift> ZeitSchAL = new ArrayList<Zeitschrift>();
		
		String Pfad= "C:\\Users\\Frank\\Desktop\\test\\data\\";
		String AutorenDatei= "autoren.csv";
		String BuecherDatei= "buecher.csv";
		String ZeitSDatei= "zeitschriften.csv";
		
		File file = new File(Pfad+AutorenDatei);
		File file2 = new File(Pfad+BuecherDatei);
		File file3 = new File(Pfad+ZeitSDatei);
		
	    try{
			Scanner scan = new Scanner(file);
			
			while (scan.hasNext()){				
				String Zeile = scan.next();
				String[] EinzelWerte = Zeile.split(";");
				Autor TMPAutor = new Autor();
				TMPAutor.email =EinzelWerte[0];
				TMPAutor.vorname = EinzelWerte[1];
				TMPAutor.nachname = EinzelWerte[2];
				AutorenAL.add(TMPAutor);
				}
			scan.close();
			}
		catch(FileNotFoundException e){
			e.printStackTrace();
			}
	    
	    try{
			Scanner scan = new Scanner(file2);
			
			while (scan.hasNext()){				
				String Zeile = scan.nextLine();
				String[] EinzelWerte = Zeile.split(";");
				Buch TMPBuch = new Buch();
				TMPBuch.Titel =EinzelWerte[0];
				TMPBuch.ISBN = EinzelWerte[1];
				TMPBuch.Autoren = EinzelWerte[2];
				TMPBuch.Beschreibung = EinzelWerte[3];
				BuecherAL.add(TMPBuch);
				}
			scan.close();
			}
		catch(FileNotFoundException e){
			e.printStackTrace();
			}
	    
	    try{
			Scanner scan = new Scanner(file3);
			
			while (scan.hasNext()){				
				String Zeile = scan.nextLine();
				String[] EinzelWerte = Zeile.split(";");
				Zeitschrift TMPZeitS = new Zeitschrift();
				TMPZeitS.Titel =EinzelWerte[0];
				TMPZeitS.ISBN = EinzelWerte[1];
				TMPZeitS.Autoren = EinzelWerte[2];
				TMPZeitS.Datum = EinzelWerte[3];
				ZeitSchAL.add(TMPZeitS);
				}
			scan.close();
			}
		catch(FileNotFoundException e){
			e.printStackTrace();
			}
		
//Ausgabe der Autoren
	    for(int i=0; i<AutorenAL.size(); i++)
	  		{
			System.out.print(AutorenAL.get(i).email+" ");System.out.print(AutorenAL.get(i).vorname+" ");System.out.println(AutorenAL.get(i).nachname);
	  		}
	    
//Ausgabe aller Bücher mit allen Details
	    for(int i=0; i<BuecherAL.size(); i++)
	  		{
			System.out.print(BuecherAL.get(i).Titel+" ");System.out.print(BuecherAL.get(i).ISBN+" ");System.out.print(BuecherAL.get(i).Autoren+" ");System.out.println(BuecherAL.get(i).Beschreibung);
	  		}	 
	    
//Ausgabe aller Zeitschriften mit allen Details
	    for(int i=0; i<ZeitSchAL.size(); i++)
	  		{
			System.out.print(ZeitSchAL.get(i).Titel+" ");System.out.print(ZeitSchAL.get(i).ISBN+" ");System.out.print(ZeitSchAL.get(i).Autoren+" ");System.out.println(ZeitSchAL.get(i).Datum);
	  		}	    

//Suche nach ISBN in BucherAL	    
	    for(int i=0; i<BuecherAL.size(); i++)
			{	
	    	if(BuecherAL.get(i).ISBN.equals("2365-8745-7854"))
    			{
	    		System.out.print(BuecherAL.get(i).Titel+" ");System.out.print(BuecherAL.get(i).ISBN+" ");System.out.print(BuecherAL.get(i).Autoren+" ");System.out.println(BuecherAL.get(i).Beschreibung);
    			}		    
			}
	    
//Suche nach ISBN in ZeitschAL	    
	    for(int i=0; i<ZeitSchAL.size(); i++)
  			{	
	    	if(ZeitSchAL.get(i).ISBN.equals("2365-8745-7854"))
	    		{
	    		System.out.print(ZeitSchAL.get(i).Titel+" ");System.out.print(ZeitSchAL.get(i).ISBN+" ");System.out.print(ZeitSchAL.get(i).Autoren+" ");System.out.println(ZeitSchAL.get(i).Datum);
	    		}		    
  			}
	    
	    
	}
	

}


