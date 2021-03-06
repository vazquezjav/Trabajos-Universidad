package org.lsmp.djepJUnit;

import junit.framework.*;
import org.nfunk.jep.*;
import org.nfunk.jep.type.*;
import org.lsmp.djep.groupJep.interfaces.*;
import org.lsmp.djep.groupJep.values.*;
import org.lsmp.djep.groupJep.*;
import org.lsmp.djep.groupJep.groups.*;
import java.math.*;
/* @author rich
 * Created on 19-Nov-2003
 *
 * This code is covered by a Creative Commons
 * Attribution, Non Commercial, Share Alike license
 * <a href="http://creativecommons.org/licenses/by-nc-sa/1.0">License</a>
 */

/**
 * Tests some strange properties of special groups.
 * 
 * @author Rich Morris
 * Created on 19-Nov-2003
 */
public class GroupJepTest extends TestCase {
	GroupJep j;
	public static final boolean SHOW_BAD=false;
	
	public GroupJepTest(String name) {
		super(name);
	}

	public static void main(String args[]) {
		// Create an instance of this class and analyse the file

		TestSuite suite= new TestSuite(GroupJepTest.class);
//		DJepTest jt = new DJepTest("DJepTest");
//		jt.setUp();
		suite.run(new TestResult());
	}	

	protected void setUp() {
	}

	public static Test suite() {
		return new TestSuite(GroupJepTest.class);
	}

	public void myAssertEquals(String msg,String actual,String expected)
	{
		if(!actual.equals(expected))
			System.out.println("Error \""+msg+"\" is \""+actual+" should be "+expected+"\"");
		assertEquals("<"+msg+">",expected,actual);
		System.out.println("Success: Value of \""+msg+"\" is \""+actual+"\"");
	}

	public void myAssertEquals(String msg,String actual,String expected,String ending)
	{
		if(!actual.equals(expected))
			System.out.println("Error \""+msg+"\" is \""+actual+" should be "+expected+"\"");
		assertEquals("<"+msg+">",expected,actual);
		System.out.println("Success: Value of \""+msg+"\" is \""+actual+"\": "+ending);
	}

	/** just test JUnit working OK */
	public void testGood()
	{
		assertEquals(1,1);
	}

	public void valueToStringTest(String expr,String expected) throws Exception
	{
		Node node = j.parse(expr);
		Object val = j.evaluate(node);
		String res = val.toString();
		String ending="";
		if(val instanceof HasComplexValueI)
		{
			Complex cval = ((HasComplexValueI) val).getComplexValue();
			ending = cval.toString();
		}
		myAssertEquals(expr,res,expected,ending);
	}

	/** Tests very large numbers, 20! */
	public void testZ() throws Exception
	{
		j = new GroupJep(new Integers());
		valueToStringTest("1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20","2432902008176640000");
	}

	/** Tests rationals */
	public void testQ() throws Exception
	{
		j = new GroupJep(new Rationals());
		System.out.println(j.getGroup().toString());
		valueToStringTest("(1/2)-(1/3)","1/6");
	}
	
	/** Tests rationals */
	public void testQuartonians() throws Exception
	{
		j = new GroupJep(new Quartonians());
		j.addStandardConstants();
		System.out.println(j.getGroup().toString());
		valueToStringTest("i*j","0.0+0.0 i +0.0 j +-1.0 k");
	}

	/** Tests integers mod 5 */
	public void testZn() throws Exception
	{
		j = new GroupJep(new Zn(BigInteger.valueOf(5)));
		System.out.println(j.getGroup().toString());
		valueToStringTest("2*3","1");
		valueToStringTest("2*4","3");
		valueToStringTest("3*3","4");
		valueToStringTest("3*4","2");
		valueToStringTest("4*4","1");

		valueToStringTest("2/3","4");
		valueToStringTest("2/4","3");
		valueToStringTest("3/2","4");
		valueToStringTest("3/4","2");
		valueToStringTest("4/2","2");
		valueToStringTest("4/3","3");
	}

	public void testZroot2() throws Exception
	{
		RingI ring = new Integers();
		Number coeffs[] = new Number[]{
			BigInteger.valueOf(-2),
			BigInteger.ZERO,
			BigInteger.ONE};
		Polynomial p1 = new Polynomial(ring,"rt2",coeffs);

		j = new GroupJep(new AlgebraicExtension(ring, p1));
		j.addStandardConstants();
		System.out.println(j.getGroup().toString());
		valueToStringTest("rt2*rt2","<2>");
		valueToStringTest("(rt2+1)*(rt2+1)","<2 rt2+3>");
	}
	
	public void testZ5thRootUnity() throws Exception
	{
		RingI ring = new Integers();
		Number coeffs[] = new Number[]{
			BigInteger.valueOf(-1),
			BigInteger.ZERO,
			BigInteger.ZERO,
			BigInteger.ZERO,
			BigInteger.ZERO,
			BigInteger.ONE};
		Polynomial p1 = new Polynomial(ring,"t",coeffs);

		j = new GroupJep(new AlgebraicExtension(ring, p1));
		j.addStandardConstants();
		System.out.println(j.getGroup().toString());
		valueToStringTest("t*t","<t^2>");
		valueToStringTest("t*t*t","<t^3>");
		valueToStringTest("t*t*t*t","<t^4>");
		valueToStringTest("t*t*t*t*t","<1>");
	}

	public void testZRoot2Root5() throws Exception
	{
		RingI ring = new Integers();
		Number coeffs1[] = new Number[]{
			BigInteger.valueOf(-2),
			BigInteger.ZERO,
			BigInteger.ONE};
		Polynomial p1 = new Polynomial(ring,"t",coeffs1);
		AlgebraicExtension an1 = new AlgebraicExtension(ring, p1);
		
		Number coeffs2[] = new Number[]{
			an1.valueOf("-5"),
			an1.valueOf("0"),
			an1.valueOf("1")};
		Polynomial p2 = new Polynomial(an1,"s",coeffs2);
		AlgebraicExtension an2 = new AlgebraicExtension(an1, p2);

		j = new GroupJep(an2);
		j.addStandardConstants();
		System.out.println(j.getGroup().toString());

		valueToStringTest("t","<t>");
		valueToStringTest("s","<s>");
		valueToStringTest("t*t","<2>");
		valueToStringTest("s*s","<5>");
		valueToStringTest("s*t","<t s>");
		valueToStringTest("s+t","<s+t>");
		valueToStringTest("(t-1)*(s-1)","<<t-1> s+-t+1>");
	}

	public void testZtau() throws Exception
	{
		RingI ring = new Integers();
		Number coeffs[] = new Number[]{
			BigInteger.valueOf(-1),
			BigInteger.valueOf(-1),
			BigInteger.ONE};
		Polynomial p1 = new Polynomial(ring,"t",coeffs);

		AlgebraicExtension an = new AlgebraicExtension(ring, p1);
		j = new GroupJep(an);
		j.addStandardConstants();
		j.setAllowAssignment(true);
		j.setAllowUndeclared(true);
		System.out.println(j.getGroup().toString());
		valueToStringTest("t*t","<t+1>");
		valueToStringTest("t*t*t","<2 t+1>");
		valueToStringTest("t*t*t*t","<3 t+2>");
		valueToStringTest("t*t*t*t*t","<5 t+3>");
		valueToStringTest("t*t*t*t*t*t","<8 t+5>");
		valueToStringTest("x=2*t-1","<2 t-1>");
		valueToStringTest("x*x","<5>");
		valueToStringTest("-t","<-t>");
		valueToStringTest("1-t","<-t+1>");
		valueToStringTest("t*(1-t)","<-1>");
	}

	public void testBad() throws ParseException
	{
		if(SHOW_BAD)
		{
//			simplifyTest("1&&(1||x)","1");
//			simplifyTest("diff(sgn(x),x)","0");	// sgn not implemented
//			simplifyTest("diff(re(x+i y),x)","1"); // not smart enought to work out re(i) = 1
//			simplifyTest("diff(re(x+i y),y)","0");
//			simplifyTest("diff(im(x+i y),x)","0");
//			simplifyTest("diff(im(x+i y),y)","1");
//			simplifyTest("(x/2)*3","x*1.5");
		}
	}
}
