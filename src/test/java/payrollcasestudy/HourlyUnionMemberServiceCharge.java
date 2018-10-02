package payrollcasestudy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import payrollcasestudy.transactions.PaydayTransaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import payrollcasestudy.transactions.add.AddServiceChargeTransaction;
import payrollcasestudy.transactions.add.AddTimeCardTransaction;
import payrollcasestudy.transactions.change.ChangeMemberTransaction;

public class HourlyUnionMemberServiceCharge {
	@Test
	public void hourlyUnionMemberServiceCharge() throws Exception {
		final int empId = 1;
		AddHourlyEmployeeTransaction t = new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 15.24);
		t.execute();
		final int memberId = 7734;
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 9.42);
		cmt.execute();
		Calendar payDate = new GregorianCalendar(2001, 11, 9);
		AddServiceChargeTransaction sct = new AddServiceChargeTransaction(memberId, payDate, 19.42);
		sct.execute();
		AddTimeCardTransaction tct = new AddTimeCardTransaction(payDate, 8.0, empId);
		tct.execute();
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.execute();

		// validatePaycheckWithDeductions(pt, empId, payDate, 121.92, 93.08,
		// 28.84);
	}
}
