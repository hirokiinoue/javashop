package xml;
import articoli.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;

public class DBNegozioXML implements IDBNegozio{
	//Una helper class.
	//Restituisce un Document, vale a dire un documento 
	//Ci sono dei problemi... dei problemi di risorse, ma per ora...
	Document doc=null;
	
	String KeywordSommaPrezzo   = "prezzo";
	String KeywordSommaQuantita = "quantita";
	
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

	// restituisce numero di Articoli
	public int numeroArticoli(String tipo)
	{
		return doc.getElementsByTagName(tipo).getLength();
	}
	
	// restituisce Articoli
	public ArrayList<Articolo> articoli(String tipo)
	{
		ArrayList<Articolo> ris = new ArrayList<Articolo>();
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			ris.add(converti(lista.item(i)));
			
		return ris;
		
	}
	
	public ArrayList<Articolo> articoli(String tipo, String padre) {
		ArrayList<Articolo> ris = new ArrayList<Articolo>();
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i = 0; i<lista.getLength(); i++)
			if(lista.item(i).getParentNode().getNodeName().equals(padre))
				ris.add(converti(lista.item(i)));
		
		return ris;
	}
	
	//
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
		case "processore":
			ris = this.processoreDaXML(n);
			break;
		case "hd":
			ris = this.hdDaXML(n);
			break;
		case "telefono":
			ris = this.telefonoDaXML(n);
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
	
	private Ram ramDaXML(Node n){
		Ram ris=null;
		
		String nome = "";
		String descrizione = "";
		double prezzo = 0;
		String tipo = "";
		int    giga = 0;
		
		NodeList campi = n.getChildNodes();
		
		for (int i = 0; i<campi.getLength(); i++){
			switch(campi.item(i).getNodeName())
			{
			case "titolo":
				nome = campi.item(i).getTextContent();
				break;
			case "descrizione":
				descrizione = campi.item(i).getTextContent();
				break;
			case "prezzo":
				prezzo = Integer.parseInt(campi.item(i).getTextContent());
			case "tipo":
				tipo = campi.item(i).getTextContent();
				break;
			case "giga":
				giga = Integer.parseInt(campi.item(i).getTextContent());
				break;
				
			default:
			}			
		}

		ris = new Ram(nome,descrizione,prezzo,giga,tipo);

		return ris;
	}
	
	private Processore processoreDaXML(Node n){
		
		Processore ris = null;
		
		String nome = "";
		String descrizione = "";
		double prezzo = 0;
		int benchmark = 0;
		
		NodeList campi = n.getChildNodes();
		
		for (int i = 0; i<campi.getLength(); i++){
			switch(campi.item(i).getNodeName())
			{
			case "titolo":
				nome = campi.item(i).getTextContent();
				break;
			case "descrizione":
				descrizione = campi.item(i).getTextContent();
				break;
			case "prezzo":
				prezzo = Integer.parseInt(campi.item(i).getTextContent());
				break;
			case "banchmark":
				benchmark = Integer.parseInt(campi.item(i).getTextContent());
				break;
			default:
			}
		}
		
		ris = new Processore(nome,descrizione,prezzo,benchmark);
		
		return ris;
	}
	
	private Hd hdDaXML(Node n){
		
		Hd ris = null;
		
		String nome = "";
		String descrizione = "";
		double prezzo = 0;
		int	   capacita = 0;
		
		NodeList campi = n.getChildNodes();
		
		for (int i = 0; i<campi.getLength(); i++){
			switch(campi.item(i).getNodeName()){
			
			case "titolo":
				nome = campi.item(i).getTextContent();
				break;
			case "descrizione":
				descrizione = campi.item(i).getTextContent();
				break;
			case "prezzo":
				prezzo = Integer.parseInt(campi.item(i).getTextContent());
				break;
			case "capacita":
				capacita = Integer.parseInt(campi.item(i).getTextContent());
				break;
			default:
			}
		}
		return ris;
	}
	
	private Telefono telefonoDaXML(Node n){
		
		Telefono ris = null;
		
		String nome = "";
		String descrizione = "";
		String marca = "";
		int ram = 0;
		double prezzo = 0;
		int memoria = 0;
		String sistemaoperativo = "";
		String LTE = "";
		String DUALSIM = "";
		
		NodeList campi = n.getChildNodes();
		
		for (int i = 0; i<campi.getLength(); i++){
			switch(campi.item(i).getNodeName())	{
			case "titolo":
				nome = campi.item(i).getTextContent();
				break;
			case "descrizione":
				descrizione = campi.item(i).getTextContent();
				break;
			case "marca":
				marca = campi.item(i).getTextContent();
				break;
			case "ram":
				ram = Integer.parseInt(campi.item(i).getTextContent());
				break;
			case "prezzo":
				prezzo = Integer.parseInt(campi.item(i).getTextContent());
				break;
			case "memoria":
				memoria = Integer.parseInt(campi.item(i).getTextContent());
				break;
			case "sistemaoperativo":
				sistemaoperativo = campi.item(i).getTextContent();
				break;
			case "lte":
				LTE = campi.item(i).getTextContent();
				break;
			case "dualsim":
				DUALSIM = campi.item(i).getTextContent();
				break;
			default:
			}		
		}

		ris = new Telefono(nome,
							descrizione,
							marca,
							new Ram("SAMUSUNG","",50,ram,"DDR3"),
							prezzo,
							new Hd("SAMUSUNG","",50,memoria),
							sistemaoperativo,
							LTE,
							DUALSIM);
		
		return ris;
	}
	
	public double sommaPrezzo(String tipo){

		double somma = 0;
		
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			if(lista.item(i).getNodeName().equals(KeywordSommaPrezzo))
					somma+=Integer.parseInt(lista.item(i).getTextContent());
			
		return somma;
	
	}

	public double sommaPrezzo(String tipo, String padre){

		double somma = 0;
		
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			if(lista.item(i).getParentNode().getNodeName().equals(padre))
				if(lista.item(i).getNodeName().equals(KeywordSommaPrezzo))
					somma+=Integer.parseInt(lista.item(i).getTextContent());
			
		return somma;	
	}

	public int sommaQuantita(String tipo){

		int somma = 0;
		
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			if(lista.item(i).getNodeName().equals(KeywordSommaQuantita))
					somma+=Integer.parseInt(lista.item(i).getTextContent());
			
		return somma;
	
	}

	public int sommaQuantita(String tipo, String padre){

		int somma = 0;
		
		NodeList lista = doc.getElementsByTagName(tipo);
		for(int i=0;i<lista.getLength();i++)
			if(lista.item(i).getParentNode().getNodeName().equals(padre))
				if(lista.item(i).getNodeName().equals(KeywordSommaQuantita))
					somma+=Integer.parseInt(lista.item(i).getTextContent());
			
		return somma;	
	}
}