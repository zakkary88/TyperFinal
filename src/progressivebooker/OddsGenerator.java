/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progressivebooker;

import java.util.Random;


/**
 *
 * @author Marcin
 */
public class OddsGenerator {
      
    Random rand;
    
    public OddsGenerator()
    {
        rand = new Random();
    }
    
    // losowanie kursu dla remisu
    public double generateOdd()
    {
        int randomInt = rand.nextInt(7) + 1;    //od 1 do 8
        double odd = 0.0;
        
        if(randomInt == 5)
        {
            //4.0 - 5.0
            odd = (rand.nextDouble() + 4) * 100;
        }
        else
        {
            //2.9 - 3.4
            odd = (rand.nextDouble() / 2.0 + 2.9) * 100;
        }
        
        odd = odd + (5 - odd % 5);

        odd = Math.round(odd);
        odd /= 100;
        
        return odd;
    }   
   
}
