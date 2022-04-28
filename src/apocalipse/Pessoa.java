


package apocalipse;

import java.util.Random;

/**
 *
 * @author uniffsuares
 */
public class Pessoa {
    private int x, y;
    private int cor;
    private int z;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCor() {
        return this.cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    
    Random r = new Random();
    
    public void mover(){
        z = r.nextInt(4);
        
        if ( z == 0 )
            this.setX( this.getX() + 1 );
        
        if ( z == 1)
            this.setX( this.getX() - 1 );
        
        if ( z == 2)
            this.setX( this.getY() + 1 );
        
        else
            this.setY( this.getY() - 1);
    }
}


