package module9turista;

import java.util.HashMap;
import java.util.HashSet;

public class Host extends Utente {
    private String codiceHost;
    private HashMap<Utente, HashSet<Prenotazione>> prenotazioni;

    public Host(String nome, String cognome, String email, String indirizzo, String codiceHost) {
        super(nome, cognome, email, indirizzo);
        this.codiceHost = codiceHost;
        prenotazioni = new HashMap<>();
    }

    public String getCodiceHost() { return codiceHost; }

    public void addPrenotazione(Prenotazione prenotazione){
        if(prenotazione==null) return;

        HashSet<Prenotazione> temp = new HashSet<>();
        if (prenotazioni.get(prenotazione.getUtente())!=null){
            temp = prenotazioni.get(prenotazione.getUtente());
        }
        temp.add(prenotazione);
        prenotazioni.put(prenotazione.getUtente(), temp);
    }


}
