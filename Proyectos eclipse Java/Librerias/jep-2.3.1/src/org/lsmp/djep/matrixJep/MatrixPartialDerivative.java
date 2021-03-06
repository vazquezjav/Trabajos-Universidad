/* @author rich
 * Created on 29-Oct-2003
 *
 * This code is covered by a Creative Commons
 * Attribution, Non Commercial, Share Alike license
 * <a href="http://creativecommons.org/licenses/by-nc-sa/1.0">License</a>
 */
package org.lsmp.djep.matrixJep;
import org.nfunk.jep.*;
import org.lsmp.djep.djep.*;
import org.lsmp.djep.vectorJep.*;
import org.lsmp.djep.vectorJep.values.*;
/**
 * Contains infomation about a PartialDerivative of a variable.
 * 
 * @author Rich Morris
 * Created on 29-Oct-2003
 * TODO Should setValue be overwritten?
 */
public class MatrixPartialDerivative extends PartialDerivative implements MatrixVariableI {

	private MatrixValueI mvalue = null;

	/**
	 * Protected constructor, should only be constructed
	 * through the findDerivative method in {@link MatrixVariable}.
	**/ 
	protected MatrixPartialDerivative(MatrixVariable var, String derivnames[],Node deriv)
	{
		super(var,derivnames,deriv);
		setValidValue(false);
		mvalue=Tensor.getInstance(var.getDimensions());
	}
	
	public Dimensions getDimensions()
	{
		MatrixVariableI root = (MatrixVariableI) getRoot();
		return root.getDimensions();
	}
	public void setDimensions(Dimensions dims)	{}
	public MatrixValueI getMValue() { return mvalue; }

	public void setMValue(MatrixValueI val) {
		if(this.isConstant()) return;
		mvalue.setEles(val);
		setValidValue(true);
		setChanged();
		notifyObservers();
	}
//	public void setMValue(VectorMatrixTensorI value) 
//	{ this.mvalue = value; setValidValue(true); }
}
