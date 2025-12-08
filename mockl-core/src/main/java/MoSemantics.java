import domain.MoAction;
import domain.MoConfiguration;
import obp3.runtime.sli.SemanticRelation;

import java.util.List;

public class MoSemantics implements SemanticRelation<MoAction, MoConfiguration> {
    @Override
    public List<MoConfiguration> initial() {
        return List.of(new MoConfiguration(), new MoConfiguration());
    }

    @Override
    public List<MoAction> actions(MoConfiguration configuration) {
        return configuration.actions();
    }

    @Override
    public List<MoConfiguration> execute(MoAction action, MoConfiguration configuration) {
        if (action.id % 2 == 0) {
            var target = new MoConfiguration(configuration);
            target.keysToValues.put("a", action.id);
            return List.of(target);
        }
        var target = new MoConfiguration(configuration);
        target.keysToValues.put("b", action.id);
        return List.of(target);
    }
}
