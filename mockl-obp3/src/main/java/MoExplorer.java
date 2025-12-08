import domain.MoConfiguration;
import obp3.sli.core.operators.SemanticRelation2RootedGraph;
import obp3.traversal.dfs.DepthFirstTraversal;

public class MoExplorer {

    public static void main(String[] args) {
        var semantics = new MoSemantics();
        var rootedGraph = new SemanticRelation2RootedGraph<>(semantics);
        var dfs = new DepthFirstTraversal<>(rootedGraph);

        var result = dfs.runAlone();
        System.out.println(result);

        var dfs1 = new DepthFirstTraversal<>(
                rootedGraph,
                (MoConfiguration v) -> v.hashCode() % 2);

        var result1 = dfs1.runAlone();
        System.out.println(result1);
    }

/* DFTConfigurationSetDeque(
    (stack=[]),
    known=[
        MoConfiguration{keysToValues={a=0, b=3}},
        MoConfiguration{keysToValues={b=0, a=0}},
        MoConfiguration{keysToValues={a=2, b=3}},
        MoConfiguration{keysToValues={a=2, b=0}}])


 */
}