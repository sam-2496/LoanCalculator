package com.loan.calculator;

import com.loan.calculator.Exception.PaymentDateExtendedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
   static List<LoanInformation> loanList = new ArrayList<>();
    @BeforeAll
    public static void createaData(){
        LoanInformation loan1 = new LoanInformation("L1","C1","LEN1",10000,10000, LocalDate.of(2023,7,6), 1, LocalDate.of(2023,7,5),0.01);
        LoanInformation loan2 = new LoanInformation("L2","C1","LEN1",20000,5000, LocalDate.of(2023,6,1), 1, LocalDate.of(2023,8,5),0.01);
        LoanInformation loan3 = new LoanInformation("L3","C2","LEN2",50000,30000, LocalDate.of(2023,4,4), 2, LocalDate.of(2023,5,4),0.02);
        LoanInformation loan4 = new LoanInformation("L4","C3","LEN2",50000,30000, LocalDate.of(2023,5,10), 2, LocalDate.of(2023,5,4),0.02);
        loanList.add(loan1);
        loanList.add(loan2);
        loanList.add(loan3);
        loanList.add(loan4);
    }

    @Test
    public void testGroupByLender() {
        Main obj = new Main();
        Map<String, Double> res = obj.groupByLender(loanList);
        assert(res.get("LEN1") == 15148.99);
        assert(res.get("LEN2") == 61163.28);
    }

    @Test
    public void testGroupByCustId() {
        Main obj = new Main();
        Map<String, Double> res = obj.groupByCustId(loanList);
        assert(res.get("C1") == 15148.99);
        assert(res.get("C2") == 30600.0);
        assert(res.get("C3") == 30563.28);
    }

    @Test
    public void testGroupByInterest() {
        Main obj = new Main();
        Map<Double, Double> res = obj.groupByInterest(loanList);
        assert(res.get(1.0) == 15148.99);
        assert(res.get(2.0) == 61163.28);
    }

    @Test
    public void TestDueDateExtended(){
       PaymentDateExtendedException exception =  assertThrows(PaymentDateExtendedException.class, () -> Main.checkDueDateExtended(loanList.get(0)));

    }

}
