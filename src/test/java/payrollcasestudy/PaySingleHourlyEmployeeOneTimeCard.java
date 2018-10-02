package payrollcasestudy;

import java.util.Calendar;

import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;

public class PaySingleHourlyEmployeeOneTimeCard {
	@Test
	public void paySingleHourlyEmployeeOneTimeCard() throws Exception {
		final int empId = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 9, 11); // Friday

		AddTimeCardTransaction tc = new AddTimeCardTransaction(payDate, 2.0, empId);
		tc.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
	}

}
