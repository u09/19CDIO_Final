package KODER;

import java.util.HashMap;
import java.util.Map;

public class Lang {
    
    public Lang() {}
    
    /**
     * Vi har to værdier i en hashMap, værdien til højre associeres med den værdi til venstre.
     * <key, value>
     * @param input
     * @return
     */
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
        Danish.put("TIL",           " til ");
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
        Danish.put("Ikke2ens",      "Du har ikke sl�et 2 ens");
        Danish.put("TEST_FAEDIG",   "Testen er færdig!");
        Danish.put("StartPenge",    "Hver gang De passerer START, modtag kr. 4000");
        Danish.put("Besøg",         "Du er på besøg i fængslet" );
        Danish.put("Fængsles",      "De fængsles" );
        Danish.put("FængslesD",     "De fængsles! Ryk frem til 'I fængsel'" );
        Danish.put("iFængsel",      "Vil du betale 1000 eller slå med terninger?");
        Danish.put("iFængselB",     "Betal kr. 1000");
        Danish.put("iFængselT",     "Kast med terninger");
        Danish.put("PrøvL",         "Vil du prøve lykken?");
        Danish.put("IKKE_NOK_PENGE","Du har ikke nok penge til at købe feltet.");
        
        Danish.put("PrøvLRyk1",     "Ryk frem til START");
        Danish.put("PrøvLRyk2",     "Ryk tre felter tilbage");
        Danish.put("PrøvLRyk3",     "Ryk frem til Grønningen. Hvis De passerer START, indkasser da KR.4000.");
        Danish.put("PrøvLRyk4",     "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.");
        Danish.put("PrøvLRyk5",     "Ryk frem til Frederiksberg Allé. Hvis De passerer START indkasser KR. 4000.");
        Danish.put("PrøvLRyk6",     "Tag med den nærmeste færge - Flyt brikken frem, og hvis De passerer START indkasser da KR. 4000.");
        Danish.put("PrøvLRyk7",     "Tag ind på Rådhuspladsen.");
        Danish.put("PrøvLRyk8",     "Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer START indkasserer De IKKE KR. 4000.");
        
        Danish.put("PrøvLPay1",     "Du har købt ØL derfor skal du betale 300KR til banken");
        Danish.put("PrøvLPay2",     "De har kørt frem for FULD STOP. Betal 1000KR i bøde");
        Danish.put("PrøvLPay3",     "Betal 3000KR for reparation af deres vogn");
        Danish.put("PrøvLPay4",     "Betal 3000KR for reparation af deres vogn");
        Danish.put("PrøvLPay5",     "De har modtaget deres tandlæge regning. Betal 2000KR");
        Danish.put("PrøvLPay6",     "De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal 200KR i told");
        
        Danish.put("PrøvLRec1",     "Grundet dyrtiden har De fået gangeforhøjelse. Modtag 1000KR");
        Danish.put("PrøvLRec2",     "De har vundet i Klasselotteriet. Modtag  500 KR.");
        Danish.put("PrøvLRec3",     "Kommunen har eftergivet et kvartals. Hæv i banken 3000KR");
        Danish.put("PrøvLRec4",     "De modtager Derers aktieudbytte. Modtag 1000 KR af banken.");
        Danish.put("PrøvLRec5",     "Deres præmieobligation er kommet ud. De modtager 1000 KR af banken.");
        Danish.put("PrøvLRec6",     "Modtag udbytte af Deres aktier 1000 KR");
        Danish.put("PrøvLRec7",     "De havde enrække med elleve rigtige i tipning. Modtag 1000 KR.");
        Danish.put("PrøvLRec8",     "Værdien af egen avl fra nyttehaven udgør 200 KR, som De modtager af banken");
        Danish.put("PrøvLRec9",     "Modtag udbytte af Deres aktier 1000 KR.");
        Danish.put("PrøvLRec10",     "Deres præmieobligation er kommet ud. De modtager 1000KR. af banken");
        
        if (input == "DA") return Danish;
        else return Danish;
        
    }
    
}
