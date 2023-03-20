package Valitation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardsValitation {
     Scanner in = new Scanner(System.in);
        private String cretiteCarde;

        public void cretiteCardValid() {
            System.out.println("Enter number for creditCard");
            cretiteCarde = in.nextLine();
            creditCardeSpace();
            crediteCardeSymbol();
            methodLuhn();
            creditCardsFirsNumber();
        }

        public void creditCardeSpace() {
            StringBuilder str = new StringBuilder(cretiteCarde.replaceAll("\\s", ""));
            int i = 4;
            while (i < str.length() - 3) {
                str = str.insert(i, ' ');
                i += 5;
            }
        }

        public void crediteCardeSymbol() {
            boolean test = true;
            for (int i = 0; i < cretiteCarde.length(); i++) {
                if ((cretiteCarde.charAt(i) < 48 || cretiteCarde.charAt(i) > 57) && cretiteCarde.charAt(i) != ' ') {
                    test = false;
                    break;
                }
            }
            try {
                if (test == false) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Wrong character entered");
                return;
            }
        }

        public void methodLuhn() {
            StringBuilder str = new StringBuilder(cretiteCarde.replaceAll("\\s", ""));
            System.out.println(str);
            int num = 0;
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    res = Integer.parseInt(String.valueOf(str.charAt(i))) * 2;
                }
                if (res > 9) {
                    num = num + res / 10 + res % 10;
                } else {
                    num += res;
                }
            }
            try {
                if (num % 10 != 0) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("This cannot be a card number");
                return;
            }
        }

        public void creditCardsFirsNumber() {
            String regex = "^((?<visa>4[0-9]{13,16})|(?<masterCard>5[1-5][0-9]{14})|(?<americanExxpres>3[4-7][0-9]{13}))";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cretiteCarde.replaceAll("\\s", ""));
            try {
                if (!matcher.matches()) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("There is no such bank card");
                return;
            }
        }
    }


