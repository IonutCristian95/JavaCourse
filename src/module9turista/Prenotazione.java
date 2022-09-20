package module9turista;

import java.time.LocalDateTime;

public class Prenotazione {
    /**
     *  Di ogni prenotazione si deve mantenere un id univoco, le date di inizio e fine, l'abitazione relativa e l'utente che ha soggiornato
     */
    private String id;
    private LocalDateTime inizio;
    private LocalDateTime fine;
    private Abitazione abitazione;
    private Utente utente;

    public Prenotazione(String id, LocalDateTime inizio, LocalDateTime fine, Abitazione abitazione, Utente utente) {
        this.id = id;
        this.inizio = inizio;
        this.fine = fine;
        this.abitazione = abitazione;
        this.utente = utente;
    }

    public String getId() { return id; }
    public LocalDateTime getInizio() { return inizio; }
    public LocalDateTime getFine() { return fine; }
    public Abitazione getAbitazione() { return abitazione; }
    public Utente getUtente() { return utente; }
}
