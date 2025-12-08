package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MoConfiguration {
    public Map<String, Integer> keysToValues;
    public MoConfiguration() {
        keysToValues = Map.of(
                "a", 0,
                "b", 0
        );
    }

    public MoConfiguration(MoConfiguration old) {
        keysToValues = new HashMap<>(old.keysToValues);
    }

    public List<MoAction> actions() {
        return List.of(
                new MoAction(3),
                new MoAction(2)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoConfiguration that = (MoConfiguration) o;
        return Objects.equals(keysToValues, that.keysToValues);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(keysToValues);
    }

    @Override
    public String toString() {
        return "MoConfiguration{" +
                "keysToValues=" + keysToValues +
                '}';
    }
}
