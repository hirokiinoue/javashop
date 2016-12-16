package dao;

import java.util.ArrayList;

import articoli.Articolo;
import articoli.VideogamePC;
import articoli.VideogameConsole;
import articoli.Videogame;
import xml.IDBNegozio;

public class VideogameDAO extends DAOsecondoLivello {

	public VideogameDAO(IDBNegozio dao){
		super(dao);
	}
	
	public ArrayList<Videogame> leggi(){
		ArrayList<Videogame> ris = new ArrayList<Videogame>();
		ArrayList<Articolo> lista = this.dao.articoli("videogame");
		for(Articolo a:lista){
			Videogame v;
			if(a instanceof VideogameConsole)
				v = (VideogameConsole) a;
			else
				v = (VideogamePC) a;
			ris.add(v);
		}
		
		return ris;
	}
}
