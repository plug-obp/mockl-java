import obp3.Sequencer;
import obp3.sli.core.operators.ToDetermistic;

public class MoRunner {
    public static void main(String[] args) {
        var semantics = new MoSemantics();
        var deterministic = ToDetermistic.randomPolicy(semantics, System.nanoTime());
        var sequencer = new Sequencer<>(deterministic);

        int[] count = new int[]{10};

        var result = sequencer.run(c -> {
            System.out.println(c);
            return count[0]-- <= 1;
        });
    }
}
