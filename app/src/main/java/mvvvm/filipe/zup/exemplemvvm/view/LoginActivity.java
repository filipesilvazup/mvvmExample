package mvvvm.filipe.zup.exemplemvvm.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mvvvm.filipe.zup.exemplemvvm.R;
import mvvvm.filipe.zup.exemplemvvm.databinding.ActivityLoginBinding;
import mvvvm.filipe.zup.exemplemvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel loginViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLoginViewModel(loginViewModel);
        binding.executePendingBindings();

    }

    public void onLoginClick(View v) {
        String  email = binding.edtEmail.getText().toString();
        String senha = binding.edtSenha.getText().toString();
        Intent it = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("senha", senha);
        it.putExtras(bundle);
        startActivity(it);

    }


}
