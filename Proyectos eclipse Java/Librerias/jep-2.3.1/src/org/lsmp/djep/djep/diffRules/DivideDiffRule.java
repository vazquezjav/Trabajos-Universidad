/* @author rich
 * Created on 04-Jul-2003
 *
 * This code is covered by a Creative Commons
 * Attribution, Non Commercial, Share Alike license
 * <a href="http://creativecommons.org/licenses/by-nc-sa/1.0">License</a>
 */
package org.lsmp.djep.djep.diffRules;

import org.nfunk.jep.ASTFunNode;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.lsmp.djep.djep.DJep;
import org.lsmp.djep.djep.DiffRulesI;
import org.lsmp.djep.xjep.*;

/**
   * Diffrentiates a division with respect to var.
   * diff(y/z,x) -> (diff(y,x)*z-y*diff(z,x))/(z*z)
   */
  public class DivideDiffRule implements DiffRulesI
  {
	private String name;
	//private DifferentationVisitor dv;
	
	private DivideDiffRule() {}
	public DivideDiffRule(String inName)
	{	  
	  //dv = inDv;
	  name = inName;
	}

	public String toString()
	{	  return name + "  \t\tdiff(f/g,x) -> (diff(f,x)*g-f*diff(g,x))/(g*g)";  }
	public String getName() { return name; }
  	
	public Node differentiate(ASTFunNode node,String var,Node [] children,Node [] dchildren,DJep djep) throws ParseException
	{
	  XOperatorSet op = (XOperatorSet) djep.getOperatorSet();
	  NodeFactory nf = djep.getNodeFactory();
	  
	  int nchild = node.jjtGetNumChildren();
	  if(nchild==2) return 
			nf.buildOperatorNode(op.getDivide(),
			  nf.buildOperatorNode(op.getSubtract(),
				nf.buildOperatorNode(op.getMultiply(),
				  dchildren[0],
				  djep.deepCopy(children[1])),
				nf.buildOperatorNode(op.getMultiply(),
				  djep.deepCopy(children[0]),
				  dchildren[1])),
			  nf.buildOperatorNode(op.getMultiply(),
				djep.deepCopy(children[1]),
				djep.deepCopy(children[1])));
	  else
		throw new ParseException("Too many children "+nchild+" for "+node+"\n");
	}
  } /* end DivideDiffRule */
