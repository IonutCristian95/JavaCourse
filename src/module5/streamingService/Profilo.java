package module5.streamingService;

import java.util.ArrayList;
import java.util.List;

public class Profilo {
    private String email;
    private String password;
    private Abbonamento tipoDiOferta;
    private List<Utente> utenti;

    public Profilo(String email, String password, Abbonamento tipoDiOferta) {
        this.email = email;
        this.password = password;
        this.tipoDiOferta = tipoDiOferta;
        this.utenti = new ArrayList<>();
    }

    public void addUtente(Utente utente){
        if (!utente.equals(null)){
            utenti.add(utente);
        }
    }

    public void printUtenti(){
        for (Utente utente : utenti){
            System.out.println(utente.getNome());
        }
    }

    public String getEmail() {
        return email;
    }

    private String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        String oldPassw = null;
        System.out.println("Insert old password: ");
        if (oldPassw==null || oldPassw.length() == 0){
            return;
        }

    }

    public void setTipoDiOferta(Abbonamento tipoDiOferta) {
        this.tipoDiOferta = tipoDiOferta;
    }

    public Abbonamento getTipoDiOferta() {
        return tipoDiOferta;
    }
}
