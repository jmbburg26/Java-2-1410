package com.bbgatestudios.apitest.data;

import android.os.Bundle;


/**
 * Created by John on 9/17/2014.
 */
public class Headline {


    //Constants
    public static final String STORY_TITLE = "storyTitle";
    public static final String STORY_DESCRIPTION = "storyDescription";
    public static final String STORY_PUBLISHED = "storyPublished";
    public static final String STORY_IMAGE = "storyImage";

    //Private
    private String storyTitle;
    private String storyDescription;
    private String storyPublished;
    private int storyImage;

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryDescription() {
        return storyDescription;
    }

    public void setStoryDescription(String storyDescription) {
        this.storyDescription = storyDescription;
    }

    public String getStoryPublished() {
        return storyPublished;
    }

    public void setStoryPublished(String storyPublished) {
        this.storyPublished = storyPublished;
    }

    public int getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(int storyImage) {
        this.storyImage = storyImage;
    }

    //	Used when creating the data object
    public Headline(String id, int imageResource, String lastname, String useremail) {
        this.storyTitle = id;
        this.storyImage = imageResource;
        this.storyDescription = lastname;
        this.storyPublished = useremail;
    }

    //	Create from a bundle
    public Headline(Bundle b) {
        if (b != null) {
            this.storyTitle = b.getString(STORY_TITLE);
            this.storyImage = b.getInt(STORY_IMAGE);
            this.storyDescription = b.getString(STORY_DESCRIPTION);
            this.storyPublished = b.getString(STORY_PUBLISHED);
        }
    }

    //	Package data for transfer between activities
    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(STORY_TITLE, this.storyTitle);
        b.putInt(STORY_IMAGE, this.storyImage);
        b.putString(STORY_DESCRIPTION, this.storyDescription);
        b.putString(STORY_PUBLISHED, this.storyPublished);
        return b;
    }

    //	Output flower data
    @Override
    public String toString() {
        return storyTitle;
    }


}
