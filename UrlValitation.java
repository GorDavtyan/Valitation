package Valitation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class UrlValitation {
    Scanner in = new Scanner(System.in);
    private String url;

    public void urlValidation() {
        System.out.println("Enter the url link you want to check");
        url = in.nextLine();
        String regex = "^((https|http)://)(www.)?([a-zA-Z0-9@:%._\\+~#?&//=-]){2,256}\\.([a-z]){2,6}\\b([a-zA-z0-9@:%._\\+~#?&//=-]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        try {
            if (!matcher.matches()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("No such url can exist");
            return;
        }
    }
}
