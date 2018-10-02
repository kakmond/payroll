package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddServiceChargeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;
import payrollcasestudy.transactions.change.ChangeMemberTransaction;

public class ServiceChargesSpanningMultiplePayPeriods {
	@Test
	public void serviceChargesSpanningMultiplePayPeriods() throws Exception {
		final int empId = 1;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.2);
		t.execute();
		final int memberId = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 9.42);
		cmt.execute();
		Calendar earlyDate = new GregorianCalendar(2001, 11, 2); // previous
																	// Friday
		Calendar payDate = new GregorianCalendar(2001, 11, 9);
		Calendar lateDate = new GregorianCalendar(2001, 11, 16); // next Friday
		AddServiceChargeTransaction sct = new AddServiceChargeTransaction(memberId, payDate, 19.42);
		sct.execute();
		AddServiceChargeTransaction sctEarly = new AddServiceChargeTransaction(memberId, earlyDate, 100.00);
		sctEarly.execute();
		AddServiceChargeTransaction sctLate = new AddServiceChargeTransaction(memberId, lateDate, 200.00);
		sctLate.execute();
		AddTimeCardTransaction tct = new AddTimeCardTransaction(payDate, 8.0, empId);
		tct.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		// validatePaycheckWithDeductions(pt, empId, payDate, new
		// BigDecimal("121.92"), new BigDecimal("93.08"), new
		// BigDecimal("28.84"));
	}
}
