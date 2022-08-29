package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );


    public static void main(String[] args) {
        //Update this
        // loop thru list & take each entry into one of three boxes (customer objects)
        // implement account record objects into customer objects (each one accounting for each unique entry)
        // make new array list of data entries
        // filter them thru new lists of positive and negative accounts

//        List<Customer> negAccounts = null;
//        List<Customer> posAccounts = null;

        for (String[] customers : customerData) {

            int customerNumber = Integer.parseInt(customers[0]);

            for (String[] customerRecords : customerData) {

                if (customerNumber == 1) {
                    Customer wayneEnterprises = new Customer();
                    AccountRecord wayne = new AccountRecord();
                    wayne.setCharge(Integer.parseInt(customers[2]));
                    wayne.setChargeDate(String.valueOf(Integer.parseInt(customers[3])));
                    wayneEnterprises.getCharges().add(wayne);
                } else if (customerNumber == 2) {
                    Customer dailyPlanet = new Customer();
                    AccountRecord daily = new AccountRecord();
                    daily.setCharge(Integer.parseInt(customers[2]));
                    daily.setChargeDate(String.valueOf(Integer.parseInt(customers[3])));
                    dailyPlanet.getCharges().add(daily);
                } else {
                    Customer aceChemical = new Customer();
                    AccountRecord ace = new AccountRecord();
                    ace.setCharge(Integer.parseInt(customers[2]));
                    ace.setChargeDate(String.valueOf(Integer.parseInt(customers[3])));
                    aceChemical.getCharges().add(ace);
                }
                System.out.println(Arrays.toString(customerRecords));
            }


//                List<Customer> wayne = wayneEnterprises.stream()
//                        .filter(w -> w.indexOf)
//                        .collect(Collectors.toList());


//            List<Customer> dailyPlanet = customerData.stream()
//                    .filter(customerData -> customerData.getId(2))
//                    .collect(Collectors.toList());
//
//            List<Customer> aceChemical = customerData.stream()
//                    .filter(customerData -> customerData.getId(3))
//                    .collect(Collectors.toList());
            }
        }
//        System.out.println("Positive accounts:");
//        System.out.println("Negative accounts:");
    }

//}
