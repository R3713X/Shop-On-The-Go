package com.sirialkillers.shoponthego.Notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Xristos Aslamagidis on 10/12/2017.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService{

    private static final String REG_TOKEN="REG_TOKEN";

    @Override
    public void onTokenRefresh() {
        String recentToken= FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recentToken);

    }
}
