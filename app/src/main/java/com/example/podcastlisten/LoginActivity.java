package com.example.podcastlisten;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.podcastlisten.models.Usuario;
import com.example.podcastlisten.util.Preferencias;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Arrays;
import java.util.List;


public class LoginActivity extends BaseActivity {

    private static final int RC_GOOGLE_SIGN_IN = 9001;
    private static String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private TextView mNameLogin;
    private Button mBttDisconect;
    /*********************************FACEBOOK**************************/

    private LoginButton mBttLoginFacebook;
    private ImageView mImageLogin;
    private CallbackManager callbackManager;


    /***********************FIREBASE********************/
    /**********************LOGIN GOOGLE**********************/
    private SignInButton bttLoginGoogle;


    /*******************FIM DO FIREBASE*****************/
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();
        iniciarFirebase();

        mImageLogin = findViewById(R.id.act_login_image_user);
        setProgressBar(R.id.progressBar);
        mNameLogin = findViewById(R.id.act_login_name_user);
        mBttDisconect = findViewById(R.id.act_login_btt_disconect);

        mBttDisconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        mountGoogleLoginInterface();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    /**
     * Se tiver logado, redireciona para a tela de login
     */
    public void goToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void iniciarFirebase() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    return;
                }
                String token = task.getResult().getToken();
                Log.d(TAG, token);
            }
        });
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
    }

    /**
     * Recebe os retornas da activitys de Login do Face e do Google
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //facebook login
        if (callbackManager != null)
            callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        //google login
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_GOOGLE_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }

    /*************FIM DO FACEBOOK**************************/

    /**
     * Depois que o usuário fizer login pelo Facebook, faz um login no Firebase também
     *
     * @param token
     */
    private void firebaseAuthWithFacebook(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d(TAG, "signInWithCredential:success" + user.getDisplayName());
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Erro na autenticação.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    /**
     * Sempre que faz o login, tenta criar o usuário na tabela usuário
     */
    private void criaUsuario(String email, String google_id) {
        Usuario.crieUsuarioIfNotExist(email, google_id);
    }

    private void mountFacebookLoginInterface() {
        mBttLoginFacebook = null;// headerView.findViewById(R.id.act_login_button_facebook);


        callbackManager = CallbackManager.Factory.create();

        if (mBttLoginFacebook != null) {
            mBttLoginFacebook.setReadPermissions(Arrays.asList("email", "public_profile"));

            // Callback registration
            mBttLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    Log.d(TAG, "facebook:onSuccess:" + loginResult);
                    firebaseAuthWithFacebook(loginResult.getAccessToken());
                }

                @Override
                public void onCancel() {
                    Log.d(TAG, "facebook:onCancel");
                }

                @Override
                public void onError(FacebookException exception) {
                    Log.d(TAG, "facebook:onError", exception);
                }
            });
        }
    }

    private void mountGoogleLoginInterface() {

        // Button listeners

        bttLoginGoogle = findViewById(R.id.act_login_button_google);
        if (bttLoginGoogle != null) {
            bttLoginGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn();
                }
            });
        }

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        showProgressBar();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_GOOGLE_SIGN_IN);
    }
    // [END signin]

    private void signOut() {
        // Firebase sign out
        mAuth.signOut();

        LoginManager.getInstance().logOut();


        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI(null);
                    }
                });
    }

    private void revokeAccess() {
        // Firebase sign out
        mAuth.signOut();

        // Google revoke access
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        hideProgressBar();
        if (user != null) {
            //cria o usuário no sistema, caso ele ainda não exista
            //esse getEmail funciona pro login no Facebook, mas não está funcionando pro Login no Google
            String email = user.getEmail();
            if (email == null || email.trim().length() == 0) {
                List<? extends UserInfo> providerData = user.getProviderData();
                if (providerData.size() > 0) {
                    email = providerData.get(1).getEmail();
                }
            }

            criaUsuario(email, user.getUid());

            //salva o e-mail num arquivo compartilhado, para posterior acesso em outras activities
            Preferencias pref = new Preferencias(this.getBaseContext());
            pref.salvaEmail(email);

            mNameLogin.setText(user.getDisplayName());
            //arredonda a imagem
            Glide.with(LoginActivity.this).load(user.getPhotoUrl()).apply(RequestOptions.circleCropTransform()).into(mImageLogin);

            mNameLogin.setVisibility(View.VISIBLE);
            mImageLogin.setVisibility(View.VISIBLE);

            bttLoginGoogle.setVisibility(View.GONE);
            if (mBttLoginFacebook != null)
                mBttLoginFacebook.setVisibility(View.GONE);
            mBttDisconect.setVisibility(View.VISIBLE);

            goToMainActivity();

        } else {
            mNameLogin.setVisibility(View.GONE);
            mImageLogin.setVisibility(View.GONE);

            bttLoginGoogle.setVisibility(View.VISIBLE);
            if (mBttLoginFacebook != null)
                mBttLoginFacebook.setVisibility(View.VISIBLE);
            mBttDisconect.setVisibility(View.GONE);

        }
    }


/*****************FIM LOGIN GOOGLE*********************************/
}
