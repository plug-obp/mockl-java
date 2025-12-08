import domain.MoAction;
import domain.MoConfiguration;
import obp3.modelchecking.tools.StatePredicateModelCheckerModel;
import obp3.traversal.dfs.DepthFirstTraversal;


public class MoInvariantChecker {

    public static void main (String[] args) {
        var semantics = new MoSemantics();
        var invariantChecker = new StatePredicateModelCheckerModel
                .StatePredicateModelBuilder<MoAction, MoConfiguration>()
                .traversalStrategy(DepthFirstTraversal.Algorithm.WHILE)
                .modelSemantics(semantics)
                .acceptingPredicate(( c) -> !(c.keysToValues.get("b") != 3))
                .build();

        var result = invariantChecker.modelChecker().runAlone();
        System.out.println(result);
    }
}
