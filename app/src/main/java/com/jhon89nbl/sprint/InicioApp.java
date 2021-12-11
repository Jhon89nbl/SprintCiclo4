package com.jhon89nbl.sprint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//nav_host_fragment_activity_navigation_menu
import android.os.Bundle;

import com.jhon89nbl.sprint.databinding.ActivityInicioAppBinding;

public class InicioApp extends AppCompatActivity {

    private ActivityInicioAppBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_app);

        binding = ActivityInicioAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
          R.id.navigation_home, R.id.navigation_perfil, R.id.navigation_publicaciones).build();
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_activity);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView,navController);
    }
}