/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrafficLight;

/**
 *
 * @author dhwani
 */
public class Light implements Runnable
{
    private String light_name;
    private TrafficLight trafficMonitor;
    private boolean isOn;
    private boolean isOff;

    public Light(String light_name, TrafficLight trafficMonitor) 
    {//Constructor Light
        
        this.light_name = light_name;
        this.trafficMonitor = trafficMonitor;
        this.isOff = false;
        this.isOn = false;  
    }
    
    public void setGreen()//Activating the greenLight
    {
        isOn = true;
    }
    
    public void setOrange()   // Activating the orangeLight
    {
        isOn = true;
    }
    
    public void setRed()//Activating the redLight
    {
        isOn = false;
    }
     
    public boolean isOn()//Returning the value for isOn
    {
        return isOn;
    }
    
    public boolean stopLight()//Returning the value for isOff
    {
          return isOff = true;
    }

    @Override
    public void run() 
    {   
        while(!isOff)
        {
            synchronized(trafficMonitor)
                //When thread A is executing the synchronized method for traffic monitor the thread B which
                //will invoke synchronized method for traffic monitor will block untill thread A is done with traffic monitor
            {
                try
                {
                    while(isOn)
                    {
                        setGreen();
                        System.out.println(light_name+ " : It's Green!! GO!!");
                        Thread.sleep(5000);//The light will be active for 5 seconds
                        
                        setOrange();
                        System.out.println(light_name + ": It's Orange!! Prepare to stop!!");
                        Thread.sleep(5000);  // The light will be active for 5 seconds
                        
                        setRed();
                        System.out.println(light_name+ " : It's Red!! STOP!!");
                        System.out.println("Please enter the traffic light you want to turn on(either A or B) :");
                        
                        trafficMonitor.notifyAll();
                        //wakes up thread B on taffic Monitor object and avoids Deadlock        
                    }
                }
                catch(InterruptedException e)
                {
                    System.out.println("Interrupted");
                }
            }
        }
    }
}