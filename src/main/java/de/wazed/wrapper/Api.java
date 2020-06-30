package de.wazed.wrapper;

import de.wazed.wrapper.generation.Generator;
import de.wazed.wrapper.licensing.SwitchService;
import de.wazed.wrapper.utils.WebUtil;

public class Api {

    public static void init(){
        new Generator();
        new WebUtil();
        new SwitchService();
    }

}
