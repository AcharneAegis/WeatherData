
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author Payton
 */
public class ProjectTwoMain {
    public static void main(String[] args)throws IOException{
        
        Scanner inputFile = new Scanner(Paths.get("WeatherDataFile.csv"), "UTF-8");
        ArrayList<Day> Days = new ArrayList();
        
        Scanner in = new Scanner(System.in);
        
        while (inputFile.hasNextLine()){
            String line = inputFile.nextLine();
            
            Day d = new Day();
            
            String[] dateSplit = new String[6];
            double[] recastData = new double[6];
            

            
            dateSplit = line.split("(/)|(\\,)");
            
            for(int i = 0; i <6; i++){
                recastData[i] = Double.parseDouble(dateSplit[i]);
            }
            
            
            d.setMonth((int)recastData[0]);
            d.setDay((int)recastData[1]);
            d.setYear((int)recastData[2]);
            d.setLTemp(recastData[3]);
            d.setHTemp(recastData[4]);
            d.setrainFall(recastData[5]);
            
            
            
            Days.add(d);
        }
        
        int userDay = 1, userMonth =1;
        
        while (userDay != 0){
            System.out.println("Please enter a month and day separated by a space (ie: 1 10)");
            System.out.println("If you would like to exit, enter a 0 for both");
            userMonth = in.nextInt();
            userDay = in.nextInt();
            double lowestTemp = 100, highestTemp= -100, avgLow = 0, avgHigh = 0, avgRain = 0, dayCount = 0;
            for (Day someDay : Days){
                if ((userDay == someDay.getDay()) && (userMonth == someDay.getMonth())){
                    
                    //Updating Extreme Temps

                    if (lowestTemp > someDay.getLTemp()){
                        lowestTemp = someDay.getLTemp();
                    }
                    if (highestTemp < someDay.getHTemp()){
                        highestTemp = someDay.getHTemp();
                    }
                    
                    //Calculating for Average Values
                    
                    avgLow += someDay.getLTemp();
                    avgHigh += someDay.getHTemp();
                    avgRain += someDay.getrainFall();
                    dayCount++;
                }
            }
            
            //Finishing and rounding Average values
            avgLow = (avgLow/ dayCount) * 100;
            avgLow = Math.round(avgLow);
            avgLow = avgLow/100;
            
            avgHigh = (avgHigh/ dayCount) *100;
            avgHigh = Math.round(avgHigh);
            avgHigh= avgHigh/100;
            
            avgRain = (avgRain/ dayCount)*10000;
            avgRain= Math.round(avgRain);
            avgRain = avgRain/10000;
            
            
            // Printing findings to the User
            System.out.println("We found " + (int) dayCount + " days that match the date you provided.");
            System.out.println("The highest temp recorded was: " + highestTemp);
            System.out.println("The lowest temp recorded was: " + lowestTemp);
            System.out.println("The average high temp was: " + avgHigh);
            System.out.println("The average low temp was: " + avgLow);
            System.out.println("The average percipitation recorded was: " + avgRain + "\n");
        }
        
        System.out.println("Thank you for using this application!");
    }
}
