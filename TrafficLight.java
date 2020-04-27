/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrafficLight;

import java.util.Scanner;

/**
 *
 * @author dhwani
 */
public class TrafficLight 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        TrafficLight trafficMonitor = new TrafficLight();
        //This is the monitor object for trafficLight
        
        Light trafficLightA = new Light("A", trafficMonitor);
        Light trafficLightB = new Light("B", trafficMonitor);
        //These are traffic Light instances
        
        Thread A = new Thread(trafficLightA);
        A.start();
        
        Thread B = new Thread(trafficLightB);
        B.start();
        
        String input = "";
        System.out.println("Please enter the traffic light you want to turn on(either A or B) :");
        
        do
        {
            input = scanner.nextLine(); 
            
            switch(input)
            {
                case "A":
                    trafficLightA.setGreen();
                    trafficLightA.setOrange();
                    break;
                case "B":
                    trafficLightB.setGreen();
                    trafficLightB.setOrange();
                    break;
                case "E":
                    System.out.println("Program Exits!!");
                    break;
                case "a":
                    trafficLightA.setGreen();
                    trafficLightA.setOrange();
                    break;
                case "b":
                    trafficLightB.setGreen();
                    trafficLightB.setOrange();  
                    break;
                case "e":
                    System.out.println("Program Exits!!");
                    break;
                default:
                    System.out.println("Invalid input!!");
                    break;
                
            }
            
        }while(!input.equalsIgnoreCase("E"));
       
        
        //Ending the programme
        trafficLightA.setRed();
        trafficLightA.stopLight();
        
        trafficLightB.setRed();
        trafficLightB.stopLight();
        
    }    
}