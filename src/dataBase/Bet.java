/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

/**
 *
 * @author Marcin
 * 
 * Obiekt klasy jest tworzony dla nowego zakładu, który nie jest częścią
 * progresji (opcja part of progression jest odznaczona)
 */
public class Bet {
    
    protected int betId;
    protected String betName;
    protected String date;
    protected double odd;
    protected double stake;
    protected int betStatus;     // /-1 blad / 1 nierozstrzygniety / 2 wygrany / 3 przegrany / 4 odwołany
    protected String bukmacher;
    protected String note;
    protected String type;

    protected double balance;
    
    protected int partOfProgression; // 0 - nie jest czescia progresji / inna licza - progressionId     

    
    public Bet() {}
    
    //8 variables
    public Bet(int betId, String betName, String date, double odd, double stake, 
            String bukmacher, String note, String type)
    {
        this.betId = betId;
        this.betName = betName;
        this.date = date;
        this.odd = odd;
        this.stake = stake;
        this.bukmacher = bukmacher;
        this.note = note;
        this.type = type;
     
        this.partOfProgression = 0;     //TODO moze powodowac problemy!!!!
        this.betStatus = 1;     //jakos nierozstrzygniety
        this.balance = 0;
    }
    
    //9 variables
    public Bet(int betId, String betName, String date, double odd, double stake, 
            int partOfProgression, String bukmacher, String note, String type)
    {
        this.betId = betId;
        this.betName = betName;
        this.date = date;
        this.odd = odd;
        this.stake = stake;
        this.partOfProgression = partOfProgression;
        this.bukmacher = bukmacher;
        this.note = note;
        this.type = type;
     
        this.betStatus = 1;     //jakos nierozstrzygniety
        this.balance = 0;
    }
    
    //11 variables
    public Bet(int betId, String betName, String date, double odd, double stake, int partOfProgression,
            int betStatus, String bukmacher, String note, double balance, String type)
    {
        this.betId = betId;
        this.betName = betName;
        this.date = date;
        this.odd = odd;
        this.stake = stake;
        this.partOfProgression = partOfProgression;     //TODO moze powodowac problemy!!!!
        this.betStatus = betStatus;     
        this.bukmacher = bukmacher;
        this.note = note;
        this.balance = balance;
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return betId + " " + betName;
    }
    
    public int getBetId() 
    {
        return betId;
    }

    public String getBetName() 
    {
        return betName;
    }

    public String getDate() 
    {
        return date;
    }

    public double getOdd() 
    {
        return odd;
    }

    public double getStake() 
    {
        return stake;
    }

    public int getBetStatus() 
    {
        return betStatus;
    }
    
    public double getBalance() 
    {
        return balance;
    }

    public String getNote() 
    {
        return note;
    }

    public String getBukmacher() 
    {
        return bukmacher;
    }

    public String getType() 
    {
        return type;
    }
     
    public int getPartOfProgression() 
    {
        return partOfProgression;
    }
}
