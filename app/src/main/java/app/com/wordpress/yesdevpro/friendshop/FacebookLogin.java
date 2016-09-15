package app.com.wordpress.yesdevpro.friendshop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

//import com.facebook.AccessTokenTracker;
//import com.facebook.CallbackManager;
//import com.facebook.login.widget.LoginButton;
//import com.firebase.client.AuthData;
//import com.firebase.client.Firebase;
//import com.firebase.client.core.view.View;

public class FacebookLogin extends Activity {

    private static final String TAG = FacebookLogin.class.getSimpleName();

    /* *************************************
     *              GENERAL                *
     ***************************************/
    /* TextView that is used to display information about the logged in user */
    private TextView mLoggedInStatusTextView;

    /* A dialog that is presented until the Firebase authentication finished. */
    private ProgressDialog mAuthProgressDialog;

    /* A reference to the Firebase */
    private Firebase mFirebaseRef;

    /* Data from the authenticated user */
    private AuthData mAuthData;

    /* Listener for Firebase session changes */
    private Firebase.AuthStateListener mAuthStateListener;

    /* *************************************
     *              FACEBOOK               *
     ***************************************/
    /* The login button for Facebook */
    private LoginButton mFacebookLoginButton;
    /* The callback manager for Facebook */
    private CallbackManager mFacebookCallbackManager;
    /* Used to track user logging in/out off Facebook */
    private AccessTokenTracker mFacebookAccessTokenTracker;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        //Initialize the facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        final TextView loginInfo = (TextView)findViewById(R.id.login_info);
        //create a callback manager to handle login responses.
        mFacebookCallbackManager = CallbackManager.Factory.create();
        mFacebookLoginButton = (LoginButton) findViewById(R.id.login_button);
        mFacebookLoginButton.setReadPermissions("email", "user_friends", "public_profile");
        mFacebookLoginButton.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginInfo.setText(getText(R.string.facebook_login_status_onsuccses));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container,
//                             Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.activity_login, container, false);
//        final TextView loginInfo = (TextView)view.findViewById(R.id.login_info);
//        mFacebookLoginButton = (LoginButton) view.findViewById(R.id.login_button);
//        mFacebookLoginButton.setFragment(this);
//        mFacebookLoginButton.setReadPermissions("email", "user_friends", "public_profile");
//        mFacebookLoginButton.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                loginInfo.setText(getText(R.string.facebook_login_status_onsuccses));
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });
//
//        return view;
//
//    }

}


