/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ConditionalsPractice;

import java.util.Date;

public class App {

    public static double regularRate = 11.11;
    public static double summerRate = 22.22;
    public static double winterRate = 7.77;
    //North America Season Settings
    public static Date naSummerStart = new Date(2019, 5, 31);
    public static Date naSummerEnd = new Date(2019, 9, 1);
    public static Date naWinterStart = new Date(2019, 12, 1);
    public static Date naWinterEnd = new Date(2020, 2, 28);
    //South America Season Settings
    public static Date saSummerStart = new Date(2019, 12, 1);
    public static Date saSummerEnd = new Date(2020, 2, 28);
    public static Date saWinterStart = new Date(2019, 5, 31);
    public static Date saWinterEnd = new Date(2019, 9, 1);


    public static void main(String[] args) {


        double yourRate = 11.11;

        //Run the senerios
        double naSummerSenerio = calculateRate("North America", new Date(2019, 7, 04));
        double naWinterSenerio = calculateRate("North America", new Date(2019, 12, 04));
        double regularSenerio = calculateRate("North America", new Date(2019, 5, 04));
        double saSummerSenerio = calculateRate("South America", new Date(2020, 1, 07));
        double saWinterSenerio = calculateRate("South America", new Date(2019, 8, 17));


        System.out.println("--North America--");
        System.out.println("Summer senerio rate is: " + naSummerSenerio);
        System.out.println("Winter senerio rate is: " + naWinterSenerio);
        System.out.println("Regular senerio rate is: " + regularSenerio);
        System.out.println("--South America--");
        System.out.println("Summer senerio rate is: " + saSummerSenerio);
        System.out.println("Winter senerio rate is: " + saWinterSenerio);


    }


    private static double calculateRate(String position, Date day) {
        double currentRate = 0.0;


        if (position == "North America") {

            if (day.compareTo(naSummerStart) > 0 && day.compareTo(naSummerEnd) < 0) {
                System.out.println("It's summer");
                currentRate = summerRate;
            } else if (day.compareTo(naWinterStart) > 0 && day.compareTo(naWinterEnd) < 0) {
                System.out.println("It's Winter");
                currentRate = winterRate;
            } else {
                return regularRate;
            }

        } else if (position == "South America") {

            if (day.compareTo(naSummerStart) > 0 && day.compareTo(naSummerEnd) < 0) {
                System.out.println("It's summer");
                currentRate = summerRate;
            } else if (day.compareTo(naWinterStart) > 0 && day.compareTo(naWinterEnd) < 0) {
                System.out.println("It's Winter");
                currentRate = winterRate;
            } else {
                return regularRate;
            }

        } else {
            System.exit(0);
        }


        return currentRate;
    }
}