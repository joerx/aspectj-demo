package io.yodo.springcourse.aspectjdemo.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FortuneService {

    public String getFortune(int dayOfMonth) {
        try {
            return sleepAndGetFortune(dayOfMonth);
        } catch (InterruptedException e) {
            return null; // return immediately
        }
    }

    private String sleepAndGetFortune(int dayOfMonth) throws InterruptedException {
        Random r = new Random();
        int delay = r.nextInt(500);
        Thread.sleep(delay);

        if (dayOfMonth == 13) {
            throw new UnfortunateException("Not your lucky day");
        }
        if (dayOfMonth > 31) {
            throw new IllegalArgumentException("Day of month can't be greater than 31");
        }
        return "Today is your lucky day";
    }
}
