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

public class ArcSine extends PostfixMathCommand
{
	public ArcSine()
	{
		numberOfParameters = 1;
	
	}
	
	public void run(Stack inStack)
		throws ParseException 
	{
		checkStack(inStack);// check the stack
		Object param = inStack.pop();
		inStack.push(asin(param));//push the result on the inStack
		return;
	}

	public Object asin(Object param)
		throws ParseException
	{
		if (param instanceof Complex)
		{
			return ((Complex)param).asin();
		}
		else if (param instanceof Number)
		{
			return new Double(Math.asin(((Number)param).doubleValue()));
		}

		throw new ParseException("Invalid parameter type");
	}
	
}
