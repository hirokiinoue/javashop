package xml;
import java.util.ArrayList;

import dao.VideogameDAO;
import articoli.*;

public class TestVideogame {
	public static void main(String argv[])
	{
		
			DBNegozioXML db = 
					new DBNegozioXML(
					"C:\\Users\\corso1\\Documents\\JAVAINTERMEDIO\\xml\\mediaworld.xml");

			VideogameDAO ludoteca = new VideogameDAO(db);
			
			ArrayList<Videogame> v = ludoteca.leggi();
			
			for (Videogame gioco:v)
				System.out.println(gioco.scheda());
			
			ArrayList<Articolo> ris = db.articoli("ram");
			
			for(int i=0;i<ris.size();i++)
				if(ris.get(i)!=null)
					System.out.println(ris.get(i).scheda());
			
			
		
	}
}