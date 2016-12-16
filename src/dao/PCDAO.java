package dao;

import xml.IDBNegozio;

public class PCDAO extends DAOsecondoLivello {

	public PCDAO(IDBNegozio dao){
		super(dao);
	}
	
	public ArrayList<PC> pc(){
		ArrayList<PC> ris = new ArrayList<PC>();
		ArrayList<Articolo> lista = this.dao.articoli("pc");
		return this.dao.articoli("pc");
	}
}
