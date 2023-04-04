package me.test.TimeToWords.service.impl;

import me.test.TimeToWords.service.TimeService;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {
    private static final String[] HOURS = {
            "midnight", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "midday", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "midnight"
    };
    private static final String[] MINUTES = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
            "twenty seven", "twenty eight", "twenty nine", "thirty",
            "thirty one", "thirty two", "thirty three", "thirty four", "thirty five",
            "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
            "forty one", "forty two", "forty three", "forty four", "forty five",
            "forty six", "forty seven", "forty eight", "forty nine", "fifty",
            "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
            "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    @Override
    public String getTimeInWords(String time) {
        if (time.equals("12:00")) {
            return "It's Midday";
        } else if (time.equals("00:00")) {
            return "It's Midnight";
        }

        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        StringBuilder builder = new StringBuilder();
        builder.append("It's ");

        if (hour == 12) {
            builder.append(HOURS[hour]);
        } else {
            builder.append(HOURS[hour % 12]);
        }

        if (minute != 0) {
            builder.append(" ");
            builder.append(MINUTES[minute]);
        }

        return builder.toString();
    }
}
