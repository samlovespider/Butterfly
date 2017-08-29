package com.proproject.butterfly.model;

import android.support.annotation.Nullable;

import com.facebook.AccessTokenSource;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by caizhenliang on 2017/8/29.
 */
public class FacebookModel implements Serializable {

    private static final long serialVersionUID = 5242723750544543678L;

    String accessToken;
    String applicationId;
    String userId;
    Collection<String> permissions;
    Collection<String> declinedPermissions;
    AccessTokenSource accessTokenSource;
    Date expirationTime;
    Date lastRefreshTime;

    /**
     * Creates a new AccessToken using the supplied information from a previously-obtained access
     * token (for instance, from an already-cached access token obtained prior to integration with
     * the Facebook SDK). Note that the caller is asserting that all parameters provided are correct
     * with respect to the access token string; no validation is done to verify they are correct.
     *
     * @param accessToken         the access token string obtained from Facebook
     * @param applicationId       the ID of the Facebook Application associated with this access
     *                            token
     * @param userId              the id of the user
     * @param permissions         the permissions that were requested when the token was obtained
     *                            (or when it was last reauthorized); may be null if permission set
     *                            is unknown
     * @param declinedPermissions the permissions that were declined when the token was obtained;
     *                            may be null if permission set is unknown
     * @param accessTokenSource   an enum indicating how the token was originally obtained (in most
     *                            cases, this will be either AccessTokenSource.FACEBOOK_APPLICATION
     *                            or AccessTokenSource.WEB_VIEW); if null, FACEBOOK_APPLICATION is
     *                            assumed.
     * @param expirationTime      the expiration date associated with the token; if null, an
     *                            infinite expiration time is assumed (but will become correct when
     *                            the token is refreshed)
     * @param lastRefreshTime     the last time the token was refreshed (or when it was first
     */
    public FacebookModel(String accessToken, String applicationId, String userId, @Nullable Collection<String> permissions, @Nullable Collection<String> declinedPermissions, @Nullable AccessTokenSource accessTokenSource, @Nullable Date expirationTime, @Nullable Date lastRefreshTime) {
        this.accessToken = accessToken;
        this.applicationId = applicationId;
        this.userId = userId;
        this.permissions = permissions;
        this.declinedPermissions = declinedPermissions;
        this.accessTokenSource = accessTokenSource;
        this.expirationTime = expirationTime;
        this.lastRefreshTime = lastRefreshTime;
    }

    @Override
    public String toString() {
        return "FacebookModel{" +
                "accessToken='" + accessToken + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", userId='" + userId + '\'' +
                ", permissions=" + permissions +
                ", declinedPermissions=" + declinedPermissions +
                ", accessTokenSource=" + accessTokenSource +
                ", expirationTime=" + expirationTime +
                ", lastRefreshTime=" + lastRefreshTime +
                '}';
    }
}
