/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Windyl
 */
public class DateUtil {
    LocalDate date = LocalDate.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
    String formatted_date = date.format(format);
    LocalTime current_time = LocalTime.now();
     
    
    public String getFormattedDate(){
        
        return this.formatted_date;
    }
    
    
    public String getCurrentTime(){
        return current_time.getHour()+":"+current_time.getMinute()+":"+current_time.getSecond();
    }
    
    
    public String getCurrentDayTime(LocalTime time){
  
      String[] split_time = String.valueOf(time).split(":");
      int current_time = Integer.parseInt(split_time[0]);
        

    if(current_time > 13 && current_time < 24){
        return "PM";
        
    }else if(current_time > 1 && current_time < 12){
        return "AM";
    }
    
       return null;
    }
    

}
