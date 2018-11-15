package sv.com.ariel.tellmeastory.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import sv.com.ariel.tellmeastory.R;

public class Usuario extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private ImageView profile_image;
    private TextView nameTxt;
    private TextView emailTxt;
    private TextView idTxt;

    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ImageButton home = (ImageButton) findViewById(R.id.inicio);
        home.setOnClickListener(this);

        ImageButton biblio = (ImageButton) findViewById(R.id.biblioteca);
        biblio.setOnClickListener(this);

        ImageButton agregar = (ImageButton) findViewById(R.id.agregar);
        agregar.setOnClickListener(this);

        ImageButton noti = (ImageButton) findViewById(R.id.actualizaciones);
        noti.setOnClickListener(this);

        ImageButton usuario = (ImageButton) findViewById(R.id.usuario);
        usuario.setOnClickListener(this);


        profile_image = (ImageView) findViewById(R.id.profile_image);
        nameTxt = (TextView) findViewById(R.id.nameTxt);
        emailTxt = (TextView) findViewById(R.id.emailTxt);
        idTxt = (TextView) findViewById(R.id.idTxt);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.inicio:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.biblioteca:
                intent = new Intent(this, Biblioteca.class);
                startActivity(intent);
                break;

            case R.id.agregar:
                intent = new Intent(this, AgregarHistoria.class);
                startActivity(intent);
                break;

            case R.id.actualizaciones:
                intent = new Intent(this, Notificaciones.class);
                startActivity(intent);
                break;

            case R.id.usuario:
                intent = new Intent(this, Usuario.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()) {
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            nameTxt.setText(account.getDisplayName());
            emailTxt.setText(account.getEmail());
            idTxt.setText(account.getFamilyName());

            Glide.with(this).load(account.getPhotoUrl()).into(profile_image);
        } else {
            goLogInScreen();
        }
    }

    private void goLogInScreen() {
        Intent intent = new Intent(this, Usuario.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}