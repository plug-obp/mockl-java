import gpsl.modelchecker.StepModelChecker;

public class MoGPSLModelChecker {

    public static void main(String[] args) {
        var semantics = new MoSemantics();
        String prop = "prop=G |model.action.state.goes.to(34)| && |otherThing|";
        var checker = new StepModelChecker<>(
                semantics,
                (e, step) ->  {
                    System.out.println("----- <expression = "+ e + ", step = " + step + ">"); return true; },
                prop);
        var result =  checker.modelChecker().runAlone();
        System.out.println(result);
    }
}

/// G (|batteryCharge' == batteryCharge + 1|)

/// Step: {
/// source: SysMLConfiguration(...batteryCharge = 80 ... successions={ 3228X239 } flows={} ) ,
/// action: INode (XBehAction) | Stutter
/// target: SysMLConfiguration(...batteryCharge = 81)
/// }


/// G F | S(UUID)  |   |S'(UUID)|