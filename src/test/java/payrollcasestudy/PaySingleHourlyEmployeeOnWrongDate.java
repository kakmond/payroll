package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import payrollcasestudy.entities.PayCheck;
import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;

public class PaySingleHourlyEmployeeOnWrongDate {
	@Test
	public void paySingleHourlyEmployeeOnWrongDate() throws Exception {
		final int empId = 2;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.25);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 8, 11); // Thursday

		AddTimeCardTransaction tc = new AddTimeCardTransaction(payDate, 9.0, empId);
		tc.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		PayCheck pc = pt.getPaycheck(empId);
		assertThat(pc, is(nullValue()));
	}
}
