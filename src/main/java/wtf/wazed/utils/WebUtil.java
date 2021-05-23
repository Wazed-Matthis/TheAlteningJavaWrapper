package wtf.wazed.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebUtil {

    private static WebUtil instance;

    public WebUtil(){
        instance = this;
    }

    /**
     *
     * @param url the url, the GET request is performed to
     * @return returns a list with all lines of the response
     */
    public List<String> performRequest(String url) throws IOException {
        final List<String> tempList = new ArrayList<>();
        final URL requestUrl = new URL(url);
        final BufferedReader br = new BufferedReader(new InputStreamReader(requestUrl.openStream()));
        String line;
        while((line = br.readLine()) != null){
            tempList.add(line);
        }
        return tempList;
    }

    public static WebUtil getInstance() {
        return instance;
    }
}
