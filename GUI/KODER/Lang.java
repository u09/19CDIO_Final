package KODER;

import java.util.HashMap;
import java.util.Map;

public class Lang {
    
    public Lang() {}
    
    public Map<String, String> lang(String input) {
        Map<String, String> Danish = new HashMap<String, String>();
        Danish.put("NAME",          "Indtast navn for spiller nummer ");
        Danish.put("NAME2",         "Navnet eksisterer allerede. VÃ¦nligst indtast et andet navn for spiller nummer ");
        Danish.put("TAX_Check",     "Du skal betale 4000 eller 10% af din pengebeholdning.");
        Danish.put("TAX_Check2",    "Betal indkomstskat kr. 2000");
        Danish.put("B4000",         "Betal 4000");
        Danish.put("B10",           "Betal 10%");
        Danish.put("LC_Check",      "100 x terningernes vÃ¦rdi");
        Danish.put("LP",            "Du er landet pÃ¥ ");
        Danish.put("BETAL",         "Du skal betale ");
        Danish.put("BE",            ", og du skal betale ");
        Danish.put("TS",            ", til ");
        Danish.put("HA",            ", og du skal have ");
        Danish.put("BE1",           ". Vil du kÃ¸be grunden til ");
        Danish.put("AS",            "Fejl: Der skal vÃ¦re minimum 2 og maksimum 6 spiller");
        Danish.put("AS2",           "Indtast antal spillere (2-6)");
        Danish.put("KT",            "Tryk ok for at kaste med terninger, ");
        Danish.put("Chose_Color",   "VÃ¦lg den Ã¸nskede farve til din bil");
        Danish.put("F1",            "BlÃ¥");
        Danish.put("F2",            "Hvid");
        Danish.put("F3",            "Sort");
        Danish.put("F4",            "Gul");
        Danish.put("F5",            "GrÃ¸n");
        Danish.put("Chose_Type",    "VÃ¦lg det Ã¸nskede kÃ¸retÃ¸j");
        Danish.put("T1",            "Bil");
        Danish.put("T2",            "Racerbil");
        Danish.put("T3",            "Traktor");
        Danish.put("T4",            "Ufo");
        Danish.put("KG",            "Vil du kÃ¸be denne grund?");
        Danish.put("Y",             "Ja");
        Danish.put("N",             "Nej");
        Danish.put("VUNDET",        "TILLYKKE DU HAR VUNDET ");
        Danish.put("BANKEROT",      "Du er bankerot, vil du sÃ¦lge dine ejendomme for halvpris? (Hvis du trykker nej, har du tabt spillet)");
        Danish.put("SAELGEHVAD",    "Hvad vil du sÃ¦lge?");
        Danish.put("FLERE",         "Vil du sÃ¦lge flere ejendomme?");
        Danish.put("FAAPENGE",      "Du har for faa penge i din pengebeholdning til at koebe ");
        Danish.put("Ikke2ens",      "Du har ikke slået 2 ens");
        Danish.put("TEST_FAEDIG",   "Testen er fÃ¦rdig!");
        Danish.put("StartPenge",    "Hver gang De passerer START, modtag kr. 4000");
        Danish.put("Besøg",         "Du er på besøg i fængslet" );
        Danish.put("Fængsles",      "De fængsles" );
        Danish.put("FængslesD",     "De fængsles! Ryk frem til 'I fængsel'" );
        Danish.put("iFængsel",      "Vil du betale 1000 eller slå med terninger?");
        Danish.put("iFængselB",     "Betal kr. 1000");
        Danish.put("iFængselT",     "Kast med terninger");
        Danish.put("PrøvL",         "Vil du prøve lykken?");
        
        if (input == "DA") return Danish;
        else return Danish;
        
    }
    
}
