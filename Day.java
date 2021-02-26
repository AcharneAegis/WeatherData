
/**
 *
 * @author Payton
 */


public class Day {
    
    private int Month;
    private int Day;
    private int Year;
    private double lowTemp;
    private double highTemp;
    private double rainFall;
    
    public void Day(){
    }
    
    //**********setter methods************//
    public void setMonth(int month){
        Month = month;
    }
    
    public void setDay(int day){
        Day = day;
    }
    
    public void setYear(int year){
        Year = year;
    }
    
    public void setLTemp(double lTemp){
        lowTemp = lTemp;
    }
    
    public void setHTemp(double hTemp){
        highTemp = hTemp;
    }
    
    public void setrainFall(double rFall){
        rainFall = rFall;
    }
    
    //**********getter methods************//
    public int getMonth(){
        return Month;
    }
    
    public int getDay(){
        return Day;
    }
    
    public int getYear(){
        return Year;
    }
    
    public double getLTemp(){
        return lowTemp;
    }
    
    public double getHTemp(){
        return highTemp;
    }
    
    public double getrainFall(){
        return rainFall;
    }
    
    
    @Override public String toString(){
        return (Month + "/" + Day + "/" + Year + ", " + lowTemp + ", " + highTemp + ", " + rainFall);
    }
    
}
