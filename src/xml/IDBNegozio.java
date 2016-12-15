package xml;

import java.util.ArrayList;
import articoli.Articolo;

public interface IDBNegozio {

	public int numeroArticoli(String tipo);
	
	public ArrayList<Articolo> articoli(String tipo);
	public ArrayList<Articolo> articoli(String tipo, String padre);
	
	public double sommaPrezzo(String tipo);
	public double sommaPrezzo(String tipo, String padre);
	
	public int sommaQuantita (String tipo);
	public int sommaQuantita (String tipo, String padre);
}
