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
public final class DateUtils {

    private DateUtils() {
    }
    
    public static Date localDate2SqlDate(LocalDate aLocalDate) {
        
        return Date.valueOf(aLocalDate);
    }
    
    public static LocalDate sqlDate2LocalDate(Date aSqlDate) {
        
        return aSqlDate.toLocalDate();
    }
}
