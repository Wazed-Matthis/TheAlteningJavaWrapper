import wtf.wazed.Api;
import wtf.wazed.generation.Account;
import wtf.wazed.generation.Generator;
import wtf.wazed.utils.exceptions.NotFoundException;
import wtf.wazed.utils.exceptions.UnauthorizedException;

public class TestMain {

    public static void main(String[] args) {
        Api.init();
        try {
            Account account = Generator.getInstance().generate("<token>");
            System.out.println(account.getUsername() + "\n" +  account.getPassword() + "\n" +  account.getToken());
            account.getInfo().forEach((e,e1)-> System.out.println(e + ": " + e1));
        } catch (UnauthorizedException e) {
            System.err.println("U are not authorized!");
        } catch (NotFoundException e) {
            System.err.println("404");
        }
    }
}
