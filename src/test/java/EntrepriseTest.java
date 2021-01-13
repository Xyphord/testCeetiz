import fr.ceetiz.test.domain.AutoEntrepreneur;
import fr.ceetiz.test.domain.SAS;
import fr.ceetiz.test.domain.Siret;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EntrepriseTest extends TestCase {
    private SAS entrepriseSas = new SAS();
    private AutoEntrepreneur autoEntrepreneur = new AutoEntrepreneur();

    @Before
    public void init(){
        autoEntrepreneur.setCA(1543);
        autoEntrepreneur.setSiret(new Siret("52995748200043"));
        autoEntrepreneur.setDenomination("Test auto entreprise");
    }

    @Test
    public void testCalculateTaxeSasOK(){
        entrepriseSas.setCA(1515);
        entrepriseSas.setSiret(new Siret("529 957 482 00043"));
        entrepriseSas.setAdresse("5 rue des corniches 54410 Onville");
        Assert.assertTrue(entrepriseSas.calculImpots() > 0);
    }

    @Test
    public void testSasSiretNullAndCaZeroReturnZeroImpots(){
        entrepriseSas.setCA(0);
        entrepriseSas.setSiret(null);
        entrepriseSas.setAdresse("5 rue des corniches 54410 Onville");
        Assert.assertEquals(0, entrepriseSas.calculImpots(), 0.0);
    }

    @Test
    public void testSasMethodinfoEntrepriseWithEmptyConstructorReturnOk(){
        SAS entrepriseSas2 = new SAS();
        String resultat = entrepriseSas2.infoEntreprise();
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
        assertEquals(0, entrepriseSas2.calculImpots());
    }

    @Test
    public void testAutoEntrepreneuretSasImpotsDifferent(){
        entrepriseSas.setCA(autoEntrepreneur.getCA());
        assertTrue(entrepriseSas.calculImpots()> autoEntrepreneur.calculImpots());
    }
}
