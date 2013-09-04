/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coverbooker;

import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.text.NumberFormat;

/**
 *
 * @author Marcin
 */
public class CoverBookerCalc {
    
    private ThreeWayEvent event;
    private PercentageChance pChance;
    private BestOptionSorter bestOptionSorter;
    private CoverBookerMoney coverBookerMoney;
    
    NumberFormat nf = NumberFormat.getInstance();
    
    public CoverBookerCalc()
    {
        this.event = new ThreeWayEvent();
        this.pChance = new PercentageChance();
        this.bestOptionSorter = new BestOptionSorter();
        this.coverBookerMoney = new CoverBookerMoney();
        
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
    }        
    
    public CoverBookerCalc(JTextField homeCourse, JTextField drawCourse,
            JTextField awayCourse, JLabel info)
    {
        this.event = setEvent(homeCourse, drawCourse, awayCourse, info);
        this.pChance = new PercentageChance();
        this.bestOptionSorter = new BestOptionSorter();
        this.coverBookerMoney = new CoverBookerMoney();
        
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
    }
    
    public double checkField(String fieldValue, JLabel jLabelInfo)
    {
        double result = 0;
        
        try
        {
            Number parsed = nf.parse(fieldValue);
            result = parsed.doubleValue();
        }
        catch (ParseException pex)
        {
            jLabelInfo.setText("Invalid input data.");
        }  
        
        return result;        
    }
        
    private ThreeWayEvent setEvent(JTextField homeCourse, JTextField drawCourse,
            JTextField awayCourse, JLabel info)
    {
//        double homeCourseDouble = checkField(homeCourse.getText(), info);     
//        double drawCourseDouble = checkField(drawCourse.getText(), info);
//        double awayCourseDouble = checkField(awayCourse.getText(), info);
        
        String hcS = homeCourse.getText();
        String dcS = drawCourse.getText();
        String acS = awayCourse.getText();
        
        double homeCourseDouble = Double.parseDouble(hcS);     
        double drawCourseDouble = Double.parseDouble(dcS);
        double awayCourseDouble = Double.parseDouble(acS);
        
        return new ThreeWayEvent(homeCourseDouble, drawCourseDouble, awayCourseDouble);       
    }
    
    public void calculatePercentageChance()
    {
        double homePC = calculate(event.getHomeCourse());
        double drawPC = calculate(event.getDrawCourse());
        double awayPC = calculate(event.getAwayCourse());
        
        pChance.setHomePercentageChance(homePC);
        pChance.setDrawPercentageChance(drawPC);
        pChance.setAwayPercentageChance(awayPC);
    }
    
    private double calculate(double course)
    {
        return 1.0 / course * 0.9 * 100;
    }
           
    public CoverTypeENUM getBestType()
    {     
        getBestOptionSorter().sort(getpChance().getHomePercentageChance(),
                getpChance().getDrawPercentageChance(), 
                getpChance().getAwayPercentageChance());      
        
        CoverTypeENUM type = CoverTypeENUM.Away_Draw;
        
        if(bestOptionSorter.getFirstPlace() == pChance.getHomePercentageChance() && 
                bestOptionSorter.getSecondPlace() == pChance.getDrawPercentageChance())
        {
            type = CoverTypeENUM.Home_Draw;
        }
        
        if(bestOptionSorter.getFirstPlace() == pChance.getHomePercentageChance() &&
               bestOptionSorter.getSecondPlace() == pChance.getAwayPercentageChance())
        {
            type = CoverTypeENUM.Home_Away;
        }
        
        if(bestOptionSorter.getFirstPlace() == pChance.getDrawPercentageChance() &&
                bestOptionSorter.getSecondPlace() == pChance.getHomePercentageChance())
        {
            type = CoverTypeENUM.Draw_Home;
        }
        
        if(bestOptionSorter.getFirstPlace() == pChance.getDrawPercentageChance() &&
                bestOptionSorter.getSecondPlace() == pChance.getAwayPercentageChance())
        {
            type = CoverTypeENUM.Draw_Away;
        }
        
        if(bestOptionSorter.getFirstPlace() == pChance.getAwayPercentageChance() &&
                bestOptionSorter.getSecondPlace() == pChance.getDrawPercentageChance())
        {
            type = CoverTypeENUM.Away_Draw;          
        }
        
        if(bestOptionSorter.getFirstPlace() == pChance.getAwayPercentageChance() &&
                bestOptionSorter.getSecondPlace() == pChance.getHomePercentageChance())
        {
            type = CoverTypeENUM.Away_Home;
        }        
        
        return type;
    }        
               
    public ThreeWayEvent getEvent() {
        return event;
    }   
    
    public PercentageChance getpChance() {
        return pChance;
    }
    
    public BestOptionSorter getBestOptionSorter() {
        return bestOptionSorter;
    }
    
    public CoverBookerMoney getCoverBookerMoney() {
        return coverBookerMoney;
    }
}
