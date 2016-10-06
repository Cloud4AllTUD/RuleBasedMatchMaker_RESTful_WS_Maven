package com.gpii.bultins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.reasoner.rulesys.BindingEnvironment;
import com.hp.hpl.jena.reasoner.rulesys.RuleContext;
import com.hp.hpl.jena.reasoner.rulesys.Util;
import com.hp.hpl.jena.reasoner.rulesys.builtins.BaseBuiltin;

public class MaxList extends BaseBuiltin {

  /**
  * Return a name for this builtin, normally this will be the name of the
  * functor that will be used to invoke it.
  */
  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "maxList";
  }
  
  /**
  * This method is invoked when the builtin is called in a rule body.
  * @param args the array of argument values for the builtin, this is an array
  * of Nodes, some of which may be Node_RuleVariables.
  * @param length the length of the argument list, may be less than the length of the args array
  * for some rule engines
  * @param context an execution context giving access to other relevant data
  * @return return true if the buildin predicate is deemed to have succeeded in
  * the current environment
  */
  public boolean bodyCall(final Node[] args, final int length, final RuleContext context) {
      checkArgs(length, context);
      BindingEnvironment env = context.getEnv();
      final Node n1 = getArg(0, args, context);
      
      List<Node> list = Util.convertList(n1, context);
      Node max = Util.makeIntNode(getMax(list));
      return env.bind(args[1], max);
  }
  

  private int getMax(List<Node> node) {
    int max = 0;
    Iterator<Node> i = node.iterator();
    while(i.hasNext()){
      Node next = i.next();
      if(next.isLiteral()){
        Object value = next.getLiteralValue();
        if(value instanceof Number){
          int newMax = ((Number)value).intValue();
          if(newMax > max){ 
            max = newMax;
          }
        }
      }
    }
    return max;
  }
}
