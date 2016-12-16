package dao;

import articoli.Telefono;
import java.util.ArrayList;

public interface ITelefonoDAO {

	public ArrayList<Telefono> leggi();
	
	public ArrayList<Telefono> leggi(String marca,
					int ramminima,
					double prezzomassimo,
					int memoriaminima,
					String sistemaoperativo,
					String LTE,
					String DUALSIM);
}
