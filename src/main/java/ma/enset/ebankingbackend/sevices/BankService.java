package ma.enset.ebankingbackend.sevices;


import ma.enset.ebankingbackend.entities.BankAccount;
import ma.enset.ebankingbackend.entities.CurrentAccount;
import ma.enset.ebankingbackend.entities.SavingAccount;
import ma.enset.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("257530af-840a-4b78-9e49-725a01533f35").orElse(null);
        if(bankAccount!=null){
            System.out.println("***********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreateAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if(bankAccount instanceof CurrentAccount){
                System.out.println("Over Draft : "+((CurrentAccount) bankAccount).getOverDraft());
            }
            else if (bankAccount instanceof SavingAccount)
            {
                System.out.println("Rate : "+((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(accountOperation -> {
                System.out.println("============================");
                System.out.print(accountOperation.getType()+"\t");
                System.out.print(accountOperation.getOperationDate()+"\t");
                System.out.println(accountOperation.getAmount()+"\t");

            });
            System.out.println("============================");
            System.out.println("***********************");
        }
    }
}
