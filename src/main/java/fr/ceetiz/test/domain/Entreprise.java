package fr.ceetiz.test.domain;

public abstract class Entreprise {

    private int CA;

    private Siret siret;

    private String denomination;

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public Siret getSiret() {
        return siret;
    }

    public void setSiret(Siret siret) {
        this.siret = siret;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public float calculImpots() {
        return (CA * getTaxePercent())/100;
    }

    protected abstract int getTaxePercent();

    public abstract String infoEntreprise();

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nDénomination : ")
                .append(getDenomination())
                .append("\nType : ")
                .append(getClass().getName().replaceAll(getClass().getPackageName()+".", ""))
                .append("\nCA : ")
                .append(getCA());
        if(getSiret() != null)
            sb.append("\nSIRET : ")
                    .append(getSiret().toString());
        sb.append("\nMontant des impots : ")
                .append(calculImpots());
        return sb.toString();
    }
}
