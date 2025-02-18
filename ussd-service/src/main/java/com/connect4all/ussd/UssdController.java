package com.connect4all.ussd;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ussd")
public class UssdController {

    @PostMapping
    public String handleUssd(
            @RequestParam String sessionId,
            @RequestParam String phoneNumber,
            @RequestParam String serviceCode, //123
            @RequestParam String text) {


        if (text == null || text.isEmpty()) {
            return "CON Welcome to Connect4All Services\n1. Check Balance\n2. Buy Airtime";
        }

        else if (text.equals("1")) {
            return "END Your balance is $10.";
        }

        else if (text.equals("2")) {
            return "CON Enter amount to buy airtime:";
        }

        else if (text.matches("2\\*\\d+")) {
            String amount = text.split("\\*")[1];
            return "END You have successfully purchased $" + amount + " airtime.";
        }

        else {
            return "END Invalid input. Try again.";
        }
    }
}
