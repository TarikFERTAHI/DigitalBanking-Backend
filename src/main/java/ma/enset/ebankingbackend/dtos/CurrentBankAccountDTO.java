package ma.enset.ebankingbackend.dtos;


import lombok.Data;
import ma.enset.ebankingbackend.enumes.AccountStatus;

import java.util.Date;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;

}