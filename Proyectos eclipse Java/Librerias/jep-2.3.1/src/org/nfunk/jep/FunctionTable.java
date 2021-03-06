/*****************************************************************************

JEP - Java Math Expression Parser 2.3.1
      January 26 2006
      (c) Copyright 2004, Nathan Funk and Richard Morris
      See LICENSE.txt for license information.

*****************************************************************************/
package org.nfunk.jep;
import java.util.Hashtable;
import org.nfunk.jep.function.PostfixMathCommandI;
public class FunctionTable extends Hashtable
{
	public FunctionTable()
	{
		
	}
	
	/** adds the PostfixMathCommandI for the function with name s. 
	 * RJM addition Oct 03
	 */
	public Object put(String s,PostfixMathCommandI pfmc)
	{
		return super.put(s,pfmc);
	}
	
	/** overrides the standard hashtable method.
	 * If the arguments are of the wrong type then throws
	 * ClassCastException
	 * RJM addition Oct 03
	 * TODO is Hashtable always index by Strings?
	 */
	public Object put(Object o,Object p) 
	{
		return put((String) o,(PostfixMathCommandI) p); 
	}
	
	/** returns the PostfixMathCommandI for function with name s. 
	 * RJM addition Oct 03
	 */
	public PostfixMathCommandI get(String s)
	{
		return (PostfixMathCommandI) super.get(s);
	}
	
	/** overrides the standard hashtable method.
	 * If the argument is of the wrong type (i.e. not a String) 
	 * then throws ClassCastException
	 * RJM addition Oct 03
	 */
	
	public Object get(Object o)
	{
		return get((String) o);
	}
}
