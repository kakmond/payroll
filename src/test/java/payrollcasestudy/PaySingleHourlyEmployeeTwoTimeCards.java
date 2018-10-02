package payrollcasestudy;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;

public class PaySingleHourlyEmployeeTwoTimeCards {
	@Test
	public void paySingleHourlyEmployeeTwoTimeCards() throws Exception {
		final int empId = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 9, 11); // Friday
		Calendar payDate2 = new GregorianCalendar(2001, 3, 11);
		AddTimeCardTransaction tc = new AddTimeCardTransaction(payDate, 2.0, empId);
		tc.execute();
		AddTimeCardTransaction tc2 = new AddTimeCardTransaction(payDate2, 5.0, empId);
		tc2.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		final BigDecimal expectedPay = new BigDecimal("106.75"); // (2 + 5) *
																	// 15.25
	}
}
