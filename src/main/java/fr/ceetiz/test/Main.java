package fr.ceetiz.test;

import fr.ceetiz.test.domain.AutoEntrepreneur;
import fr.ceetiz.test.domain.Entreprise;
import fr.ceetiz.test.domain.SAS;
import fr.ceetiz.test.domain.Siret;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger("Main");

    public static void main(String[] args)
    {
        List<Entreprise> entreprises = new ArrayList<>();

        SAS entrepriseSas = new SAS();
        AutoEntrepreneur autoEntrepreneur = new AutoEntrepreneur();

        entreprises.add(entrepriseSas);
        entreprises.add(autoEntrepreneur);

        entrepriseSas.setCA(1513135);
        entrepriseSas.setDenomination("Test SAS");
        entrepriseSas.setSiret(new Siret("529   95748200  0  43"));
        entrepriseSas.setAdresse("5 rue des corniches 54410 Onville");
        LOGGER.info("\r"+entrepriseSas.infoEntreprise()+"\r");

        autoEntrepreneur.setCA(1543);
        autoEntrepreneur.setSiret(new Siret("52995748200043"));
        autoEntrepreneur.setDenomination("Test auto entreprise");
        LOGGER.info("\r"+autoEntrepreneur.infoEntreprise());

        entreprises.stream().forEach(v -> LOGGER.info("Entreprise "+ v.getDenomination()+ " - impots: "
                + String.valueOf(v.calculImpots())));
    }
}
