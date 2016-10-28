package com.mashazavolnyuk.aquarium;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;

public class MainActivity extends AppCompatActivity {
    ImageView imgVkShare;
    private String[] scope = new String[]{VKScope.WALL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void loggin() {
        VKSdk.login(this, scope);
        loadPhotoToMyWall( "qw");

    }

    void makePost(VKAttachments att, String msg, final int ownerId) {
        VKParameters parameters = new VKParameters();
        parameters.put(VKApiConst.OWNER_ID, String.valueOf(ownerId));
        parameters.put(VKApiConst.ATTACHMENTS, att);
        parameters.put(VKApiConst.MESSAGE, msg);
        VKRequest post = VKApi.wall().post(parameters);
        post.setModelClass(VKWallPostResult.class);
        post.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                // post was added
            }
            @Override
            public void onError(VKError error) {
                // error
            }
        });
    }

    void loadPhotoToMyWall( final String message) {
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.clownfish);
        VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(bitmap,
                VKImageParameters.jpgImage(0.9f)), getMyId(), 0);
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                // recycle bitmap
                VKApiPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
                makePost(new VKAttachments(photoModel), message, getMyId());
            }

            @Override
            public void onError(VKError error) {
                // error
            }
        });
    }

    int getMyId() {
        final VKAccessToken vkAccessToken = VKAccessToken.currentToken();
        return vkAccessToken != null ? Integer.parseInt(vkAccessToken.userId) : 0;
    }

//    private void shareVk() {
//        VKPhotoArray photos = new VKPhotoArray();
//        photos.add(new VKApiPhoto("photo-47200925_314622346"));
//        final VKShareDialogBuilder builder = new VKShareDialogBuilder();
//        builder.setText("I created this post with VK Android SDK" +
//                "\nSee additional information below\n#vksdk");
//        builder.setUploadedPhotos(photos);
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.clownfish);
//        builder.setAttachmentImages(new VKUploadImage[]{
//                new VKUploadImage(bmp, VKImageParameters.pngImage())
//        });
//        builder.setAttachmentLink("VK Android SDK information",
//                "https://vk.com/dev/android_sdk");
//        builder.setShareDialogListener(new VKShareDialog.VKShareDialogListener() {
//            @Override
//            public void onVkShareComplete(int postId) {
//                // recycle bitmap if need
//            }
//
//            @Override
//            public void onVkShareCancel() {
//            }
//
//            @Override
//            public void onVkShareError(VKError error) {
//                // recycle bitmap if need
//            }
//        });
//        builder.show(getFragmentManager(), "VK_SHARE_DIALOG");
//
//    }
}
