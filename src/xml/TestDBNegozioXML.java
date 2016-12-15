package xml;

import java.util.ArrayList;

import articoli.Articolo;

public class TestDBNegozioXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBNegozioXML db = 
				new DBNegozioXML(
				"C:\\Users\\corso1\\Documents\\JAVAINTERMEDIO\\xml\\mediaworld.xml");

		ArrayList<Articolo> ris1 = db.articoli("ram","magazzinolocale");

		for(int i = 0; i <ris1.size(); i++){
			System.out.println(ris1.get(i).scheda());
		}

		ArrayList<Articolo> ris2 = db.articoli("ram","magazzinoremoto");

		for(int i = 0; i <ris2.size(); i++){
			System.out.println(ris2.get(i).scheda());
		}
		
		System.out.println(db.sommaPrezzo("ram", "magazzinoremoto"));

	}

}
