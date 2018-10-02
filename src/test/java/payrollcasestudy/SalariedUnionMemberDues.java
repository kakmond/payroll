package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddSalariedEmployeeTransaction;
import payrollcasestudy.transactions.change.ChangeMemberTransaction;

public class SalariedUnionMemberDues {
	@Test
	public void salariedUnionMemberDues() throws Exception {
		final int empId = 1;
		AddSalariedEmployeeTransaction t = new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 1000.00);
		t.execute();
		final int memberId = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 9.42);
		cmt.execute();
		Calendar payDate = new GregorianCalendar(2001, 11, 30);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
//		validatePaycheckWithDeductions(pt, empId, payDate, new BigDecimal("1000.00"), new BigDecimal("952.90"), new BigDecimal("47.10"));	// 1000 - (9.42 * 5)
	}
}
