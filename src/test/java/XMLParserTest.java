import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;


public class XMLParserTest {
    XMLParser xmlReader = new XMLParser();

    @Test
    public void shouldCheckIfMapFromParsedXMLFileContainKeyUsdAndValue10991() {
        //given
        String fileToRead = "rate.xml";
        //when
        Map<String, Double> sut = xmlReader.read(fileToRead);
        //then
        assertThat(sut,IsMapContaining.hasEntry("USD",1.0991));
    }

    @Test
    public void shouldReturnSizeofMapParsedFromXMLEqualTo32() {
        //given
        String fileToRead = "rate.xml";
        //when
        Map<String, Double> sut = xmlReader.read(fileToRead);
        //then
        assertThat(sut.size(),is(32));
    }
}