package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.company.model.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    private static int idCounter = 1;

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "Jin Ishikawa", "When I'm alone in the ocean or desert, I talk " +
                "to myself a lot, and memories that I've kept in the back of my mind start to flood out. Memories like 'I didn't " +
                "apologize to him properly that time.' Then if, in the middle of the desert, I say, 'I'm really sorry about " +
                "that time,' my memory calms down and I feel refreshed."));
        quoteList.add(new Quote(idCounter++, "Karen Takizawa", "I think the more detours I take, the more dreams " +
                "I gain. Right now, I'd rather take all kinds of detours than go down a straight road. I've finally realized that " +
                "it's fun to take detours."));
        quoteList.add(new Quote(idCounter++, "Shigesato Itoi", "When I remember a friend who has passed away, " +
                "I often so wish he could be here with us as we reminisce about him. I think he probably still is here, " +
                "just as long as we keep hold of that feeling."));
        quoteList.add(new Quote(idCounter++, "Shigesato Itoi", "There is nothing better than the feeling that " +
                "things will be okay. 'I'll manage' is a kind of synonym for 'I made it.' It's not the same, but it's close. " +
                "I think 'I managed' is more valuable than 'I won/lost' or 'I succeeded/failed.'"));
        quoteList.add(new Quote(idCounter++, "Masako Ito", "Sometimes people tell me that I'm lucky. I don't think " +
                "so myself, but there's one thing I've learned from watching other people: People who are good-humored definitely " +
                "tend to be lucky. They are more likely to be treated kindly by others."));
        quoteList.add(new Quote(idCounter++, "Kenjiro Fukamachi", "The things that endure are not simply left in " +
                "their original form, but are added to or modified in some way."));
        quoteList.add(new Quote(idCounter++, "Lully Miura", "Sweets are important for one's mental health. " +
                "This is something that can be explained properly by health experts, but they calm the mind. So instead of " +
                "immediately telling someone to go to the doctor and get some medicine, I think you should say, 'Let's go " +
                "to a cafe and have some cake!'"));
        quoteList.add(new Quote(idCounter++, "Yuka Nakamae", "Cooking for myself used to be a bit of a hassle, " +
                "but over the past few months I've finally been able to enjoy making and eating food, and it's one of the " +
                "few good things I've learned during this lockdown. Who was it who first said, 'To eat is to live'? It's so true. " +
                "I need to be healthy. I have a lot of people I want to see."));
        quoteList.add(new Quote(idCounter++, "Mariko Yamauchi", "In this age of smartphones and internet connections, " +
                "the loneliness that I once experienced has gone. Social networking and smartphones came out not long afterwards, " +
                "so that was probably the last time there was real loneliness on Earth. I'm a little jealous of the loneliness " +
                "I felt back then."));
        quoteList.add(new Quote(idCounter++, "junaida", "I work alone and I work from home, so I am careful to get up " +
                "in the morning, get dressed and get ready for the day."));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {

        Quote dailyQuote;
        Random rand = new Random();

        dailyQuote = quoteList.get(rand.nextInt(10));

            return dailyQuote;
    }
}
