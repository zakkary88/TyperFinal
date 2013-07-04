/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progressivebooker;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Marcin
 */
public class ProgressiveBookerMoney {
    
    private List<Double> odds;
    private Random rand;
    private ProgressionType progressionType;
    
    private double currentBetAmount;
    private double lostMoney;
    private double wonMoney;
    
    private NumberFormat nf = NumberFormat.getInstance();
    
    public ProgressiveBookerMoney()
    {
        this.progressionType = new ProgressionType();
        this.odds = new ArrayList<Double>();
        this.rand = new Random();
        
        currentBetAmount = 0.0;
        lostMoney = 0.0;
        wonMoney = 0.0;
    }
       
     private double round(double val, int places) 
     {
	long factor = (long)Math.pow(10,places);
	val = val * factor;
	long tmp = Math.round(val);

	return (double)tmp / factor;
    }
    
    public String simulate(int drawFrequency, double toWinORstartBet, ProgressionTypeENUM progType)
    {
        String result = "";
        
        if(progType.equals(ProgressionTypeENUM.Doubling_Up))
            result = simulateDoublingUp(drawFrequency, toWinORstartBet);
        
        if(progType.equals(ProgressionTypeENUM.Steady_Profit))
            result = simulateSteadyProfit(drawFrequency, toWinORstartBet);
        
        if(progType.equals(ProgressionTypeENUM.Fibonacci))
            result = simulateFibonnaci(drawFrequency, toWinORstartBet);
        
        return result;
    }
    
    private String simulateSteadyProfit(int drawFrequency, double moneyToWin)
    {
        int randomInt = 0;      
        String info = "";
        currentBetAmount = progressionType.steadyProfitCurrentBetAmount(moneyToWin, 0, odds.get(0));
        currentBetAmount = round(currentBetAmount, 2);
        lostMoney = 0.0;

        for(int i=0; i<odds.size(); ++i)
        {
            randomInt = rand.nextInt(99) + 1;   //od 1 do 100            
     
            if(randomInt < drawFrequency)
            {                 
                wonMoney = moneyToWin;
                wonMoney = round(wonMoney,2);
                lostMoney = 0.0;  
                
                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() + 
                        " \t stake: " + currentBetAmount + 
                        " \t WON:  " + wonMoney + "\n";               
   
                currentBetAmount = progressionType.steadyProfitCurrentBetAmount(moneyToWin, 0.0, odds.get(i));
                currentBetAmount = round(currentBetAmount, 2);
                wonMoney = 0.0;
            }
            else
            {           
                lostMoney += currentBetAmount;
                lostMoney = round(lostMoney,2);

                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() +  
                        " \t stake: " + currentBetAmount + 
                        " \t lost:  " + lostMoney + "\n";
                
                currentBetAmount = progressionType.steadyProfitCurrentBetAmount(moneyToWin, lostMoney, odds.get(i));                         
                currentBetAmount = round(currentBetAmount,2);
            }
            
            if(i == odds.size()-1)
            {
                currentBetAmount = 0.0;
                wonMoney = 0.0;
                lostMoney = 0.0;
            }
        }
        
        return info;
    }
    
    private String simulateDoublingUp(int drawFrequency, double startBetAmount)
    {
        int randomInt = 0;      
        String info = "";
        currentBetAmount = startBetAmount;
                      
        for(int i=0; i<odds.size(); ++i)
        {
            randomInt = rand.nextInt(99) + 1;   //od 1 do 100            
     
            if(randomInt < drawFrequency)
            {               //mozna w nawias - (odds.get(i) - 1)
                wonMoney = currentBetAmount * odds.get(i) - lostMoney - currentBetAmount;
                wonMoney = round(wonMoney, 2);
                lostMoney = 0.0;
                
                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() + 
                        " \t stake: " + currentBetAmount + 
                        " \t WON:  " + wonMoney + "\n";
                
                currentBetAmount = startBetAmount;
                wonMoney = 0.0;
            }
            else
            {
                lostMoney += currentBetAmount;
              
                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() +  
                        " \t stake: " + currentBetAmount + 
                        " \t lost:  " + lostMoney + "\n";
                
                currentBetAmount = progressionType.doublingUpCurrentBetAmount(currentBetAmount);
                currentBetAmount = round(currentBetAmount, 2);
            }
            
            if(i == odds.size()-1)
            {
                currentBetAmount = 0.0;
                wonMoney = 0.0;
                lostMoney = 0.0;               
            }
        }
        
        return info;
    }
    
    private String simulateFibonnaci(int drawFrequency, double startBetAmount)
    {
        int randomInt = 0;      
        String info = "";   
  
        currentBetAmount = progressionType.fibonnaciCurrentBetAmount(startBetAmount, 0);  
        int progressionLevel = 0;
        
        for(int i=0; i<odds.size(); ++i)
        {
            randomInt = rand.nextInt(99) + 1;   //od 1 do 100            
     
            if(randomInt < drawFrequency)
            {               
                wonMoney = currentBetAmount * odds.get(i) - lostMoney - currentBetAmount;
                wonMoney = round(wonMoney, 2);
                lostMoney = 0.0;
                
                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() + 
                        " \t stake: " + currentBetAmount + 
                        " \t WON:  " + wonMoney + "\n";
                
                progressionType.getMoneyRates().clear();
                
                currentBetAmount = progressionType.fibonnaciCurrentBetAmount(startBetAmount, 0);  
                wonMoney = 0.0;
                progressionLevel = 0;
            }
            else
            {       
                progressionLevel++;
                lostMoney += currentBetAmount;
                lostMoney = round(lostMoney, 2);
                
                info += (i+1) + ": odd: " 
                        + odds.get(i).toString() +  
                        " \t stake: " + currentBetAmount + 
                        " \t lost:  " + lostMoney + "\n";
                                                      
                currentBetAmount = progressionType.fibonnaciCurrentBetAmount(startBetAmount, progressionLevel);
                currentBetAmount = round(currentBetAmount, 2);               
            }
            
            if(i == odds.size()-1)
            {
                currentBetAmount = 0.0;
                wonMoney = 0.0;
                lostMoney = 0.0;
                
                progressionType.getMoneyRates().clear();
            }
        }
        
        return info;
    }
          
    public List<Double> getOdds() 
    {
        return odds;
    }
}
