import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class DateValitation {
    Scanner in = new Scanner(System.in);
    private String date;

    public void dateValidation() {
        System.out.println("enter your date of birth DD/MM/YYYY");
        date = in.nextLine();
        dateValid();
    }

    public void dateValid() {
        final String regex = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[1-9]|1[0-2])/(19[0-9][0-9]|20[0-2][0-9])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        matcher.matches();
        try {
            if (!matcher.matches()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Does not match the date syntax");
        }
        String day = matcher.group(1);
        String month = matcher.group(2);
        try {
            if (day.equals("31") && (month.equals("04") || month.equals("06") || month.equals("09") || month.equals(11))) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("This month does not have 31 days!");
        }
        int year = Integer.parseInt(matcher.group(3));
        if (!LeepYear(year)) {
            try {
                if (month.equals("02") && day.equals("29")) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("That year is not a leap year, February has 28 day");
            }
        }
    }

    public boolean LeepYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
