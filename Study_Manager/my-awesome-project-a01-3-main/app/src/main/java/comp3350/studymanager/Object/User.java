package comp3350.studymanager.Object;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Parcelable {

    String userName;
    String pwd;

    public User(String userName,String pwd){
        this.userName=userName;
        this.pwd=pwd;
    }

    protected User(Parcel in) {
        userName = in.readString();
        pwd = in.readString();
    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername(){
        return this.userName;
    }



    public String getPassword(){
        return this.pwd;
    }

    public boolean equals(User u)
    {
        return this.userName.equals(u.getUsername()) && this.pwd.equals(u.getPassword());
    }

    public boolean isValidusername(String userName){
        return userName.length() >= 6;
    }

    public boolean isValidpassword(String input)
    {
    boolean flag;
        if(!isPasswordValidMethod(input)){
            System.out.println("Not Valid");
            flag=false;

        }else{

            System.out.println("Valid");
            flag= true;

        }
        return flag;
    }

    private boolean isPasswordValidMethod(String password) {

        boolean flag = false;

        String expression = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}$";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("if");
            flag = true;
        }else{
            System.out.println("else");
        }
        return flag;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(pwd);
    }
}


