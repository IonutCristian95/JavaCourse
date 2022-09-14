package module5.streamingService;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Profilo {
    private String email;
    private String password;
    private Abbonamento tipoDiOferta;
    private HashSet<Utente> utenti;

    public Profilo(String email, String password, Abbonamento tipoDiOferta) {
        this.email = email;
        this.password = password;
        this.tipoDiOferta = tipoDiOferta;
        this.utenti = new HashSet<>();
    }

    public void addUtente(Utente utente){
        if (utente != null && !utenti.contains(utente)){
            utente.setProfile(this);
            utenti.add(utente);
        }
    }

    public void printUtenti(){
        for (Utente utente : utenti){
            System.out.println(utente);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert old password: ");
        oldPassw = scanner.nextLine();
        if (oldPassw==null){
            return;
        }
        if(oldPassw.equals(this.getPassword())){
            this.password = password;
        }
    }

    public void setTipoDiOferta(Abbonamento tipoDiOferta) {
        this.tipoDiOferta = tipoDiOferta;
    }

    public Abbonamento getTipoDiOferta() {
        return tipoDiOferta;
    }

    public HashSet<Utente> getUtenti() {
        return utenti;
    }

}
