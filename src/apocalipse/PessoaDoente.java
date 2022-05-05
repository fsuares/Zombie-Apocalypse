


package apocalipse;

import java.util.Random;


/**
 *
 * @author uniffsuares
 */
public class PessoaDoente extends Pessoa implements Movable {
    private Virus virus;
    
    public PessoaDoente(int x, int y) {
        super(x, y, 4);
        this.virus = new Virus();
    }
    
    public PessoaDoente(int x, int y, int color){
        super(x, y, color);
    }

   
    public boolean getTime(){
        return virus.getTime();
    }
    
    @Override
    public void mover() {
        Random rand = new Random();
        int num = rand.nextInt(4);
        
        if(num == 2){
           if(this.getX()==28){
              this.setX(1);
           }else
           this.setX(this.getX() +1);
        }
        else if (num ==3){
            if(this.getX()==1){
                this.setX(28);
            }else
            this.setX(this.getX()-1);
        }
        else if (num == 0){
            if(this.getY()==88){
                this.setY(1);
            }else
            this.setY(this.getY() +1);
        }
        else if (num ==1){
            if(this.getY()==1){
                this.setY(88);
            }else
            this.setY(this.getY()-1);
        }
    }
}