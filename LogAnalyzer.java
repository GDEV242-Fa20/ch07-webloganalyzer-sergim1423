
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Sergius Manolov.
 * @version    2020.10.21.
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

     /**
     * Main method of LogAnalyzer class
     */
    public static void main(String[]args)
    {
        //creation of object LogAnalyzer
        LogAnalyzer analyze = new LogAnalyzer();
        //analyzing log from file
        analyze.analyzeHourlyData();
        //print number of accesses
        int numberofAccesses = analyze.numberOfAccesses();
        System.out.println("Number of Accesses:" 
        + numberofAccesses);
    }
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }
    
    
/**
 * Return number of accesses
 * Exercise 7.14
 */ 
public int numberOfAccesses()
{
    int total = 0;
    for(int hour=0;hour<hourCounts.length; hour++){
        total +=hourCounts[hour];
    }
    return total;
}
    
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Busiest hour method
     */
    public int busiestHour()
    {
        //creating variables maxHour, holds value of hour in
        //max day
        int maxHour = 0;
        for(int hour = 1; hour<hourCounts.length;hour++)
        {
            //compare values of hourCounts particular hour
            //to hour with max count
            if(hourCounts[hour]>hourCounts[maxHour])
            {
                maxHour=hour;
            }
        }
        
        return maxHour;
    }

    /**
     * Quietest hour method
     */
    public int quietestHour()
    {
        int quietestHour(int[]hourCounts)
        {
            int quietest=hourCounts[0];
            for(int i=0; i<hourCounts.length;i++)
            {
                if(hourCounts[i]> 0 &&
                hourCounts[i]>quietest)
                quietest=hourCounts[i];
            }
            return quietest; //quietest element is returning here
        }
        
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
