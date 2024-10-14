package com.upiita.animaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    TextView texto1;
    Button bt1;
    AnimationSet animaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto1 = findViewById(R.id.texto1);
        bt1 = findViewById(R.id.boton1);

        // Crear el conjunto de animaciones
        animaciones = new AnimationSet(false);

        // Animación de traslación
        int rs1 = TranslateAnimation.RELATIVE_TO_PARENT;
        Animation anim1 = new TranslateAnimation(rs1, 0, rs1, 0, rs1, 0, rs1, 1);
        anim1.setFillAfter(false);
        anim1.setDuration(3000);
        animaciones.addAnimation(anim1);

        // Animación de escalamiento
        int rs2 = ScaleAnimation.RELATIVE_TO_PARENT;
        Animation anim2 = new ScaleAnimation(0, 2, 0, 2, rs2, 0.5f, rs2, 0.5f);
        anim2.setFillAfter(true);
        anim2.setDuration(5000);
        animaciones.addAnimation(anim2);

        // Animación de rotación
        int rs3 = RotateAnimation.RELATIVE_TO_PARENT;
        Animation anim3 = new RotateAnimation(0, 360, rs3, 0.5f, rs3, 0.5f);
        anim3.setFillAfter(false);
        anim3.setDuration(5000);
        animaciones.addAnimation(anim3);

        // Animación de opacidad
        Animation anim4 = new AlphaAnimation(0, 1);
        anim4.setFillAfter(true);
        anim4.setDuration(3000);
        animaciones.addAnimation(anim4);

        // Animación de escala con rebote
        Animation anim5 = new ScaleAnimation(1, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim5.setFillAfter(true);
        anim5.setDuration(5000);
        anim5.setInterpolator(new BounceInterpolator());
        animaciones.addAnimation(anim5);

        // Asignar listener al conjunto de animaciones
        animaciones.setAnimationListener(this);

        bt1.setOnClickListener(this);

        // Iniciar todas las animaciones secuencialmente
        texto1.startAnimation(animaciones);
    }

    @Override
    public void onClick(View v) {
        texto1.setText("IPN");
        bt1.startAnimation(animaciones); // Inicia la animación 5 (escala con rebote)
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // No se necesita acción específica al inicio de la animación
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Aquí podrías realizar acciones al finalizar cada animación si es necesario
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // Acciones al repetirse la animación (si se requieren)
    }
}
