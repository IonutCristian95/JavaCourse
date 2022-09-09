package module5.streamingService;

import java.util.List;

public class Catalogo {
    private List<ProdottoCatalogo> catalogo;

    public Catalogo(List<ProdottoCatalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public void printCatalogo(){
        for(ProdottoCatalogo prod : catalogo){
            System.out.println(prod);
        }
    }

    public List<ProdottoCatalogo> getCatalogo() {
        return catalogo;
    }
}
