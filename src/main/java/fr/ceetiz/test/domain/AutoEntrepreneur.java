package fr.ceetiz.test.domain;

public class AutoEntrepreneur extends Entreprise{
    private static final int TAXE_PERCENT=25;
    @Override
    protected int getTaxePercent() {
        return TAXE_PERCENT;
    }

    @Override
    public String infoEntreprise() {
        return super.toString();
    }
}
