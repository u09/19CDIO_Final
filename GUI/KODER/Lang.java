package KODER;

import java.util.HashMap;
import java.util.Map;

public class Lang {
    
    public Lang() {}
    
    public Map<String, String> lang(String input) {
        Map<String, String> Danish = new HashMap<String, String>();
        Danish.put("NAME",          "Indtast navn for spiller nummer ");
        Danish.put("NAME2",         "Navnet eksisterer allerede. Vænligst indtast et andet navn for spiller nummer ");
        Danish.put("TAX_Check",     "Du skal betale 4000 eller 10% af din pengebeholdning.");
        Danish.put("TAX_Check2",    "Betal indkomstskat kr. 2000");
        Danish.put("B4000",         "Betal 4000");
        Danish.put("B10",           "Betal 10%");
        Danish.put("LC_Check",      "100 x terningernes værdi");
        Danish.put("LP",            "Du er landet på ");
        Danish.put("BETAL",         "Du skal betale ");
        Danish.put("BE",            ", og du skal betale ");
        Danish.put("TS",            ", til ");
        Danish.put("HA",            ", og du skal have ");
        Danish.put("BE1",           ". Vil du købe grunden til ");
        Danish.put("AS",            "Fejl: Der skal være minimum 2 og maksimum 6 spiller");
        Danish.put("AS2",           "Indtast antal spillere (2-6)");
        Danish.put("KT",            "Tryk ok for at kaste med terninger, ");
        Danish.put("Chose_Color",   "Vælg den ønskede farve til din bil");
        Danish.put("F1",            "Blå");
        Danish.put("F2",            "Hvid");
        Danish.put("F3",            "Sort");
        Danish.put("F4",            "Gul");
        Danish.put("F5",            "Grøn");
        Danish.put("Chose_Type",    "Vælg det ønskede køretøj");
        Danish.put("T1",            "Bil");
        Danish.put("T2",            "Racerbil");
        Danish.put("T3",            "Traktor");
        Danish.put("T4",            "Ufo");
        Danish.put("KG",            "Vil du købe denne grund?");
        Danish.put("Y",             "Ja");
        Danish.put("N",             "Nej");
        Danish.put("VUNDET",        "TILLYKKE DU HAR VUNDET ");
        Danish.put("BANKEROT",      "Du er bankerot, vil du sælge dine ejendomme for halvpris? (Hvis du trykker nej, har du tabt spillet)");
        Danish.put("SAELGEHVAD",    "Hvad vil du sælge?");
        Danish.put("FLERE",         "Vil du sælge flere ejendomme?");
        Danish.put("FAAPENGE",      "Du har for faa penge i din pengebeholdning til at koebe ");
        Danish.put("Ikke2ens",      "Du har ikke sl�et 2 ens");
        Danish.put("TEST_FAEDIG",   "Testen er færdig!");
        Danish.put("StartPenge",    "Hver gang De passerer START, modtag kr. 4000");
        Danish.put("Bes�g",         "Du er p� bes�g i f�ngslet" );
        Danish.put("F�ngsles",      "De f�ngsles" );
        Danish.put("F�ngslesD",     "De f�ngsles! Ryk frem til 'I f�ngsel'" );
        Danish.put("iF�ngsel",      "Vil du betale 1000 eller sl� med terninger?");
        Danish.put("iF�ngselB",     "Betal kr. 1000");
        Danish.put("iF�ngselT",     "Kast med terninger");
        Danish.put("Pr�vL",         "Vil du pr�ve lykken?");
        
        if (input == "DA") return Danish;
        else return Danish;
        
    }
    
}
