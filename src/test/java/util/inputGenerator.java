package util;
import org.apache.commons.text.RandomStringGenerator;
public class inputGenerator {
    public inputGenerator(){

    }
    public String randomString(int length){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLetters = generator.generate(length);
        return randomLetters;
    }
}
