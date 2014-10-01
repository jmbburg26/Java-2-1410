import android.os.Bundle;

/**
 * Created by John on 9/28/2014.
 */
public class Contact {

    //Constants
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USER_EMAIL= "userEmail";
    public static final String USER_IMAGE = "userPicture";

    //Private
    private String firstName;
    private String lastName;
    private String userEmail;
    private int userPicture;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(int userPicture) {
        this.userPicture = userPicture;
    }

    //	Used when creating the data object
    public Contact(String id, int imageResource, String lastname, String useremail) {
        this.firstName = id;
        this.userPicture = imageResource;
        this.lastName = lastname;
        this.userEmail = useremail;
    }

    //	Create from a bundle
    public Contact(Bundle b) {
        if (b != null) {
            this.firstName = b.getString(FIRST_NAME);
            this.userPicture = b.getInt(USER_IMAGE);
            this.lastName = b.getString(LAST_NAME);
            this.userEmail = b.getString(USER_EMAIL);
        }
    }

    //	Package data for transfer between activities
    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(FIRST_NAME, this.firstName);
        b.putInt(USER_IMAGE, this.userPicture);
        b.putString(LAST_NAME, this.lastName);
        b.putString(USER_EMAIL, this.userEmail);
        return b;
    }

    //	Output flower data
    @Override
    public String toString() {
        return firstName;
    }
}
