package xml;
import articoli.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import articoli.VideogamePC;

import java.io.File;
import java.util.ArrayList;

public class DBNegozioXML {
	//Una helper class.
	//Restituisce un Document, vale a dire un documento 
	//Ci sono dei problemi... dei problemi di risorse, ma per ora...
	Document doc=null;
	
	public DBNegozioXML(String percorso) 
	{
		try 
		{
			File fXmlFile = new File(percorso);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public int numeroArticoli(String tipo)
	{
		return doc.getElementsByTagName(tipo).getLength();
	}
	
	public ArrayList<Articolo> articoli(String tipo)
	{
		ArrayList<Articolo> ris = new ArrayList<Articolo>();
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			ris.add(converti(lista.item(i)));
			
		return ris;
		
	}
	

	private Articolo converti(Node n)
	{
		Articolo ris = null;
		switch(n.getNodeName())
		{
		case "videogame":
			ris = this.videogameDaXML(n);
			break;
		case "ram":
			ris = this.ramDaXML(n);
			break;
		default:
		}
		//Fine switch
			return ris;
	}
	

	private Videogame videogameDaXML(Node n)
	{
		Videogame ris=null;
		String nome = "";
		String descrizione = "";
		int prezzo = 0;
		String piattaforma = "";
		//Cambia il proprio stato
		NodeList campi = n.getChildNodes();
		
		for(int k=0;k<campi.getLength();k++)
		{
			switch(campi.item(k).getNodeName())
			{
			case "titolo":
				nome = campi.item(k).getTextContent();
				break;
			case "descrizione":
				descrizione = campi.item(k).getTextContent();
				break;
			case "prezzo":
				prezzo = Integer.parseInt(campi.item(k).getTextContent());
				break;
			case "piattaforma":
				piattaforma = campi.item(k).getTextContent();
				break;
				
			default:
			}
		}
		
		if(piattaforma.equals("") || piattaforma.equals("PC")) 
			ris = new VideogamePC(nome,descrizione,prezzo);
		else
			ris = new VideogameConsole(nome,descrizione,prezzo,piattaforma);
		
		return ris;
	}
	
}