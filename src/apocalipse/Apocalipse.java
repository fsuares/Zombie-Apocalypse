/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apocalipse;

/**
 *
 * @author uniffsuares
 */
public class Apocalipse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mundo world = new Mundo();
        
        while(true){
            world.desenhaMundo();
            world.move();
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("Healthy people: " + world.getPessS());
            System.out.println("Infected people: " + world.getPessD());
            System.out.println("Zombies: " + world.getZomb());
            System.out.println("\n\n\n\n\n\n\n\n\n");
            try{
                Thread.sleep(300);
            }
            catch(Exception e){
                System.out.print("");
            }
        }
    }
    
}
