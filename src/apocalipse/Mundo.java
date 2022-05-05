package apocalipse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Mundo {

   public static final String ANSI_RESET = "\u001B[0m";
   public static final String BLACK_BACKGROUND = "\u001B[40m";
   public static final String WHITE_BACKGROUND = "\033[47m \033[0m";
   public static final String GREEN_BACKGROUND = "\033[42m \033[0m";
   public static final String BLUE_BACKGROUND= "\033[44m \033[0m";
   public static final String YELLOW_BACKGROUND = "\033[43m \033[0m";
   public static final String RED_BACKGROUND = "\033[41m \033[0m";
   public static final String CYAN_BACKGROUND = "\033[46m \033[0m"; 
 
   int valor = 0;
   int xmap = 30;
   int ymap = 90;
   
   private ArrayList<PessoaSaudavel> pessS = new ArrayList<>();
   private Integer[][] map = new Integer[xmap][ymap];
   private PessoaDoente pt1 = new PessoaDoente(15,5);
   private PessoaDoente pt2 = new PessoaDoente(18,65);
   private ArrayList<PessoaDoente> pessD = new ArrayList<>(); 
   private ArrayList<Zumbi> zomb= new ArrayList<>(); 


    public void desenhaMundo(){
       
        if(valor == 0){
            Random rand = new Random();
              for(Integer z = 0; z < 100; z++){
                int randx = rand.nextInt(27)+1;
                int randy = rand.nextInt(86)+1;

                pessS.add(new PessoaSaudavel(randx,randy));
                valor++;
            }
            pessD.add(pt1);
            pessD.add(pt2);

        }
        
        this.criaMapa();
              
        ArrayList<PessoaDoente> pessdTemp = new ArrayList<>();
        
        for(PessoaDoente pessoaDoente: pessD){
            
              if(pessoaDoente.getTime() && map[pessoaDoente.getX()][pessoaDoente.getY()]!=2){
                 Zumbi temp =  new Zumbi(pessoaDoente.getX(),pessoaDoente.getY());
                 zomb.add(temp);
              }
              
              else if( pessoaDoente.getTime()==false && map[pessoaDoente.getX()][pessoaDoente.getY()] == 2 ){
                  pessS.add(new PessoaSaudavel(pessoaDoente.getX(),pessoaDoente.getY()));
              }

              else{
               pessdTemp.add(pessoaDoente);
           }
        }
        pessD.clear();
        pessD = pessdTemp;
        
        
        for(PessoaDoente pessoa: pessD){
            map[pessoa.getX()][pessoa.getY()] = pessoa.getColor();
        }
       
        
        if(zomb != null){
            for(Zumbi zumbi: zomb){
                map[zumbi.getX()][zumbi.getY()] = zumbi.getColor();
            }
        }
        

        ArrayList<PessoaSaudavel> pesssTemp = new ArrayList<>();
        for(PessoaSaudavel pessoa : pessS){
            if(map[pessoa.getX()][pessoa.getY()]== 4 || map[pessoa.getX()][pessoa.getY()]== 5 ){
                pessD.add(new PessoaDoente(pessoa.getX(),pessoa.getY()));
            }
            else if (map[pessoa.getX() +1 ][pessoa.getY()]== 4 || map[pessoa.getX() +1 ][pessoa.getY()]== 5 ){
                pessD.add(new PessoaDoente(pessoa.getX()+1,pessoa.getY()));
            }
            else if (map[pessoa.getX() -1 ][pessoa.getY()]== 4 || map[pessoa.getX() -1 ][pessoa.getY()]== 5){
                pessD.add(new PessoaDoente(pessoa.getX()-1,pessoa.getY()));
            }
            else if (map[pessoa.getX()][pessoa.getY()+1]== 4 || map[pessoa.getX()][pessoa.getY()+1]== 5){
                pessD.add(new PessoaDoente(pessoa.getX(),pessoa.getY()+1));
            }
             else if (map[pessoa.getX()][pessoa.getY()-1]== 4 || map[pessoa.getX()][pessoa.getY()-1]== 5){
                pessD.add(new PessoaDoente(pessoa.getX(),pessoa.getY()-1));
            }
             else{
                 pesssTemp.add(pessoa);
             }
                
        }
        pessS.clear();
        pessS = pesssTemp;
        

        for(PessoaSaudavel pessoa : pessS){  
           map[pessoa.getX()][pessoa.getY()] = pessoa.getColor();
        }
        

        this.imprimirMapa();
        
 
     }
    
    public void criaMapa(){

        // Logica para contrução do mapa
        for(int x = 0; x< xmap; x++){
            for(int y = 0; y< ymap; y++){
                if((x==0 || x== 29) ||(y==0 || y==89) ){
                    map[x][y]=1;
                }
                else if((x>5 && x<=8) && (y>10 && y<=20)){
                    map[x][y]=2;
                }
                else if((x>5 && x<=8) && (y>56 && y<=66)){
                    map[x][y]=2;
                }
                else if((x>18 && x<=21) && (y>32 && y<=42)){
                    map[x][y]=2;
                }
                else
                    map[x][y]=0;
            }

        }
    }
    
    
    public void imprimirMapa(){ 
        for(int x =0; x<xmap; x++){
           for(int y=0; y<ymap; y++){
                if(map[x][y]==1){
                    System.out.print(WHITE_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else if(map[x][y]==2){
                    System.out.print(CYAN_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else if (map[x][y]== 3){
                    System.out.print(BLUE_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }             
                else if (map[x][y]== 4){
                    System.out.print(YELLOW_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }          
                else if (map[x][y]== 5){
                    System.out.print(RED_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else if(map[x][y] == 6){
                    System.out.print(GREEN_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else{
                    System.out.print(" ");
                    System.out.print(ANSI_RESET);
                } 
            }
            System.out.println();
            
         }
  
 
    }
    
    public void move(){
        for(PessoaSaudavel pp: pessS){
            pp.mover();
        }

        for(PessoaDoente pp: pessD){
            pp.mover();
        }
        
        // Verifica se a lista não está vazia, caso não esteja utiliza a função mover
        if(zomb!=null){
            for(Zumbi zumbi: zomb){
                zumbi.mover();
            }
        } 
   }

    
   public int getPessS(){
       return pessS.size();
   }
   
   public int getPessD(){
       return pessD.size();
   }
   
   public int getZomb(){
       return zomb.size();
   }
}



