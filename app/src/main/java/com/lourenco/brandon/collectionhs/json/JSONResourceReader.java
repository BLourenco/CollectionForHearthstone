package com.lourenco.brandon.collectionhs.json;

import java.io.*;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * An object for reading from a JSON resource file and constructing an object from that resource file using Gson.
 *
 * Found at: http://stackoverflow.com/questions/6349759/using-json-file-in-android-app-resources
 */
public class JSONResourceReader {

    private static final String LOGTAG = JSONResourceReader.class.getSimpleName();
    private Resources resources;

    public JSONResourceReader(Resources resources)
    {
        this.resources = resources;
    }

    public String getStringFromJSON(int rawJsonResourceId) {
        InputStream resourceReader = resources.openRawResource(rawJsonResourceId);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(LOGTAG, "Unhandled exception while using JSONResourceReader", e);
            }
        }

        return writer.toString();
    }
}
