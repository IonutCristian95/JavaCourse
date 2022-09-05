package Day4;

public class Quadrato {
    private int lato;

    public Quadrato(int lato){
        this.lato = lato;
    }

    public int getPerimeter(){
        return this.lato*4;
    }

    public void printQuadrato(){
        for (int i = 0; i < this.lato; i++){
            //First and last row
            if(i == 0 || i == this.lato-1){
                for(int counter = 0; counter < this.lato;counter++){
                    System.out.print("*");
                }
                //Go to the next line
                System.out.println();
                continue;
            }
            for(int j = 0; j < this.lato; j++){
                if(j == 0 || j == this.lato-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            //After every row being printed, go to a new line
            System.out.println();
        }
    }
}
