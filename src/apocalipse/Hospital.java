


package apocalipse;

import java.util.ArrayList;

/**
 *
 * @author uniffsuares
 */
public class Hospital {
    private int cor;

    public int getCor() {
        return this.cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    
    public void cura(ArrayList<PessoaSaudavel> x, ArrayList<PessoaDoente> y, int i){
        int posicaoY = y.get(i).getY();
        int posicaoX = y.get(i).getX();
        y.remove(i);
        x.add(new PessoaSaudavel(posicaoY, posicaoX));
        
    }
}


