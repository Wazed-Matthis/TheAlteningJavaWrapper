package wtf.wazed.generation;

import wtf.wazed.utils.WebUtil;
import wtf.wazed.utils.exceptions.NotFoundException;
import wtf.wazed.utils.exceptions.UnauthorizedException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Generator {
    private static Generator instance;

    public Generator(){
        instance = this;
    }


    /**
     *
     * @param token the api token, wich you can find on your TheAltening account page
     * @return Gives back an account prototype with the token and some other informal shit
     * @throws UnauthorizedException is being thrown, when The api key is not valid
     * @throws NotFoundException is being throwen, when I fucked up shit because idk api endpoint should really be the same at any given time
     */
    public Account generate(String token) throws UnauthorizedException, NotFoundException {
        try {
            final List<String> lines = WebUtil.getInstance().performRequest("http://api.thealtening.com/v1/generate?token=" + token + "&info=true");
            final StringBuilder sb = new StringBuilder();

            for(String line : lines){
                sb.append(line).append("\n");
            }

            final JSONObject object = new JSONObject(sb.toString());
            final HashMap map = new HashMap<String, String>();
            final HashMap<String,String> infoMap = new HashMap<>();

            for(String key : object.getJSONObject("info").keySet()){
                infoMap.put(key,object.getJSONObject("info").getString(key));
            }
            final Account tempAccount = new Account(object.getString("token"),object.getString("password"),object.getString("username"), object.getBoolean("limit"), infoMap);
            return tempAccount;
        } catch (IOException e) {
            if(e.getMessage().contains("403")){
                throw new UnauthorizedException();
            }else if(e.getMessage().contains("404")){
                throw new NotFoundException();
            }
            return null;
        }
    }

    public static Generator getInstance() {
        return instance;
    }
}
