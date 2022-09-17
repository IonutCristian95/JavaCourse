package module7.tinder_like;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

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
        if (!isValidUser(utente)){
            return null;
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

    public TreeMap<Utente, Integer> getBestMatches(Utente utente) throws UserNotFoundException{
        if (!isValidUser(utente)){
            return null;
        }
        HashMap<Utente, Integer> tempUsers = new HashMap<>();
        HashSet<Interesse> utenteInterests = utente.getUserInterests();
        HashSet<Interesse> tempInterests;

        for (Utente utente1 : usersDataBase.keySet()) {
            if(utente.equals(utente1)){
                continue;
            }
            tempInterests = new HashSet<>(utenteInterests);
            tempInterests.retainAll(utente1.getUserInterests());
            tempUsers.put(utente1, tempInterests.size());
        }

        TreeMap<Utente, Integer> ordered = new TreeMap<>(new Comparator<Utente>() {
            @Override
            public int compare(Utente o1, Utente o2) {
                if (tempUsers.get(o1) > tempUsers.get(o2)) return -1;
                else if(tempUsers.get(o1) < tempUsers.get(o2)) return 1;
                else return 0;
            }
        });

        ordered.putAll(tempUsers);

        return ordered;
    }

    private boolean isValidUser(Utente utente) throws UserNotFoundException{
        if (utente == null || usersDataBase.size()>=1){
            return false;
        }
        if (usersDataBase.get(utente)==null){
            throw new UserNotFoundException(utente);
        }
        return true;
    }

}
