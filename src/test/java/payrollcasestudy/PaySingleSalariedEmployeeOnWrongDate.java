package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import payrollcasestudy.entities.PayCheck;
import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddSalariedEmployeeTransaction;

public class PaySingleSalariedEmployeeOnWrongDate {
	@Test
	public void paySingleSalariedEmployeeOnWrongDate() throws Exception {
		final int empId = 1;
		AddSalariedEmployeeTransaction t = new AddSalariedEmployeeTransaction(empId, "Bob", "Home", 1000.00);
		t.execute();
		Calendar payDate = new GregorianCalendar(2001, 11, 9);
		// Date payDate = date(11, 29, 2001);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();
		PayCheck pc = pt.getPaycheck(empId);
		assertThat(pc, is(nullValue()));
	}
}
