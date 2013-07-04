/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.awt.Dimension;
import java.util.LinkedList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;


/**
 *
 * @author Marcin
 */
public class ChartsGenerator {
    
    private int wonInProg = 0;
    private int wonNotInProg = 0;
    private int lostInProg = 0;
    private int lostNotInProg = 0;
    
    private LinkedList<String> dates = new LinkedList<String>();
    private LinkedList<Day> days = new LinkedList<Day>();
    private LinkedList<String> yearsMonths = new LinkedList<String>();
    private LinkedList<String> bukmachers = new LinkedList<String>();
    private LinkedList<String> types = new LinkedList<String>();
    
    private LinkedList<Integer> wonBetsByDate = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsByDate = new LinkedList<Integer>();   
    private LinkedList<Integer> wonBetsByDateInProg = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsByDateInProg = new LinkedList<Integer>();
    private LinkedList<Integer> wonBetsByDateNotInProg = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsByDateNotInProg = new LinkedList<Integer>();
    
    private LinkedList<Integer> wonBetsByBukmacher = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsByBukmacher = new LinkedList<Integer>();
    private LinkedList<Integer> wonBetsInProgByBukmacher = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsInProgByBukmacher = new LinkedList<Integer>();
    private LinkedList<Integer> wonBetsNotInProgByBukmacher = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsNotInProgByBukmacher = new LinkedList<Integer>();
    
    private LinkedList<Integer> wonBetsByType = new LinkedList<Integer>();
    private LinkedList<Integer> lostBetsByType = new LinkedList<Integer>();
    
    private LinkedList<Double> wonBalance = new LinkedList<Double>();
    private LinkedList<Double> stakesSum = new LinkedList<Double>();
    private LinkedList<Double> yield = new LinkedList<Double>();
    
    private LinkedList<Double> wonBalanceInProg = new LinkedList<Double>();
    private LinkedList<Double> stakeSumInProg = new LinkedList<Double>();
    private LinkedList<Double> yieldInProg = new LinkedList<Double>();
    
    private LinkedList<Double> wonBalanceNotInProg = new LinkedList<Double>();
    private LinkedList<Double> stakeSumNotInProg = new LinkedList<Double>();
    private LinkedList<Double> yieldNotInProg = new LinkedList<Double>();
    
    private LinkedList<Double> balanceByMonths = new LinkedList<Double>();
    private LinkedList<Double> balanceInProgByMonths = new LinkedList<Double>();
    private LinkedList<Double> balanceNotInProgByMonths = new LinkedList<Double>();
    
    private LinkedList<Double> balanceByBukmacher = new LinkedList<Double>();
    private LinkedList<Double> balanceInProgByBukmacher = new LinkedList<Double>();
    private LinkedList<Double> balanceNotInProgByBukmacher = new LinkedList<Double>();
    
    private LinkedList<Double> balanceByType = new LinkedList<Double>();
    
    public ChartsGenerator()
    {
        wonInProg = DataContainer.listModelWonBetsInProg.size();
        wonNotInProg = DataContainer.listModelWonBetsNotInProg.size();
        
        lostInProg = DataContainer.listModelLostBetsInProg.size();
        lostNotInProg = DataContainer.listModelLostBetsNotInProg.size();
        
        loadDataFromDB();
        fillDays();
        fillListYield();
    }
    
    private Day getDate(String dateFromBD)
    {
        String monthString = "";
        String yearString = "";
        String dayString = "";
        
        String [] split = dateFromBD.split("-");
        String [] split2 = split[2].split(" ");
        
        yearString = split[0];
        monthString = split[1];     
        dayString = split2[0];
        
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);       
        Day date = new Day(day, month, year);
        
        //System.out.println(day + " " + month + " " + yearString);
        return date;                
    }
    
    private void fillDays()
    {
        for(String date : dates)
            days.add(getDate(date));        
    }
    
    private void loadDataFromDB()
    {
         //daty, miesiace i lata, bukmacherzy, typy
         DataContainer.dataFromDB.getQueryManager().viewDates(getDates());
         DataContainer.dataFromDB.getQueryManager().viewYearsMonths(yearsMonths);
         DataContainer.dataFromDB.getQueryManager().viewBukmachers(bukmachers);
         DataContainer.dataFromDB.getQueryManager().viewTypes(types);
     
         fillWonLostByDate();
         fillWonBalanceStakeSum();
         fillWonLostByBukmachers();
         fillTypes();
    }
    
    private void fillTypes()
    {
        for(String type : types)
        {
            int wonBT = DataContainer.dataFromDB.getQueryManager().countWonBetsByType(type);
            int lostBT = DataContainer.dataFromDB.getQueryManager().countLostBetsByType(type);
            
            getWonBetsByType().add(wonBT);
            getLostBetsByType().add(lostBT);
            
            double balanceBT = DataContainer.dataFromDB.getQueryManager().countBalanceByType(type);
            
            getBalanceByType().add(balanceBT);
        }
    }
    
    private void fillWonLostByDate()
    {
        for(String yearMonth : yearsMonths)
         {
             //ilosc wygrany i przegranych zakładów
             //wszystkie zaklady
             int wonBetsInYM = DataContainer.dataFromDB.getQueryManager().countWonBetsByDate(yearMonth);
             int lostBetsInYM = DataContainer.dataFromDB.getQueryManager().countLostBetsByDate(yearMonth);
             
             wonBetsByDate.add(wonBetsInYM);
             lostBetsByDate.add(lostBetsInYM);
             
             //zaklady w progresjach
             int wonBetsInYMInProg = DataContainer.dataFromDB.getQueryManager().
                     countWonBetsByDateInProg(yearMonth);
             int lostBetsInYMInProg = DataContainer.dataFromDB.getQueryManager().
                     countLostBetsByDateInProg(yearMonth);
             
             wonBetsByDateInProg.add(wonBetsInYMInProg);
             lostBetsByDateInProg.add(lostBetsInYMInProg);
             
             //zaklady nie w progresjach
             int wonBetsInYMNotInProg = DataContainer.dataFromDB.getQueryManager().
                     countWonBetsByDateNotInProg(yearMonth);
             int lostBetsInYMNotInProg = DataContainer.dataFromDB.getQueryManager().
                     countLostBetsByDateNotInProg(yearMonth);
             
             wonBetsByDateNotInProg.add(wonBetsInYMNotInProg);
             lostBetsByDateNotInProg.add(lostBetsInYMNotInProg);
             
             //miesieczny zysk/strata
             double balanceBM = DataContainer.dataFromDB.getQueryManager().
                     countBalanceByMonths(yearMonth);
             double balanceInProgBM = DataContainer.dataFromDB.getQueryManager().
                     countBalanceInProgByMonths(yearMonth);
             double balanceNotInProgBM = DataContainer.dataFromDB.getQueryManager().
                     countBalanceNotInProgByMonths(yearMonth);
             
             balanceByMonths.add(balanceBM);
             balanceInProgByMonths.add(balanceInProgBM);
             balanceNotInProgByMonths.add(balanceNotInProgBM);          
         }
    }
    
    private void fillWonBalanceStakeSum()
    {
        for(String date : getDates())
         {
             //wszystkie zaklady
             double stakesSumByDate = DataContainer.dataFromDB.getQueryManager().viewAllStakesByDate(date);
             double wonBalanceByDate = DataContainer.dataFromDB.getQueryManager().viewWonBalanceByDate(date);
             
             getStakesSum().add(stakesSumByDate);
             getWonBalance().add(wonBalanceByDate);
             
             //zaklady w progresjach
             double stakesSumByDateInProg = DataContainer.dataFromDB.getQueryManager().
                     viewAllStakesByDateInProg(date);
             double wonBalanceByDateInProg = DataContainer.dataFromDB.getQueryManager().
                     viewWonBalanceByDateInProg(date);
             
             getStakeSumInProg().add(stakesSumByDateInProg);
             getWonBalanceInProg().add(wonBalanceByDateInProg);
             
             //zaklady nie w progresjach
             double stakesSumByDateNotInProg = DataContainer.dataFromDB.getQueryManager().
                     viewAllStakesByDateNotInProg(date);
             double wonBalanceByDateNotInProg = DataContainer.dataFromDB.getQueryManager().
                     viewWonBalanceByDateNotInProg(date);
             
             stakeSumNotInProg.add(stakesSumByDateNotInProg);
             wonBalanceNotInProg.add(wonBalanceByDateNotInProg);           
         }  
    }
    
    private void fillWonLostByBukmachers()
    {
        for(String bukmacher : bukmachers)
         {
             //wszystkie zakłady
             int wonBetsBB = DataContainer.dataFromDB.getQueryManager().countWonBetsByBukmacher(bukmacher);
             int lostBetsBB = DataContainer.dataFromDB.getQueryManager().countLostBetsByBukmacher(bukmacher);
             
             wonBetsByBukmacher.add(wonBetsBB);
             lostBetsByBukmacher.add(lostBetsBB);
             
             //zaklady w progresjach
             int wonBetsInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countWonBetsInProgByBukmacher(bukmacher);
             int lostBetsInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countLostBetsInProgByBukmacher(bukmacher);
             
             wonBetsInProgByBukmacher.add(wonBetsInProgBB);
             lostBetsInProgByBukmacher.add(lostBetsInProgBB);
             
             //zakłady nie w progresjach
             int wonBetsNotInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countWonBetsNotInProgByBukmacher(bukmacher);
             int lostBetsNotInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countLostBetsNotInProgByBukmacher(bukmacher);
             
             wonBetsNotInProgByBukmacher.add(wonBetsNotInProgBB);
             lostBetsNotInProgByBukmacher.add(lostBetsNotInProgBB);
             
             //miesieczny zysk/strata
             double balanceBB = DataContainer.dataFromDB.getQueryManager().
                     countBalanceByBukmacher(bukmacher);
             double balanceInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countBalanceInProgByBukmacher(bukmacher);
             double balanceNotInProgBB = DataContainer.dataFromDB.getQueryManager().
                     countBalanceNotInProgByBukmacher(bukmacher);
             
             balanceByBukmacher.add(balanceBB);
             balanceInProgByBukmacher.add(balanceInProgBB);
             balanceNotInProgByBukmacher.add(balanceNotInProgBB);
         }
    }
    
    private void fillListYield()
    {
        double balance = 0;
        double stake = 0;     
        double balanceInProg = 0;
        double stakeInProg = 0;
        double balanceNotInProg = 0;
        double stakeNotInProg = 0;      
        
        for(int i=0; i<days.size(); ++i)
        {           
            balance += wonBalance.get(i);
            stake += stakesSum.get(i);
            
            balanceInProg += wonBalanceInProg.get(i);
            stakeInProg += stakeSumInProg.get(i);
            
            balanceNotInProg += wonBalanceNotInProg.get(i);
            stakeNotInProg += stakeSumNotInProg.get(i);
            
            //wszystkie zaklady
            double yieldChange = ((balance - stake) / stake) * 100;
            getYield().add(yieldChange);
            
            //zaklady w progresjach
            double yieldChangeInProg = ((balanceInProg - stakeInProg) / 
                    stakeInProg) * 100;
            yieldInProg.add(yieldChangeInProg);
            
            //zaklady nie w progresjach
            double yieldChangeNotInProg = ((balanceNotInProg - stakeNotInProg)
                    / stakeNotInProg) * 100;
            yieldNotInProg.add(yieldChangeNotInProg);
        }
    }
    
    private double countFinalYield()
    {
        double stake = 0;
        double balance = 0;
        
        for(int i=0; i<days.size(); i++)
        {
            stake += stakesSum.get(i);
            balance += wonBalance.get(i);
        }
        
        return ((balance - stake) / stake) * 100;
    }
    
    private double countFinalYieldNotInProg()
    {
        double stake = 0;
        double balance = 0;
        
        for(int i=0; i<days.size(); i++)
        {
            stake += stakeSumNotInProg.get(i);
            balance += wonBalanceNotInProg.get(i);
        }
        
        return ((balance - stake) / stake) * 100;
    }
    
    private double countFinalYieldInProg()
    {
        double stake = 0;
        double balance = 0;
        
        for(int i=0; i<days.size(); i++)
        {
            stake += stakeSumInProg.get(i);
            balance += wonBalanceInProg.get(i);
        }
        
        return ((balance - stake) / stake) * 100;
    }
       
    public ChartPanel drawEfficiencyChart()
    {
         JFreeChart chart = setEfficiencyChart();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;         
    }
    
    public ChartPanel drawEfficiencyInProgressionChart()
    {
         JFreeChart chart = setEfficiencyInProgressionsChart();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;         
    }
    
    public ChartPanel drawEfficiencyNotInProgChart()
    {
         JFreeChart chart = setEfficiencyNotInProgChart();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;         
    }
    
    public ChartPanel drawYieldByDatesChart()
    {
         JFreeChart chart = setYieldTimeSeries();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;         
    }
    
    public ChartPanel drawYieldByDatesInProgChart()
    {
         JFreeChart chart = setYieldInProgTimeSeries();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;
    }
    
    public ChartPanel drawYieldByDatesNotInProgChart()
    {
         JFreeChart chart = setYieldNotInProgTimeSeries();
         ChartPanel cp = new ChartPanel(chart, false);
         cp.setPreferredSize(new Dimension(300, 300));

         return cp;
    }
    
    public ChartPanel drawWonLostBarChart()
    {
        JFreeChart chart = setWonLostBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostInProgBarChart()
    {
        JFreeChart chart = setWonLostInProgBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostNotInProgBarChart()
    {
        JFreeChart chart = setWonLostNotInProgBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceByBukmacherBarChart()
    {
        JFreeChart chart = setBalanceByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceInProgByBukmacherBarChart()
    {
        JFreeChart chart = setBalanceInProgByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceNotInProgByBukmacherBarChart()
    {
        JFreeChart chart = setBalanceNotInProgByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceBarChart()
    {
        JFreeChart chart = setBalanceBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceInProgBarChart()
    {
        JFreeChart chart = setBalanceInProgBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceNotInProgBarChart()
    {
        JFreeChart chart = setBalanceNotInProgBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostByBukmacherBarChart()
    {
        JFreeChart chart = setWonLostByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostInProgByBukmacherBarChart()
    {
        JFreeChart chart = setWonLostInProgByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostNotInProgByBukmacherBarChart()
    {
        JFreeChart chart = setWonLostNotInProgByBukmacherBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawWonLostByTypeBarChart()
    {
        JFreeChart chart = setWonLostByTypeBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    public ChartPanel drawBalanceByType()
    {
        JFreeChart chart = setBalanceByTypeBarChart();
        ChartPanel cp = new ChartPanel(chart, false);
        cp.setPreferredSize(new Dimension(300, 300));

        return cp;
    }
    
    private JFreeChart setEfficiencyChart()
    {           
        int won = getWonInProg() + getWonNotInProg();
        int lost = getLostInProg() + getLostNotInProg();
        
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Won " + won , won);
        pieDataset.setValue("Lost " + lost, lost);
        
        JFreeChart chart = ChartFactory.createPieChart3D
        ("Efficiency", // Title
        pieDataset, // Dataset
        true, // Show legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
        );
        
        return chart;
    }
    
    private JFreeChart setEfficiencyInProgressionsChart()
    {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Won " + getWonInProg() , getWonInProg());
        pieDataset.setValue("Lost " + getLostInProg(), getLostInProg());
        
        JFreeChart chart = ChartFactory.createPieChart3D
        ("Efficiency in progressions", // Title
        pieDataset, // Dataset
        true, // Show legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
        );
        
        return chart;
    }
    
    private JFreeChart setEfficiencyNotInProgChart()
    {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Won " + getWonNotInProg() , getWonNotInProg());
        pieDataset.setValue("Lost " + getLostNotInProg(), getLostNotInProg());
        
        JFreeChart chart = ChartFactory.createPieChart3D
        ("Efficiency not in progressions", // Title
        pieDataset, // Dataset
        true, // Show legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
        );
        
        return chart;
    }
    
    private JFreeChart setYieldTimeSeries()
    {
        TimeSeries series = new TimeSeries("Yield", Day.class);
        TimeSeries yieldFinal = new TimeSeries("Yield final", Day.class);
        
        double yieldFinalValue = countFinalYield();
        
        for(int i=0; i<days.size(); ++i)
        {
            series.add(days.get(i), getYield().get(i));    
            yieldFinal.add(days.get(i), yieldFinalValue);
        }
        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(yieldFinal);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Yield by date",
            "Date",
            "Yield in %",
            dataset,
            true,
            true,
            false);

        return chart;
    }
    
    private JFreeChart setYieldInProgTimeSeries()
    {
        TimeSeries series = new TimeSeries("Yield", Day.class);
        TimeSeries yieldFinal = new TimeSeries("Yield final", Day.class);
        
        double yieldFinalValue = countFinalYieldInProg();
        
        for(int i=0; i<days.size(); ++i)
        {
            series.add(days.get(i), getYieldInProg().get(i));
            yieldFinal.add(days.get(i), yieldFinalValue);
        }
      
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(yieldFinal);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Yield in progressions by date",
            "Date",
            "Yield in %",
            dataset,
            true,
            true,
            false);

        return chart;
    }
    
    private JFreeChart setYieldNotInProgTimeSeries()
    {
        TimeSeries series = new TimeSeries("Yield", Day.class);
        TimeSeries yieldFinal = new TimeSeries("Yield final", Day.class);
        
        double yieldFinalValue = countFinalYieldNotInProg();
        
        for(int i=0; i<days.size(); ++i)
        {
            series.add(days.get(i), yieldNotInProg.get(i));
            yieldFinal.add(days.get(i), yieldFinalValue);
        }
      
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(yieldFinal);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Yield not in progressions by date",
            "Date",
            "Yield in %",
            dataset,
            true,
            true,
            false);

        return chart;
    }
    
    private JFreeChart setWonLostByTypeBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<types.size(); i++)
        {
            dataSet.addValue(wonBetsByType.get(i), "Won", types.get(i));
            dataSet.addValue(lostBetsByType.get(i), "Lost", types.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost by type",
                "Type",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(wonBetsByBukmacher.get(i), "Won", bukmachers.get(i));
            dataSet.addValue(lostBetsByBukmacher.get(i), "Lost", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost by bukmacher",
                "Bukmacher",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostInProgByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(wonBetsInProgByBukmacher.get(i), "Won", bukmachers.get(i));
            dataSet.addValue(lostBetsInProgByBukmacher.get(i), "Lost", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost in progression by bukmacher",
                "Bukmacher",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostNotInProgByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(wonBetsNotInProgByBukmacher.get(i), "Won", bukmachers.get(i));
            dataSet.addValue(lostBetsNotInProgByBukmacher.get(i), "Lost", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost not in progression by bukmacher",
                "Bukmacher",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(wonBetsByDate.get(i), "Won", yearsMonths.get(i));
            dataSet.addValue(lostBetsByDate.get(i), "Lost", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost",
                "Year-Month",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostInProgBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(wonBetsByDateInProg.get(i), "Won", yearsMonths.get(i));
            dataSet.addValue(lostBetsByDateInProg.get(i), "Lost", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost in progressions",
                "Year-Month",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setWonLostNotInProgBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(wonBetsByDateNotInProg.get(i), "Won", yearsMonths.get(i));
            dataSet.addValue(lostBetsByDateNotInProg.get(i), "Lost", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Won/Lost not in progressions",
                "Year-Month",
                "Amount of bets", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceByTypeBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<types.size(); i++)
        {
            dataSet.addValue(balanceByType.get(i), "Balance", types.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance by type",
                "Type",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(balanceByBukmacher.get(i), "Balance", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance by bukmacher",
                "Bukmacher",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceInProgByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(balanceInProgByBukmacher.get(i), "Balance", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance in progressions by bukmacher",
                "Bukmacher",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceNotInProgByBukmacherBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<bukmachers.size(); i++)
        {
            dataSet.addValue(balanceNotInProgByBukmacher.get(i), "Balance", bukmachers.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance not in progressions by bukmacher",
                "Bukmacher",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(balanceByMonths.get(i), "Balance", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance by months",
                "Year-Month",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceInProgBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(balanceInProgByMonths.get(i), "Balance", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance in progressions by months",
                "Year-Month",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    private JFreeChart setBalanceNotInProgBarChart()
    {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i<yearsMonths.size(); i++)
        {
            dataSet.addValue(balanceNotInProgByMonths.get(i), "Balance", yearsMonths.get(i));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Balance not in progressions by months",
                "Year-Month",
                "Balance", 
                dataSet, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false);
        
        return chart;
    }
    
    public int getWonInProg() 
    {
        return wonInProg;
    }

    public void setWonInProg(int wonInProg) 
    {
        this.wonInProg = wonInProg;
    }

    public int getWonNotInProg() 
    {
        return wonNotInProg;
    }

    public void setWonNotInProg(int wonNotInProg) 
    {
        this.wonNotInProg = wonNotInProg;
    }

    public int getLostInProg() 
    {
        return lostInProg;
    }

    public void setLostInProg(int lostInProg) 
    {
        this.lostInProg = lostInProg;
    }

    public int getLostNotInProg() 
    {
        return lostNotInProg;
    }

    public void setLostNotInProg(int lostNotInProg) 
    {
        this.lostNotInProg = lostNotInProg;
    }

    public LinkedList<String> getDates() 
    {
        return dates;
    }
    
    public void setDates(LinkedList<String> dates) 
    {
        this.dates = dates;
    }
    
    public LinkedList<Day> getDays() 
    {
        return days;
    }

    public void setDays(LinkedList<Day> days) 
    {
        this.days = days;
    }

    public LinkedList<Double> getWonBalance() 
    {
        return wonBalance;
    }

    public void setWonBalance(LinkedList<Double> wonBalance) 
    {
        this.wonBalance = wonBalance;
    }

    public LinkedList<Double> getStakesSum() 
    {
        return stakesSum;
    }

    public void setStakesSum(LinkedList<Double> stakesSum) 
    {
        this.stakesSum = stakesSum;
    }

    public LinkedList<Double> getYield() 
    {
        return yield;
    }

    public void setYield(LinkedList<Double> yield) 
    {
        this.yield = yield;
    }

    public LinkedList<Double> getWonBalanceInProg() 
    {
        return wonBalanceInProg;
    }

    public void setWonBalanceInProg(LinkedList<Double> wonBalanceInProg) 
    {
        this.wonBalanceInProg = wonBalanceInProg;
    }

    public LinkedList<Double> getStakeSumInProg() 
    {
        return stakeSumInProg;
    }

    public void setStakeSumInProg(LinkedList<Double> stakeSumInProg) 
    {
        this.stakeSumInProg = stakeSumInProg;
    }

    public LinkedList<Double> getYieldInProg() 
    {
        return yieldInProg;
    }

    public void setYieldInProg(LinkedList<Double> yieldInProg) 
    {
        this.yieldInProg = yieldInProg;
    }
    
    public LinkedList<Double> getWonBalanceNotInProg() 
    {
        return wonBalanceNotInProg;
    }

    public void setWonBalanceNotInProg(LinkedList<Double> wonBalanceNotInProg) 
    {
        this.wonBalanceNotInProg = wonBalanceNotInProg;
    }

    public LinkedList<Double> getStakeSumNotInProg() 
    {
        return stakeSumNotInProg;
    }

    public void setStakeSumNotInProg(LinkedList<Double> stakeSumNotInProg) 
    {
        this.stakeSumNotInProg = stakeSumNotInProg;
    }

    public LinkedList<Double> getYieldNotInProg() 
    {
        return yieldNotInProg;
    }

    public void setYieldNotInProg(LinkedList<Double> yieldNotInProg) 
    {
        this.yieldNotInProg = yieldNotInProg;
    }

    public LinkedList<String> getYearsMonths() 
    {
        return yearsMonths;
    }

    public void setYearsMonths(LinkedList<String> yearsMonths) 
    {
        this.yearsMonths = yearsMonths;
    }

    public LinkedList<Integer> getWonBetsByDate() 
    {
        return wonBetsByDate;
    }

    public void setWonBetsByDate(LinkedList<Integer> wonBetsByDate) 
    {
        this.wonBetsByDate = wonBetsByDate;
    }

    public LinkedList<Integer> getLostBetsByDate() 
    {
        return lostBetsByDate;
    }

    public void setLostBetsByDate(LinkedList<Integer> lostBetsByDate) 
    {
        this.lostBetsByDate = lostBetsByDate;
    }

    public LinkedList<Integer> getWonBetsByDateInProg() 
    {
        return wonBetsByDateInProg;
    }

    public void setWonBetsByDateInProg(LinkedList<Integer> wonBetsByDateInProg) 
    {
        this.wonBetsByDateInProg = wonBetsByDateInProg;
    }

    public LinkedList<Integer> getLostBetsByDateInProg() 
    {
        return lostBetsByDateInProg;
    }

    public void setLostBetsByDateInProg(LinkedList<Integer> lostBetsByDateInProg) 
    {
        this.lostBetsByDateInProg = lostBetsByDateInProg;
    }

    public LinkedList<Integer> getWonBetsByDateNotInProg() 
    {
        return wonBetsByDateNotInProg;
    }

    public void setWonBetsByDateNotInProg(LinkedList<Integer> wonBetsByDateNotInProg) 
    {
        this.wonBetsByDateNotInProg = wonBetsByDateNotInProg;
    }

    public LinkedList<Integer> getLostBetsByDateNotInProg() 
    {
        return lostBetsByDateNotInProg;
    }

    public void setLostBetsByDateNotInProg(LinkedList<Integer> lostBetsByDateNotInProg) 
    {
        this.lostBetsByDateNotInProg = lostBetsByDateNotInProg;
    }

    public LinkedList<Double> getBalanceByMonths() 
    {
        return balanceByMonths;
    }

    public void setBalanceByMonths(LinkedList<Double> balanceByMonths) 
    {
        this.balanceByMonths = balanceByMonths;
    }

    public LinkedList<Double> getBalanceInProgByMonths() 
    {
        return balanceInProgByMonths;
    }

    public void setBalanceInProgByMonths(LinkedList<Double> balanceInProgByMonths) 
    {
        this.balanceInProgByMonths = balanceInProgByMonths;
    }

    public LinkedList<Double> getBalanceNotInProgByMonths() 
    {
        return balanceNotInProgByMonths;
    }
    
    public void setBalanceNotInProgByMonths(LinkedList<Double> balanceNotInProgByMonths) 
    {
        this.balanceNotInProgByMonths = balanceNotInProgByMonths;
    }

    public LinkedList<String> getBukmachers() 
    {
        return bukmachers;
    }

    public void setBukmachers(LinkedList<String> bukmachers) 
    {
        this.bukmachers = bukmachers;
    }

    public LinkedList<Integer> getWonBetsByBukmacher() 
    {
        return wonBetsByBukmacher;
    }

    public void setWonBetsByBukmacher(LinkedList<Integer> wonBetsByBukmacher) 
    {
        this.wonBetsByBukmacher = wonBetsByBukmacher;
    }

    public LinkedList<Integer> getLostBetsByBukmacher() 
    {
        return lostBetsByBukmacher;
    }

    public void setLostBetsByBukmacher(LinkedList<Integer> lostBetsByBukmacher) 
    {
        this.lostBetsByBukmacher = lostBetsByBukmacher;
    }

    public LinkedList<Integer> getWonBetsInProgByBukmacher() 
    {
        return wonBetsInProgByBukmacher;
    }

    public void setWonBetsInProgByBukmacher(LinkedList<Integer> wonBetsInProgByBukmacher) 
    {
        this.wonBetsInProgByBukmacher = wonBetsInProgByBukmacher;
    }

    public LinkedList<Integer> getLostBetsInProgByBukmacher() 
    {
        return lostBetsInProgByBukmacher;
    }

    public void setLostBetsInProgByBukmacher(LinkedList<Integer> lostBetsInProgByBukmacher) 
    {
        this.lostBetsInProgByBukmacher = lostBetsInProgByBukmacher;
    }

    public LinkedList<Integer> getWonBetsNotInProgByBukmacher() 
    {
        return wonBetsNotInProgByBukmacher;
    }

    public void setWonBetsNotInProgByBukmacher(LinkedList<Integer> wonBetsNotInProgByBukmacher) 
    {
        this.wonBetsNotInProgByBukmacher = wonBetsNotInProgByBukmacher;
    }

    public LinkedList<Integer> getLostBetsNotInProgByBukmacher() 
    {
        return lostBetsNotInProgByBukmacher;
    }

    public void setLostBetsNotInProgByBukmacher(LinkedList<Integer> lostBetsNotInProgByBukmacher) 
    {
        this.lostBetsNotInProgByBukmacher = lostBetsNotInProgByBukmacher;
    }

    public LinkedList<Double> getBalanceByBukmacher() 
    {
        return balanceByBukmacher;
    }

    public void setBalanceByBukmacher(LinkedList<Double> balanceByBukmacher) 
    {
        this.balanceByBukmacher = balanceByBukmacher;
    }

    public LinkedList<Double> getBalanceInProgByBukmacher() 
    {
        return balanceInProgByBukmacher;
    }

    public void setBalanceInProgByBukmacher(LinkedList<Double> balanceInProgByBukmacher) 
    {
        this.balanceInProgByBukmacher = balanceInProgByBukmacher;
    }

    public LinkedList<Double> getBalanceNotInProgByBukmacher() 
    {
        return balanceNotInProgByBukmacher;
    }

    public void setBalanceNotInProgByBukmacher(LinkedList<Double> balanceNotInProgByBukmacher) 
    {
        this.balanceNotInProgByBukmacher = balanceNotInProgByBukmacher;
    }

    public LinkedList<Integer> getWonBetsByType() 
    {
        return wonBetsByType;
    }

    public void setWonBetsByType(LinkedList<Integer> wonBetsByType) 
    {
        this.wonBetsByType = wonBetsByType;
    }

    public LinkedList<Integer> getLostBetsByType() 
    {
        return lostBetsByType;
    }

    public void setLostBetsByType(LinkedList<Integer> lostBetsByType) 
    {
        this.lostBetsByType = lostBetsByType;
    }

    public LinkedList<Double> getBalanceByType() 
    {
        return balanceByType;
    }

    public void setBalanceByType(LinkedList<Double> balanceByType) 
    {
        this.balanceByType = balanceByType;
    }
}
