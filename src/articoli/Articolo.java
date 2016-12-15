package articoli;

import logger.Logger;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Articolo implements IArticolo, Cloneable {

	private String nome;
	private String descrizione;
	
	public Articolo()
	{
		//Costruttore vuoto
	}
	
	public Articolo(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void log()
	{
		Logger
			.getInstance()
			.add("Visualizzata scheda articolo " + nome);
	}
	
	public String scheda()
	{
		log();
		return nome+" "+descrizione;
	}
	

	public Articolo clone()
	{
		Object o = null;
		try
		{
			o = super.clone();
		}
		catch(Exception e)
		{
			o = null;
			System.out.println("ooops");
		}
		
		return (Articolo) o;
	}
	
	public double getPrezzo()
	{
		return 0;
	}
	
	public String toXML(){return "";}
	
	
}
