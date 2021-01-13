import fr.ceetiz.test.domain.Siret;
import junit.framework.TestCase;
import org.junit.Assert;

public class SiretTest  extends TestCase {

    public void testVerifySiretNullpointerReturnIllegalArgumentException(){
        try {
            new Siret(null);
            Assert.fail();
        } catch(Exception ex){
            assertEquals(ex.getClass(), IllegalArgumentException.class);
          //  ex.printStackTrace();
        }
    }

    public void testVerifyEmptySiretReturnIllegalArgumentException(){
        try {
            new Siret("null");
            Assert.fail();
        } catch(Exception ex){
            assertEquals(ex.getClass(), IllegalArgumentException.class);
           // ex.printStackTrace();
        }

    }

}
