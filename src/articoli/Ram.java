package articoli;

public class Ram extends Articolo {

	double prezzo;
	String tipo;
	int giga=0;
		
	public Ram(String nome, String descrizione, double prezzo, int giga,String tipo) {
		super(nome, descrizione);
		this.prezzo = prezzo;
		this.tipo = tipo;
		this.giga = giga;
	}

	@Override
	public double getPrezzo() {
		// TODO Auto-generated method stub
		return prezzo;
	}

	@Override
	public String scheda() {
		// TODO Auto-generated method stub
		return tipo+" "+giga;
	}
	
	public int getGiga() {
		return this.giga;
	}

	public String toXML()
	{
		return
				"<ram>"
					+"<nome>"+getNome()+"</nome>"
					+"<giga>"+giga+"</giga>"
					+
				"</ram>";
	}
}
