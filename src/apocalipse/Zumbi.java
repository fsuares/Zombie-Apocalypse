


package apocalipse;

/**
 *
 * @author uniffsuares
 */
public class Zumbi extends PessoaDoente {
    int color = 5;

    public Zumbi(int x, int y) {
        super(x, y, 5);
    }
    
    public int getColor() {
        return this.color;
    }
}