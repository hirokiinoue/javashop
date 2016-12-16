package dao;

import xml.IDBNegozio;
import articoli.Telefono;
import articoli.Articolo;

import java.util.ArrayList;

import org.w3c.dom.NodeList;

public class TelefonoDAO extends DAOsecondoLivello implements ITelefonoDAO {
	
	public TelefonoDAO(IDBNegozio dao){
		super(dao);	
	}
	
	public ArrayList<Telefono> leggi(){
		ArrayList<Telefono> ris = new ArrayList<Telefono>();
		ArrayList<Articolo> lista = this.dao.articoli("telefono");
		for(Articolo a:lista)
		{
			Telefono t = null;
			if(a instanceof Telefono)
				t = (Telefono) a;
				
			ris.add(t);
		}
		
		return ris;
	}
	
	public ArrayList<Telefono> leggi(String marca,
			int ramminima,
			double prezzomassimo,
			int memoriaminima,
			String sistemaoperativo,
			String LTE,
			String DUALSIM){
		
		ArrayList<Telefono> workList = new ArrayList<Telefono>();
		ArrayList<Telefono> ris = new ArrayList<Telefono>();
		workList = leggi();
		
		for(int i = 0; i<workList.size(); i++){
			if(!workList.get(i).getMarca().equals(marca) && !marca.equals(""))
				continue;
			if(workList.get(i).getRam().getGiga()>ramminima && ramminima>0)
				continue;
			if(workList.get(i).getPrezzo()<prezzomassimo && prezzomassimo>0)
				continue;
			if(workList.get(i).getMemoria().getCapacita()>memoriaminima && memoriaminima>0)
				continue;
			if(workList.get(i).getSistemaoperativo().equals(sistemaoperativo) && !sistemaoperativo.equals(""))
				continue;
			if(workList.get(i).getLTE().equals(LTE) && !LTE.equals(""))
				continue;
			if(workList.get(i).getDUALSIM().equals(DUALSIM) && !LTE.equals(""))
				continue;
			
			ris.add(workList.get(i));
		}
		return ris;
	}
	
}
