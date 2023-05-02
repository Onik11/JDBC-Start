package am.hitech.jdbc.service;

import am.hitech.jdbc.model.Account;
import am.hitech.jdbc.repo.AccountRepo;
import am.hitech.jdbc.util.exceptionMassege.ErrorMassage;
import am.hitech.jdbc.util.exceptions.InternalServerError;

public class AccountService {

    private AccountRepo accountRepo = new AccountRepo();


    public void transfer(int fromUserId, int toUserId, int amount) {

        accountRepo.transfer(fromUserId ,toUserId,amount);
    }

    public void update(String name,int id){

        accountRepo.update(name,id);
    }
    public void creatAccount(Account account) throws InternalServerError {
        int row = accountRepo.creatAccount(account);
        if (row==0){
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
    public void deleteAccount(int id) throws InternalServerError {
        int row = accountRepo.deleteAccount(id);

        if (row == 0) {
            throw new InternalServerError(ErrorMassage.ANOTHER_ERROR_MASSAGE);
        }
    }
}
