/* @author rich
 * Created on 27-Jul-2003
 *
 * This code is covered by a Creative Commons
 * Attribution, Non Commercial, Share Alike license
 * <a href="http://creativecommons.org/licenses/by-nc-sa/1.0">License</a>
 */
package org.lsmp.djep.vectorJep.function;
import org.lsmp.djep.vectorJep.*;
import org.lsmp.djep.vectorJep.values.*;
import org.nfunk.jep.*;
import org.nfunk.jep.function.UMinus;
/**
 * An extension of the Subtract command to allow it to add MVector's and Matrix's.
 * @author Rich Morris
 * Created on 27-Jul-2003
 */
public class MUMinus extends UMinus implements UnaryOperatorI {

	public Dimensions calcDim(Dimensions ldim)
	{
		return ldim;
	}

	/** calculates the value.
	 * @param res - results will be stored in this object
	 * @param lhs - lhs value
	 * @param rhs - rhs value
	 * @return res
	 */
	public MatrixValueI calcValue(MatrixValueI res,MatrixValueI lhs) throws ParseException
	{
		int len = res.getNumEles();
		for(int i=0;i<len;++i)
			res.setEle(i,super.umin(lhs.getEle(i)));
		return res;
	}


	/**
	 * Negate an objects.
	 */
	
	public Object umin(Object param1) throws ParseException 
	{
		if(param1 instanceof MVector)
			return umin((MVector) param1);
		if(param1 instanceof Matrix)
			return umin((Matrix) param1);
		else
			return super.umin(param1);
	}
	
	/** negate a vector. */
	public MVector umin(MVector lhs) throws ParseException
	{
		MVector res = new MVector(lhs.getNumEles());
		return (MVector) calcValue(res,lhs);
	}

	/** negate a matrix. */
	public Matrix umin(Matrix lhs) throws ParseException
	{
		Matrix res = new Matrix(lhs.getNumRows(),lhs.getNumCols());
		return (Matrix) calcValue(res,lhs);			
	}

	/** negate a tensor. */
	public Tensor umin(Tensor lhs) throws ParseException
	{
		Tensor res = new Tensor(lhs);
		return (Tensor) calcValue(res,lhs);			
	}
}
