package dao;

import xml.IDBNegozio;
public abstract class DAOsecondoLivello {

	protected IDBNegozio dao;
	
	public DAOsecondoLivello(IDBNegozio dao){
		this.dao = dao;
	}
}
