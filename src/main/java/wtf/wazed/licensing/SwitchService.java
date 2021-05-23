package wtf.wazed.licensing;

import wtf.wazed.utils.FieldAdapter;

import java.net.URL;

/**
 * Taken from the WWE mod, credits to Vladymyr
 * @author Vladymyr
 */
public class SwitchService {

    private final String MINECRAFT_SESSION_SERVICE_CLASS = "com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService";
    private final String MINECRAFT_AUTHENTICATION_SERVICE_CLASS = "com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication";

    private final String[] WHITELISTED_DOMAINS = new String[]{".minecraft.net", ".mojang.com", ".thealtening.com"};

    private final FieldAdapter minecraftSessionServer = new FieldAdapter(MINECRAFT_SESSION_SERVICE_CLASS);
    private final FieldAdapter userAuthentication = new FieldAdapter(MINECRAFT_AUTHENTICATION_SERVICE_CLASS);

    private static SwitchService instance;

    public SwitchService() {
        instance = this;
        try {
            minecraftSessionServer.updateFieldIfPresent("WHITELISTED_DOMAINS", WHITELISTED_DOMAINS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * This method updates fields, that are in the authlib library, you can't access them from inside, so
     * this is the only way to really handle it.
     * Credits to vladymyr
     *
     * @param authBase the base domain of the auth server you want to switch to
     * @param sessionBase the base domain of the session server you want to switch to
     */
    public void switchService(String authBase, String sessionBase){
        try {
            String authServer = authBase;
            FieldAdapter userAuth = getUserAuthentication();
            userAuth.updateFieldIfPresent("BASE_URL", authServer);
            userAuth.updateFieldIfPresent("ROUTE_AUTHENTICATE", new URL(authServer + "authenticate"));
            userAuth.updateFieldIfPresent("ROUTE_INVALIDATE", new URL(authServer + "invalidate"));
            userAuth.updateFieldIfPresent("ROUTE_REFRESH", new URL(authServer + "refresh"));
            userAuth.updateFieldIfPresent("ROUTE_VALIDATE", new URL(authServer + "validate"));
            userAuth.updateFieldIfPresent("ROUTE_SIGNOUT", new URL(authServer + "signout"));

            String sessionServer = sessionBase;
            FieldAdapter userSession = getMinecraftSessionServer();
            userSession.updateFieldIfPresent("BASE_URL", sessionServer + "session/minecraft/");
            userSession.updateFieldIfPresent("JOIN_URL", new URL(sessionServer + "session/minecraft/join"));
            userSession.updateFieldIfPresent("CHECK_URL", new URL(sessionServer + "session/minecraft/hasJoined"));
        } catch (Exception ignored) {
        }

    }

    public FieldAdapter getMinecraftSessionServer() {
        return minecraftSessionServer;
    }

    public FieldAdapter getUserAuthentication() {
        return userAuthentication;
    }

    public String getMINECRAFT_AUTHENTICATION_SERVICE_CLASS() {
        return MINECRAFT_AUTHENTICATION_SERVICE_CLASS;
    }

    public String getMINECRAFT_SESSION_SERVICE_CLASS() {
        return MINECRAFT_SESSION_SERVICE_CLASS;
    }

    public static SwitchService getInstance() {
        return instance;
    }

    public String[] getWHITELISTED_DOMAINS() {
        return WHITELISTED_DOMAINS;
    }
}
