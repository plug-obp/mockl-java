import org.junit.jupiter.api.Test;

public class MoSemanticsTest {

    @Test
    void test1(){
        var semantics = new MoSemantics();

        var ini = semantics.initial();
        System.out.println("initials: " + ini);

        if (!ini.isEmpty()) {
            var source = ini.getFirst();
            var actions = semantics.actions(source);
            System.out.println("actions: " + actions);

            if (!actions.isEmpty()) {
                var firstAction = actions.getFirst();
                var targets = semantics.execute(firstAction, source);
                System.out.println("targets: " + targets);
            }
        }
    }

}
