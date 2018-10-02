package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;

public class PaySingleHourlyEmployeeNoTimeCards {
	@Test
	public void paySingleHourlyEmployeeNoTimeCards() throws Exception {
		final int empId = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home",15.25);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 11, 9);
//		Date payDate = date(11, 9, 2001);	// Friday
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
//		validatePaycheck(pt, empId, payDate, new BigDecimal("0.00"));
	}
}
