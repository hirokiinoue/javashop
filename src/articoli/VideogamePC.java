package articoli;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VideogamePC extends Videogame {

	
	public VideogamePC(String nome, String descrizione, double prezzo)
	{
		super(nome,descrizione,prezzo,"PC");
	}

	
	public boolean compatibile(Articolo piattaforma)
	{
		return piattaforma instanceof PC;
	}
	
	@Override
	public String scheda() {
		// TODO Auto-generated method stub
		
		return getNome()+" "+getDescrizione()+" "+getPrezzo();
	}
	
	

}
