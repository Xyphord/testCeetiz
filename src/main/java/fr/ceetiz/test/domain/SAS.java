package fr.ceetiz.test.domain;

public class SAS extends Entreprise{

    private static final int TAXE_PERCENT=33;

    private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    protected int getTaxePercent() {
        return TAXE_PERCENT;
    }

    public String infoEntreprise() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("\nAdresse : ")
                .append(this.adresse);
        return sb.toString();
    }
}
