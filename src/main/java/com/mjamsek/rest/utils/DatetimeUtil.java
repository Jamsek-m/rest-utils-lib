/*
 *  Copyright (c) 2019 Miha Jamsek
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mjamsek.rest.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Utility class for date and time
 *
 * @author Miha Jamsek
 * @since 2.0.0
 */
public class DatetimeUtil {
    
    /**
     * Returns date that is <code>daysBefore</code> days before current time
     *
     * @param daysBefore number of days
     * @return date, <code>daysBefore</code> days ago
     */
    public static Date getDaysBeforeNow(int daysBefore) {
        return changeDateBy(24 * -daysBefore, Calendar.HOUR);
    }
    
    /**
     * Returns date that is <code>daysAfter</code> days after current time
     *
     * @param daysAfter number of days
     * @return date, <code>daysAfter</code> days from now
     */
    public static Date getDaysAfterNow(int daysAfter) {
        return changeDateBy(24 * daysAfter, Calendar.HOUR);
    }
    
    /**
     * Returns date that is <code>hoursBefore</code> hours before current time
     *
     * @param hoursBefore number of hours
     * @return date, <code>hoursBefore</code> hours ago
     */
    public static Date getHoursBeforeNow(int hoursBefore) {
        return changeDateBy(-hoursBefore, Calendar.HOUR);
    }
    
    /**
     * Returns date that is <code>hoursAfter</code> hours after current time
     *
     * @param hoursAfter number of hours
     * @return date, <code>hoursBefore</code> hours from now
     */
    public static Date getHoursAfterNow(int hoursAfter) {
        return changeDateBy(hoursAfter, Calendar.HOUR);
    }
    
    /**
     * Returns date that is <code>minutesAfter</code> minutes after current time
     *
     * @param minutesAfter number of minutes
     * @return date, <code>minutesAfter</code> minutes from now
     */
    public static Date getMinutesAfterNow(int minutesAfter) {
        return changeDateBy(minutesAfter, Calendar.MINUTE);
    }
    
    /**
     * Returns date that is <code>minutesBefore</code> minutes before current time
     *
     * @param minutesBefore number of minutes
     * @return date, <code>minutesBefore</code> minutes ago
     */
    public static Date getMinutesBeforeNow(int minutesBefore) {
        return changeDateBy(-minutesBefore, Calendar.MINUTE);
    }
    
    /**
     * Subtracts <code>date2</code> from <code>date1</code> (<code>date 1 - date2</code>) and returns difference in minutes
     *
     * @param date1 first operator
     * @param date2 second operator
     * @return difference in minutes
     */
    public static long getDiffInMinutes(Date date1, Date date2) {
        long diffInMillis = date1.getTime() - date2.getTime();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
    
    /**
     * Changes date forward/backward for a specified amount of given units
     *
     * @param diff         move datum for this amount (negative value moves it backward in time, positive, forward in time)
     * @param timeConstant time constant from {@link Calendar} class
     * @return date that is <code>diff</code> units forward/backward in time
     */
    public static Date changeDateBy(int diff, int timeConstant) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(timeConstant, diff);
        return calendar.getTime();
    }
    
}
