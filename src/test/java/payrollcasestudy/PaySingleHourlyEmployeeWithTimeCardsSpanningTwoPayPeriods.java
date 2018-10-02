package payrollcasestudy;

import java.util.Calendar;

import org.junit.Test;
import java.util.GregorianCalendar;
import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;

public class PaySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods {

	@Test
	public void paySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods() throws Exception {
		final int empId = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 9, 11); // Friday
		Calendar dateInPreviousPayPeriod = new GregorianCalendar(2001, 2, 11);

		AddTimeCardTransaction tc = new AddTimeCardTransaction(payDate, 2.0, empId);
		tc.execute();
		AddTimeCardTransaction tc2 = new AddTimeCardTransaction(dateInPreviousPayPeriod, 5.0, empId);
		tc2.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

	}
}
