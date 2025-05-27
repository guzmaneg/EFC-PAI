/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public class DateUtils {
    
    public static Date localDate2SqlDate(LocalDate localDate) {
        
        return Date.valueOf(localDate);
    }
    
}
