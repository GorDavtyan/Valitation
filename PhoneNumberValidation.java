import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumberValidation {
    Scanner in = new Scanner(System.in);
    private String phoneNumber;

    public void phoneNumbervalid() {
        System.out.println("Enter phoneNumber");
        phoneNumber = in.nextLine();
        ArrayList<String> phoneNumberCode = new ArrayList<String>();
        checkPhoneNumberSize();
        plus();
        codePhoneNumber();
        checkSymbols();
        checkZero();
        addPhoneNumberCode(phoneNumberCode);
        codePhoneNumberes(phoneNumberCode);
    }

    public void plus() {
        try {
            if (phoneNumber.charAt(0) != '+') {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("The first term must be plus");
        }
    }


    public void codePhoneNumber() {
        try {
            if (!(phoneNumber.substring(1, 4).equals("374"))) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("The phone number code is not Armenian");
        }
    }

    public void checkPhoneNumberSize() {
        try {
            if (phoneNumber.length() != 12) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Incorrect number");
        }
    }

    public void checkSymbols() {
        boolean test = false;
        for (int i = 1; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) < 47 || phoneNumber.charAt(i) > 58) {
                test = true;
                break;
            }
        }
        try {
            if (test == true) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Not allowed symbol");
        }
    }

    public void checkZero() {
        try {
            if (phoneNumber.charAt(4) == '0') {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Invalid for number");
        }
    }

    public void addPhoneNumberCode(ArrayList<String> phoneNumberCode) {
        phoneNumberCode.add("91");
        phoneNumberCode.add("96");
        phoneNumberCode.add("99");
        phoneNumberCode.add("43");
        phoneNumberCode.add("77");
        phoneNumberCode.add("93");
        phoneNumberCode.add("94");
        phoneNumberCode.add("55");
        phoneNumberCode.add("95");
        phoneNumberCode.add("41");
        phoneNumberCode.add("33");
    }

    public void codePhoneNumberes(ArrayList<String> phoneNumberCode) {
        boolean test = false;
        for (int i = 0; i < phoneNumberCode.size(); i++) {
            if (phoneNumber.substring(4, 6).equals(phoneNumberCode.get(i))) {
                test = true;
                break;
            }
        }
        try {
            if (test == false) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("The telephone code is not a code for Armenia");
        }
    }
}
