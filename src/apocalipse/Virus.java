
package apocalipse;

/**
 *
 * @author uniffsuares
 */
        
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Virus {
    private int sec, min;
    private int color;

    public int getCor() {
        return this.color;
    }

    public void setCor(int color) {
        this.color = color;
    }
    
    public Virus() {
         LocalDateTime primeiro = LocalDateTime.now();
         sec = primeiro.getSecond();
         min = primeiro.getMinute();
    }

    
    public boolean getTime(){
        LocalDateTime segundo = LocalDateTime.now();
        int secAtual = segundo.getSecond();
        int minAtual = segundo.getMinute();
        
        if(minAtual > this.min && this.sec <= 45){
            return true;
        }
        else if(min == minAtual && ((secAtual - this.sec)>=15)){
            return true;
        }
        else if(minAtual> this.min && this.sec > 45){
            if(((60 - this.sec) + secAtual) >= 5){
                return true;
            }
            else{
                return false;
            }
        }
        else
            return false;
    }
   
}

