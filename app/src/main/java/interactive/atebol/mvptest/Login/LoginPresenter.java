package interactive.atebol.mvptest.Login;


public class LoginPresenter implements ILoginPresenter{

    private ILoginView view;
    private ILoginInteractor interactor;

    public LoginPresenter(ILoginView iLoginView){
        this.view = iLoginView;
        this.interactor = new SynchronousLoginInteractor();
    }

    public void attemptLogin(String username, String password){
        boolean isValid = interactor.validatedCredentials(username, password);
        if(isValid){
            view.navigateToListActivity();
        }else{
            view.loginFailed();
        }
    }
}
