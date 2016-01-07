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
        Danish.put("F6",            "Rød");
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
        Danish.put("TEST_FAEDIG",   "Testen er færdig!");
        
        if (input == "DA") return Danish;
        else return Danish;
        
    }
    
}
