import de.wazed.wrapper.Api;
import de.wazed.wrapper.generation.Account;
import de.wazed.wrapper.generation.Generator;
import de.wazed.wrapper.utils.exceptions.NotFoundException;
import de.wazed.wrapper.utils.exceptions.UnauthorizedException;

public class TestMain {

    public static void main(String[] args) {
        Api.init();
        try {
            Account account = Generator.getInstance().generate("api-315a-db84-8d1a");
            System.out.println(account.getUsername() + "\n" +  account.getPassword() + "\n" +  account.getToken());
            account.getInfo().forEach((e,e1)-> System.out.println(e + ": " + e1));
        } catch (UnauthorizedException e) {
            System.err.println("U are not authorized!");
        } catch (NotFoundException e) {
            System.err.println("404");
        }
    }

}
