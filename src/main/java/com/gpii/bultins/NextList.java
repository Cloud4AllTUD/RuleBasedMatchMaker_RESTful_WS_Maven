package com.gpii.bultins;

import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.reasoner.rulesys.BindingEnvironment;
import com.hp.hpl.jena.reasoner.rulesys.RuleContext;
import com.hp.hpl.jena.reasoner.rulesys.Util;
import com.hp.hpl.jena.reasoner.rulesys.builtins.BaseBuiltin;

public class NextList extends BaseBuiltin {

  /**
  * Return a name for this builtin, normally this will be the name of the
  * functor that will be used to invoke it.
  */
  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "nextMax";
  }
  
  /**
  * This method is invoked when the builtin is called in a rule body.
  * @param args the array of argument values for the builtin, this is an array
  * of Nodes, some of which may be Node_RuleVariables.
  * @param length the length of the argument list, may be less than the length of the args array
  * for some rule engines
  * @param context an execution context giving access to other relevant data
   * @return 
  * @return return true if the buildin predicate is deemed to have succeeded in
  * the current environment
  */
  public boolean bodyCall(final Node[] args, final int length, final RuleContext context) {
      checkArgs(length, context);
      BindingEnvironment env = context.getEnv();
      final Node n1 = getArg(0, args, context);
      final Node n2 = getArg(1, args, context);
      
      List<Node> list = Util.convertList(n1, context);
      Node nextRating = Util.makeIntNode(getNextMax(list, n2));
      return env.bind(args[2], nextRating);
}
  

  private int getNextMax(List<Node> list, Node n2) {
    int new_value = 0;
    
    // n2 is current max; get value of n2 and convert to int 
    int old_value = 0; 
    
    if(n2.isLiteral()){
      Object n2_value = n2.getLiteralValue();
      if(n2_value instanceof Number){
        old_value = ((Number)n2_value).intValue();
      }
    }
    
    Iterator<Node> i = list.iterator();
    while(i.hasNext()){
      Node next_node = i.next();
      if(next_node.isLiteral()){
        Object next_value = next_node.getLiteralValue();
        if(next_value instanceof Number){
          int nextListValue = ((Number)next_value).intValue();
          if(nextListValue < old_value){
            old_value = nextListValue;
          }
        }
      }
    }
    new_value = old_value;
    return new_value;
  }
}
