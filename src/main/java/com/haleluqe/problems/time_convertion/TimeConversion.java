package com.haleluqe.problems.time_convertion;

import java.io.*;

public class TimeConversion {

    private static String timeConversion(String s) {
        String amPm = s.substring(s.length() - 2);
        String hour = s.substring(0, 2);
        Integer intHour = Integer.parseInt(s.substring(0, 2));
        String minute = s.substring(3, 5);
        String second = s.substring(6, 8);

        if (amPm.equals("AM") && hour.equals("12")) {
            hour = "00";
        }
        if (amPm.equals("PM") && intHour < 12) {
            intHour += 12;
            hour = intHour.toString();
        }

        return  hour + ":" + minute + ":" + second;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
