package test.com.solutions;


import org.junit.Assert;
import org.junit.Test;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class TestPasswordGeneration {

    public static final String PASSWORD_PATTERN_4_UNIQUE_CLASSES = "^.*(?=.{8,40})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=]).*$";

    @Test
    public void testRandomPasswordGeneration(){

        for (int i=0; i < 1000 ; i++) {
            PasswordGenerator gen = new PasswordGenerator();
            CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
            CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
            lowerCaseRule.setNumberOfCharacters(2);

            CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
            CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
            upperCaseRule.setNumberOfCharacters(2);

            CharacterData digitChars = EnglishCharacterData.Digit;
            CharacterRule digitRule = new CharacterRule(digitChars);
            digitRule.setNumberOfCharacters(2);

            CharacterData specialChars = new CharacterData() {
                public String getErrorCode() {
                    return "9999";
                }

                public String getCharacters() {
                    return "!@#$%^&*+=";
                }
            };
            CharacterRule splCharRule = new CharacterRule(specialChars);
            splCharRule.setNumberOfCharacters(2);

            String password = gen.generatePassword(10, splCharRule, lowerCaseRule,
                    upperCaseRule, digitRule);

            Assert.assertTrue(password.matches(PASSWORD_PATTERN_4_UNIQUE_CLASSES));


            System.out.println(password);
        }
    }
}
