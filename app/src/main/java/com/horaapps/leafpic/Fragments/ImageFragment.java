package com.horaapps.leafpic.Fragments;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.horaapps.leafpic.Base.Media;
import com.horaapps.leafpic.R;
import com.horaapps.leafpic.figleaf.Figleaf;
import com.horaapps.leafpic.utils.Measure;
import com.koushikdutta.ion.Ion;
import com.horaapps.leafpic.PhotoPagerActivity;

import java.util.Arrays;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by dnld on 18/02/16.
 */

@SuppressWarnings("ResourceType")
public class ImageFragment extends Fragment {

    private Media img;

    public static ImageFragment newInstance(Media asd) {
        ImageFragment fragmentFirst = new ImageFragment();

        Bundle args = new Bundle();
        args.putParcelable("image", asd);
        fragmentFirst.setArguments(args);

        return fragmentFirst;
    }

    //public void setOnTouchListener(View.OnTouchListener l){onTouchListener = l;}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        img = getArguments().getParcelable("image");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Need to call clean-up

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getContext());
        PhotoView photoView = new PhotoView(getContext());
        final SubsamplingScaleImageView imageView = new SubsamplingScaleImageView(getContext());

        Log.i(ImageFragment.class.getSimpleName(), "onCreateView: img size #1 -- " + img.getSize());

        photoView.setColorFilter(Figleaf.NEGATIVE); // HP: "DECRYPTION" mechanism is called here! | negates inverted image, making it positive
        byte[] imgByteArray = getJPEGByteArray(img.getPath(), img.getPath(), getContext().getString(R.string.passphrase), Figleaf.DECRYPT, 64);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgByteArray , 0, imgByteArray.length);
        photoView.setImageBitmap(bitmap);
        // String toString = Arrays.toString();
        // Log.i(ImageFragment.class.getSimpleName(), "onCreateView: " + toString);
        // Bitmap bitmap = BitmapFactory.decodeByteArray(imgByteArray , 0, imgByteArray.length);
        // Log.i(ImageFragment.class.getSimpleName(), "onCreateView: bitmap size #2 -- " + bitmap.getByteCount());
        // photoView.setImageBitmap(bitmap);
        // Drawable d = new BitmapDrawable(getResources(), bitmap);
        // photoView.setImageDrawable(d);

        if (SP.getBoolean("set_delay_full_image", true) && img.isMediaInStorage()) {
            Ion.with(getContext())
                    .load(img.getPath())
                    .withBitmap()
                    .deepZoom()
                    .intoImageView(photoView);

            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    ((PhotoPagerActivity) getActivity()).toggleSystemUI();
                }
                @Override
                public void onOutsidePhotoTap() {
                    ((PhotoPagerActivity) getActivity()).toggleSystemUI();
                }
            });
            photoView.setZoomTransitionDuration(375);
            photoView.setScaleLevels(1.0F, 4.5F, 10.0F); // TODO: improve

            /*Ion.with(getContext())
                .load(img.getPath())
                .withBitmap()
                .deepZoom()
                .intoImageView(photoView);*/

            return photoView;

        } else {

            imageView.setImage(ImageSource.uri(img.getUri()).tilingEnabled());
            imageView.setOrientation(SubsamplingScaleImageView.ORIENTATION_USE_EXIF);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((PhotoPagerActivity) getActivity()).toggleSystemUI();
                }
            });
            return imageView;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        //StringUtils.showToast(getContext(),"resume");
    }

   /* private void rotateLoop() { //april fools
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                photoView.setRotationBy(1);
                rotateLoop();
            }
        }, 5);
    }*/

    public void rotatePicture(int rotation) {
        View view = getView();
        if (view.getClass().equals(SubsamplingScaleImageView.class)) {
            int orienatation = Measure.rotateBy(img.getOrientation(), rotation);
            if (img.setOrientation(orienatation))
                ((SubsamplingScaleImageView) view).setOrientation(orienatation);
        } else {
            int orienatation = Measure.rotateBy(img.getOrientation(), rotation);
            //((ImageView) view).setRotation(orienatation);
            ((PhotoView) view).setRotationBy(rotation);
            if (orienatation == 0)
                ((PhotoView) view).setMinimumScale(1.0F);
            else
                ((PhotoView) view).setMinimumScale(0.65F);
            //photoView.setRotationBy(rotation);
            //photoView.refreshDrawableState();
            //photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    static {
        System.loadLibrary("figleaf");
    }
    public native byte[] getJPEGByteArray(String inputFilename, String outputFilename, String passphrase, int mode, int blockSize);
}