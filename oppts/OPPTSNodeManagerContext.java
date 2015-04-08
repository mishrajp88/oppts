package oppts;

/**
 *
 * @author jyotiprakash
 */
public class OPPTSNodeManagerContext {
    private static OPPTSNodeManagerContext self = null;
    
    private OPPTSNodeManagerContext() {
        
    }
    
    public static OPPTSNodeManagerContext getInstance() {
        if (self == null)
            self = new OPPTSNodeManagerContext();
        return self;
    }
}
