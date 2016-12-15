package articoli;

public class VideogameConsole extends Videogame {

	public VideogameConsole(String nome, String descrizione, double prezzo, String piattaforma)
	{
		super(nome,descrizione,prezzo,piattaforma);
	}

	public String scheda()
	{
		return toString();
	}
	
	public boolean compatibile(Articolo piattaforma)
	{
		return (piattaforma.getNome()==getPiattaforma());
	}
		
	@Override
	public String toString() {
		return "VideogameConsole [getPiattaforma()=" + getPiattaforma()
				+ ", getPrezzo()=" + getPrezzo() + ", getNome()=" + getNome()
				+ ", getDescrizione()=" + getDescrizione() + "]";
	}
	
	
	
}

