package ma.enset.ebankingbackend.exceptions;

import ma.enset.ebankingbackend.entities.Customer;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message) {super(message);}
}
