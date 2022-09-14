package module5.streamingService;

import java.util.*;

public class Catalogo {
    private HashSet<ProdottoCatalogo> catalogo;

    public Catalogo(HashSet<ProdottoCatalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public void printCatalogo(){
        for(ProdottoCatalogo prod : catalogo){
            System.out.println(prod);
        }
    }

    public HashSet<ProdottoCatalogo> getCatalogo() {
        return catalogo;
    }

}
