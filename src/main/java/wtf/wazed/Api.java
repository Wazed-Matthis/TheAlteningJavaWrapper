package wtf.wazed;

import wtf.wazed.generation.Generator;
import wtf.wazed.licensing.SwitchService;
import wtf.wazed.utils.WebUtil;

public class Api {

    public static void init(){
        new Generator();
        new WebUtil();
        new SwitchService();
    }

}
