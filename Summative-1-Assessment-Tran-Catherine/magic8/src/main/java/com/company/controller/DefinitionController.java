package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.company.model.Definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {

    private List<Definition> wordList;

    private static int idCounter = 1;

    public DefinitionController() {
        wordList = new ArrayList<>();

        wordList.add(new Definition(idCounter++, "ursprache", "[GERMAN IPA PRONUNCIATION /ˈʔuːɐ̯ˌʃpʁaːxə/] original language, " +
                "parent language, or proto-language"));
        wordList.add(new Definition(idCounter++, "antidisestablishmentarianism", "[ENGLISH IPA PRONUNCIATION " +
                "/ˌæn.taɪˌdɪs.ɛsˌtæb.lɪʃ.məntˈɛː.ɹi.ənˌɪ.zm/] a political philosophy opposed to the separation of a religious " +
                "group (church) and a government (state)"));
        wordList.add(new Definition(idCounter++, "arriviste", "[FRENCH IPA PRONUNCIATION /a riˈvist/] an ambitious " +
                "or ruthlessly self-seeking person, especially one who has recently acquired wealth or social status; a social climber"));
        wordList.add(new Definition(idCounter++, "밤", "[KOREAN IPA PRONUNCIATION /pa̠m/] 1) night; 2) chestnut"));
        wordList.add(new Definition(idCounter++, "olvido", "[SPANISH IPA PRONUNCIATION /olˈbido/] 1) oblivion, " +
                "or the state of being completely forgotten; 2) forgetting, or end of memory; 3) idea meaning an abstract " +
                "place to put what is wanted to be forgotten"));
        wordList.add(new Definition(idCounter++, "duyên", "[VIETNAMESE IPA PRONUNCIATION /j⁽ʷ⁾iəŋ˧˧/] 1) charm, grace; " +
                "2) predestined tie that is believed to have people meet each other"));
        wordList.add(new Definition(idCounter++, "노을", "[KOREAN IPA PRONUNCIATION /no̞ɭ/] (of sunset or sunrise) " +
                "glow, red sky"));
        wordList.add(new Definition(idCounter++, "lento", "[SPANISH IPA PRONUNCIATION /ˈlento/] 1) not quick in motion; " +
                "2) slow, having little motion (as in sluggish); 3) easy-going; 4) steady"));
        wordList.add(new Definition(idCounter++, "cà phê", "[VIETNAMESE IPA PRONUNCIATION /ˈkæfeɪ/] coffee"));
        wordList.add(new Definition(idCounter++, "melisma", "[ENGLISH IPA PRONUNCIATION /məˈlɪzmə/] in a musical style " +
                "that allows several notes to be sung to one syllable of text"));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getDefinition() {

        Definition dailyWord;
        Random rand = new Random();

        dailyWord = wordList.get(rand.nextInt(10));

            return dailyWord;
    }
}
