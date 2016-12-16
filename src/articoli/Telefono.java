package articoli;

public class Telefono extends Articolo {

	private String marca;
	private Ram ram;
	private double prezzo;
	private Hd memoria;
	private String sistemaoperativo;
	private String LTE;
	private String DUALSIM;
	
	// costruttore
	public Telefono(String nome,
					String descrizione, 
					String marca, 
					Ram ram, 
					double prezzo, 
					Hd memoria, 
					String sistemaoperativo,
					String LTE,
					String DUALSIM){
		super(nome,descrizione);
		this.marca = marca;
		this.ram = ram;
		this.prezzo = prezzo;
		this.memoria = memoria;
		this.sistemaoperativo = sistemaoperativo;
		this.LTE = LTE;
		this.DUALSIM = DUALSIM;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Hd getMemoria() {
		return memoria;
	}

	public void setMemoria(Hd memoria) {
		this.memoria = memoria;
	}

	public String getSistemaoperativo() {
		return sistemaoperativo;
	}

	public void setSistemaoperativo(String sistemaoperativo) {
		this.sistemaoperativo = sistemaoperativo;
	}

	public String getLTE() {
		return LTE;
	}

	public void setLTE(String lTE) {
		LTE = lTE;
	}

	public String getDUALSIM() {
		return DUALSIM;
	}

	public void setDUALSIM(String dUALSIM) {
		DUALSIM = dUALSIM;
	}
	
	public String scheda(){
		return super.scheda()
								+ "\nMARCA            : " + this.marca
								+ "\nSYSTEMA OPERATIVO: " + this.sistemaoperativo
								+ "\nPREZZO           : " + this.prezzo
								+ "\nRam              : " + this.ram.scheda()
								+ "\nMEMORIA          : " + this.memoria.scheda()
								+ "\nLTE              : " + this.LTE
								+ "\nDUALSIM          : " + this.DUALSIM;
	}
}
