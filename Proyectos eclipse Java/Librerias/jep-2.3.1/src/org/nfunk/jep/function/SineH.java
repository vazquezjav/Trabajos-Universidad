/*****************************************************************************

JEP - Java Math Expression Parser 2.3.1
      January 26 2006
      (c) Copyright 2004, Nathan Funk and Richard Morris
      See LICENSE.txt for license information.

*****************************************************************************/
package org.nfunk.jep.function;

import java.lang.Math;
import java.util.*;
import org.nfunk.jep.*;
import org.nfunk.jep.type.*;

public class SineH extends PostfixMathCommand
{
	public SineH()
	{
		numberOfParameters = 1;
	}

	public void run(Stack inStack)
		throws ParseException
	{
		checkStack(inStack);// check the stack
		Object param = inStack.pop();
		inStack.push(sinh(param));//push the result on the inStack
		return;
	}

	public Object sinh(Object param)
		throws ParseException
	{
		if (param instanceof Complex)
		{
			return ((Complex)param).sinh();
		}
		else if (param instanceof Number)
		{
			double value = ((Number)param).doubleValue();
			return new Double((Math.exp(value)-Math.exp(-value))/2);
		}

		throw new ParseException("Invalid parameter type");
	}

}
