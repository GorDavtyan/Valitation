package Valitation;

import java.util.ArrayList;
import java.util.Scanner;

public class EmailValidation {
    Scanner in = new Scanner(System.in);
    private String email;

    public void validEmail() {
        System.out.println("Enter email");
        email = in.nextLine();
        ArrayList<String> domenmail = new ArrayList<String>();
        emaillSize();
        inputUniqSymbol();
//        localAndDomen(email);
        symbolLocal();
        localdot();
        localDoubleDot();
        inputArrayList(domenmail);
//        addArrayList(domenmail);
        domen(domenmail);
    }
    public void inputArrayList(ArrayList<String> domenmail) {
        domenmail.add("mail.ru");
        domenmail.add("gmail.com");
        domenmail.add("list.ru");
        domenmail.add("inbox.ru");
        domenmail.add("bk.ru");
    }

    public void addArrayList(ArrayList<String> domenmail) {
        String list;
        String test;
        do {
            System.out.println("enter the list for domen mail");
            list = in.next();
            domenmail.add(list);
            System.out.println("uzum es el avaleacnel enter y / n");
            test = in.next();
        } while (test.equalsIgnoreCase("y"));
    }

    public void emaillSize() {
        try {
            if (email.length() > 64) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Mail character length shouldn't be longer than 64");
        }
    }

    public void inputUniqSymbol() {
        try {
            if (email.lastIndexOf('@') == email.indexOf('@')) {
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Core than one '@'");
            return;
        }
    }

//    public void localAndDomen(String email) {
//        local = "";
//        domen = "";
//        int i = 0;
//        while (i != email.indexOf('@')) {
//            local = local + email.charAt(i);
//            ++i;
//        }
//        ++i;
//        while (i != email.length()) {
//            domen = domen + email.charAt(i);
//            ++i;
//        }
//        System.out.println(domen);
//    }

    public void symbolLocal() {
        boolean test = true;
        for (int i = 0; i < email.indexOf('@'); i++) {
            char ch = email.charAt(i);
            if (!(ch == '!' || (ch >= '#' && ch <= 39) || ch == '*' || ch == '+' || (ch >= '-' && ch < '9') || ch == '='
                    || ch == '?' || (ch >= 'A' && ch <= 'Z') | (ch >= 'a' && ch <= 'z') || ch == '^' || ch == '_'
                    || ch == '`'
                    || (ch >= '{' && ch <= '~'))) {
                test = false;
            }
        }
        try {
            if (test == false) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Corbidden character");
            return;
        }
    }


    public void localdot() {
        try {
            if ((email.charAt(0) == '.')) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Cirst character can't be dot '.'");
            return;
        }
    }

    public void localDoubleDot() {
        boolean test = true;
        for (int i = 0; i < email.indexOf('@'); i++) {
            char ch = email.charAt(i);
            if (ch == '.' && email.charAt(i + 1) == '.') {
                test = false;
            }
        }
        try {
            if (test == false) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Can't write two dots together '..'");
            return;
        }
    }

    public void domen(ArrayList<String> domenmail) {
        boolean test = false;
        for (int i = 0; i < domenmail.size(); i++) {
            if (email.substring(email.indexOf('@') + 1).equals(domenmail.get(i))) {
                test = true;
                break;
            }
        }
        try {
            if (test == false) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Domain does not match");

        }
    }
}
