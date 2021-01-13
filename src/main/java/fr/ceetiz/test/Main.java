package fr.ceetiz.test;

import fr.ceetiz.test.domain.AutoEntrepreneur;
import fr.ceetiz.test.domain.SAS;
import fr.ceetiz.test.domain.Siret;

import java.util.logging.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger("Main");

    public static void main(String[] args)
    {
        SAS entrepriseSas = new SAS();
        AutoEntrepreneur autoEntrepreneur = new AutoEntrepreneur();
        LOGGER.info("\r"+entrepriseSas.infoEntreprise()+"\r");

        entrepriseSas.setCA(1513135);
        entrepriseSas.setSiret(new Siret("529   95748200  0  43"));
        entrepriseSas.setAdresse("5 rue des corniches 54410 Onville");
        LOGGER.info("\r"+entrepriseSas.infoEntreprise()+"\r");

        autoEntrepreneur.setCA(1543);
        autoEntrepreneur.setSiret(new Siret("52995748200043"));
        autoEntrepreneur.setDenomination("Test auto entreprise");
        LOGGER.info("\r"+autoEntrepreneur.infoEntreprise());

    }
}
