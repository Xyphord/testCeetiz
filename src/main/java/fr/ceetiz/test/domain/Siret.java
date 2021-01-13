package fr.ceetiz.test.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Siret {

    private static final String SIRET_REGEXP = "[0-9]{14}";
    private static final Pattern p = Pattern.compile(SIRET_REGEXP);
    private String siret;

    public Siret(String siret){
        this.siret=(verify(siret));
    }

    private static String verify(String siret) throws IllegalArgumentException{
        if(siret == null) {
            throw new IllegalArgumentException("Le Siret ne peux etre null!");
        }
        siret = siret.replaceAll("\\s", "");
        if(! p.matcher(siret).matches())
            throw new IllegalArgumentException("Le Siret n'est pas un nombre de 14 chiffres !");
        int total = 0;
        int digit = 0;

        for (int i = 0; i<siret.length(); i++) {
            if ((i % 2) == 0) {
                digit = Integer.parseInt(String.valueOf(siret.charAt(i))) * 2;
                if (digit > 9) digit -= 9;
            }
            else digit = Integer.parseInt(String.valueOf(siret.charAt(i)));
            total += digit;
        }
        if ((total % 10) == 0) return siret;
        else throw new IllegalArgumentException("Le Siret "+siret+" n'est pas valide !" );
    }

    public String toString(){
        return siret;
    }
}
