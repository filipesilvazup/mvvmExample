package mvvvm.filipe.zup.exemplemvvm.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mvvvm.filipe.zup.exemplemvvm.R;
import mvvvm.filipe.zup.exemplemvvm.databinding.ActivityMainBinding;
import mvvvm.filipe.zup.exemplemvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private String email;
    private String senha;
    ActivityMainBinding binding;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("email");
        senha = bundle.getString("senha");

        mainViewModel = new MainViewModel();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLogoutViewModel(mainViewModel);
        binding.executePendingBindings();

        binding.getLogoutViewModel().boasVindas.set("Bem vindo " + email);

    }

    public void onLogoutClick(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
