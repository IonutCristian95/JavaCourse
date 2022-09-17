package module7.tinder_like;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tinder {
    private HashMap<Utente, HashSet<Interesse>> usersDataBase;

    public Tinder() {
        usersDataBase = new HashMap<>();
    }

    public void insertUser(Utente utente, Interesse interesse){
        if (utente==null || interesse == null){
            return;
        }
        HashSet<Interesse> temp = new HashSet<>();
        if (usersDataBase.containsKey(utente)){
            temp = usersDataBase.get(utente);
        }
        temp.add(interesse);
        usersDataBase.put(utente, temp);
        utente.addInterest(interesse);
    }

    public void deleteUser(Utente utente) throws UserNotFoundException{
        if(usersDataBase.remove(utente)==null){
            throw new UserNotFoundException(utente);
        }
        System.out.println(utente + " was removed.");
    }

    public Utente commonInterests(Utente utente) throws UserNotFoundException{
        if (utente == null || usersDataBase.size()==1 || usersDataBase.size()==0){
            return null;
        }
        if (usersDataBase.get(utente)==null){
            throw new UserNotFoundException(utente);
        }
        HashSet<Interesse> utenteInterests = utente.getUserInterests();
        HashSet<Interesse> comparedUserInterests;
        HashSet<Interesse> tempInterests;
        int commonInterests = 0;
        Utente userCommonInterests = null;
        for (Utente utente1 : usersDataBase.keySet()) {
            if (utente1.equals(utente))
                continue;
            tempInterests = new HashSet<>(utenteInterests);
            comparedUserInterests = utente1.getUserInterests();
            tempInterests.retainAll(comparedUserInterests);

            if (tempInterests.size() > commonInterests){
                commonInterests = tempInterests.size();
                userCommonInterests = utente1;
            }
        }
        return userCommonInterests;
    }
}
