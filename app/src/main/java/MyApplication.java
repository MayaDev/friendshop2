import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.client.Firebase;

/**
 * Created by mayacarmi on 5/22/16.
 */
public class MyApplication extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
