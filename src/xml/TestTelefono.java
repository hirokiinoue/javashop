package xml;

import dao.TelefonoDAO;
import java.util.ArrayList;
import articoli.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Telefono> telefonoList = new ArrayList<Telefono>();
		
		TelefonoDAO telefonoDAO = new TelefonoDAO(new DBNegozioXML("C:\\Users\\corso1\\Documents\\JAVAINTERMEDIO\\xml\\telefono.xml"));
		
		telefonoList = telefonoDAO.leggi();
		
		System.out.println("--- START leggi() START ---");
		for (int i = 0; i<telefonoList.size(); i++){
			System.out.println(telefonoList.get(i).scheda());
		}
		System.out.println("--- E N D leggi() E N D ---");
		
		System.out.println("--- START leggi(parametri) START ---");
		telefonoList = telefonoDAO.leggi("Apple",0,0,0,"","","");
		for (int i = 0; i<telefonoList.size(); i++){
			System.out.println(telefonoList.get(i).scheda());
		}
		System.out.println("--- E N D leggi(parametri) E N D ---");
		
	}

}
