package interactive.atebol.mvptest.UI;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.appcompat.BuildConfig;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interactive.atebol.mvptest.Login.ILoginView;
import interactive.atebol.mvptest.Login.LoginPresenter;
import interactive.atebol.mvptest.R;

public class MainActivity extends ActionBarActivity implements ILoginView {

    @Bind(R.id.login_email_edit_text)
    EditText loginEditText;

    @Bind(R.id.login_password_edit_text)
    EditText passwordEditText;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        if (BuildConfig.DEBUG) {
            loginEditText.setText("anthing@gmail.com");
            passwordEditText.setText("$uper$ecret");
        }

        presenter = new LoginPresenter(this); //should be singleton class

    }
    @OnClick(R.id.login_submit_button)
    public void loginTapped(View view){
        String email =  loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        // Pass user event straight to presenter
        presenter.attemptLogin(email, password);
    }

    @Override
    public void navigateToListActivity() {
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Invalid: Use a gmail address", Toast.LENGTH_SHORT).show();
    }
}
