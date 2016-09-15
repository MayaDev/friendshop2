package app.com.wordpress.yesdevpro.friendshop;

import com.firebase.client.Firebase;

/**
 * This class holds all the activities done on firebase
 */
public class FirebaseAccess {

    //reference to firebase (move later to relevant class usage)
    Firebase rootRef = new Firebase("https://docs-examples.firebaseio.com/web/data");

    private Object ReadData(String urlToFetch){
        //urlToFetch = "https://docs-examples.firebaseio.com/web/data/users/mchen/name"
        Firebase rootRef = new Firebase(urlToFetch);
        return rootRef;
    }


}

