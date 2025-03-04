package Week1.Hello;
// Om deze testen uit te voeren heb je JUnit 4 nodig (NIET versie 5)
// Als onderstaande tekst in het rood staat, doe dan het volgende:
// rechtermuisknop (op rode tekst "junit") > Show Context Actions > add JUnit 4 to classpath
import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void testHelloStart() {
        Thing thing = new World();
        Assert.assertTrue(
            "Your greeting should start with 'Hello'",
            thing.hello().startsWith("Hello")
        );
    }

}
