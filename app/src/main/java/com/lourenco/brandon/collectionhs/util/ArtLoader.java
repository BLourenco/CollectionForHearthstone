package com.lourenco.brandon.collectionhs.util;

//http://android-developers.blogspot.ca/2010/07/multithreading-for-performance.html

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.lourenco.brandon.collectionhs.R;
import com.meg7.widget.SvgImageView;

import java.lang.ref.WeakReference;

public class ArtLoader {

    private Context context;

    public ArtLoader(Context context)
    {
        this.context = context;
    }

    public void loadCardArt(String resourceId, Enums.CardType type, SvgImageView imageView)
    {
        ArtLoaderTask task = new ArtLoaderTask(type, imageView);
        task.execute(resourceId);
    }

    class ArtLoaderTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<SvgImageView> imageViewReference;
        private final Enums.CardType type;

        public ArtLoaderTask(Enums.CardType type, SvgImageView imageView) {
            imageViewReference = new WeakReference<>(imageView);
            this.type = type;
        }

        @Override
        // Actual download method, run in the task thread
        protected Bitmap doInBackground(String... params) {
            // params comes from the execute() call: params[0] is the url.
            Resources resources = context.getResources();

            if (params[0].endsWith("e") ||
                    params[0].endsWith("b") ||
                    params[0].endsWith("o") ||
                    params[0].endsWith("h"))
            {
                params[0] = params[0].substring(0, params[0].length()-1);
            }
            else if (params[0].endsWith("eh") ||
                    params[0].endsWith("e2"))
            {
                params[0] = params[0].substring(0, params[0].length()-2);
            }

            int resourceId = resources.getIdentifier(params[0].toLowerCase(), "drawable",
                    context.getPackageName());

            if (resourceId == 0)
            {
                resourceId = R.drawable.missing;
            }

            return BitmapFactory.decodeResource(context.getResources(), resourceId);
        }

        @Override
        // Once the image is downloaded, associates it to the imageView
        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }

            if (imageViewReference != null) {//TODO Fix issue where all images that are loaded are inserted into the image views currently present
                SvgImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}

