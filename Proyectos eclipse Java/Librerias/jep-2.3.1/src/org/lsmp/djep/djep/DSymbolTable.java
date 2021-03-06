/* @author rich
 * Created on 23-Nov-2003
 *
 * This code is covered by a Creative Commons
 * Attribution, Non Commercial, Share Alike license
 * <a href="http://creativecommons.org/licenses/by-nc-sa/1.0">License</a>
 */
package org.lsmp.djep.djep;

import org.nfunk.jep.*;
import org.lsmp.djep.xjep.*;
import java.util.*;
/**
 * A SymbolTable which works with partial derivatives of variables.
 * Closely linked with 
 * {@link DVariableFactory DVariableFactory}
 *   
 * @author Rich Morris
 * Created on 23-Nov-2003
 */
public class DSymbolTable extends XSymbolTable {
	public DSymbolTable(VariableFactory varFac)
	{
		super(varFac);
	}

	/** Creates a new SymbolTable with the same variable factory as this. */
	public SymbolTable newInstance()
	{
		return new DSymbolTable(vf);
	}

	public PartialDerivative getPartialDeriv(String name,String dnames[])
	{
		DVariable var = (DVariable) getVar(name);
		return var.getDerivative(dnames);
	}
	

	public void clearValues()
	{
		for(Enumeration e = this.elements(); e.hasMoreElements(); ) 
		{
			DVariable var = (DVariable) e.nextElement();
			var.invalidateAll();
		}
	}	
}
