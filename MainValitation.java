import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainValitation {
    public static void main(String[] args) throws Exception{
        EmailValidation emailValidation = new EmailValidation();
        emailValidation.validEmail();
        PhoneNumberValidation phoneNumberValidation = new PhoneNumberValidation();
        phoneNumberValidation.phoneNumbervalid();
        CreditCardsValitation creditCardsValitation = new CreditCardsValitation();
        creditCardsValitation.cretiteCardValid();
        UrlValitation urlValitation = new UrlValitation();
        urlValitation.urlValidation();
    }
}

