package interactive.atebol.mvptest.Login;

/**
 * Created by Admin on 22/03/2016.
 */
public class SynchronousLoginInteractor implements ILoginInteractor {

    public boolean validatedCredentials(String username, String password) {
        return username.contains("gmail");
    }

}
