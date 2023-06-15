package com.loan.calculator;

import com.loan.calculator.Exception.PaymentDateExtendedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class Main {

    static Logger log = LogManager.getLogger(Main.class);
    //    1st Scenario
    public static void checkDueDateExtended(LoanInformation loan) throws PaymentDateExtendedException {
           if(loan.getPaymentDate().compareTo(loan.getDueDate()) > 0){
               log.info("Alert!! Due Date Surpassed" );
               throw new PaymentDateExtendedException("Loan Payment Date extended than the given due date");
           }
    }

    private static double remAmountCalculation(LoanInformation loan){
        double remAmt = loan.getRemAmount() + loan.getRemAmount()*(loan.getInterestRate()/100);
        if(loan.getPaymentDate().compareTo(loan.getDueDate()) > 0){
            long days = ChronoUnit.DAYS.between(loan.getPaymentDate(), loan.getDueDate());
            remAmt = remAmt + remAmt*days*(loan.getPenaltyRate()/100);
        }
        return remAmt;
    }

    public Map<String, Double> groupByLender(List<LoanInformation> loanList){
        Map<String, Double> remAmtByLender = loanList.stream().collect(Collectors.groupingBy(w -> w.getLenderId(), Collectors.summingDouble(w -> Main.remAmountCalculation(w))));
        log.info("Return Map : "+ remAmtByLender);
        return remAmtByLender;
    }

    public Map<String, Double> groupByCustId(List<LoanInformation> loanList){
        Map<String, Double> remAmtByCustId = loanList.stream().collect(Collectors.groupingBy(w -> w.getCustomerId(), Collectors.summingDouble(w -> Main.remAmountCalculation(w))));
        return remAmtByCustId;
    }

    public Map<Double, Double> groupByInterest(List<LoanInformation> loanList){
        Map<Double, Double> remAmtByInterest = loanList.stream().collect(Collectors.groupingBy(w -> w.getInterestRate(), Collectors.summingDouble(w -> Main.remAmountCalculation(w))));
        return remAmtByInterest;
    }


}
