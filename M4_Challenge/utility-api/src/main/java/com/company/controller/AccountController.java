package com.company.controller;

import com.company.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class AccountController {

    private List<Account> accountList;

    private static int idCounter = 1;

    public AccountController() {
        accountList = new ArrayList<>();

        accountList.add(new Account("Robert Williams", "TexasAM_44", idCounter++));
        accountList.add(new Account("Danny Ainge", "BYU_44", idCounter++));
        accountList.add(new Account("Brian Scalabrine", "USC_44", idCounter++));
    }


    // create new account (duplicate usernames are prevented for newly-created accounts)
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Account createAccount(@RequestBody @Valid Account account) {

        for (Account targetAccount : accountList) {
            if (targetAccount.getUsername().equals(account.getUsername())) {
                throw new IllegalArgumentException("Duplicate username detected.");
            }
        }

        account.setId(idCounter++);
        accountList.add(account);

        return account;
    }

}

