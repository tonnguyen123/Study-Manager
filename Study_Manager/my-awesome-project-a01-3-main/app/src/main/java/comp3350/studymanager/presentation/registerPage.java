package comp3350.studymanager.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.studymanager.Object.User;
import comp3350.studymanager.Persistence.userPersistence;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.AccessServices;

public class registerPage extends AppCompatActivity {

    private EditText inputUsername;
    private EditText inputPassword;
    private EditText inputRetypePwd;
    private userPersistence check= null;
    ArrayList<User> listofUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        inputUsername = findViewById(R.id.registerUsername);
        inputPassword = findViewById(R.id.registerPass);
        inputRetypePwd = findViewById(R.id.retypePass);
        check= AccessServices.getRegisterInterface();

        Button registerBtn = findViewById(R.id.registerAccountButton);
        PreferenceManager.getDefaultSharedPreferences(this);

        registerBtn.setOnClickListener((View v) -> {


                    String registerUserName = String.valueOf(inputUsername.getText());
                    String registerPassword = String.valueOf(inputPassword.getText());
                    String registerRePassword = String.valueOf(inputRetypePwd.getText());
                    User newUser=new User(registerUserName,registerPassword);

//                    boolean flag=check.addUser(newUser);
                    User checkuser=check.getUser(newUser);


                if (newUser.isValidusername(registerUserName) && newUser.isValidusername(registerUserName) ){

                        if(newUser.isValidpassword(registerPassword) && registerPassword.equals(registerRePassword) ) {

                            if(checkuser==null) {

                                //listofUser.add(newUser);
                                check.addUser(newUser);
                                toastMessage();

                                Intent newIntent = new Intent(registerPage.this, signInPage.class);
                                newIntent.putParcelableArrayListExtra("listofUser", listofUser);
                                startActivity(newIntent);
                            }
                            else
                            {
                                inputUsername.setError("Please signin, you already have an account!");
                            }
                        }else{
                            inputPassword.setError("Invalid USER NAME or Password ");
                            inputPassword.setError("--Password must contain 4 - 15 character.\n--Password must contains at least one Upper case letter.\n--Password must contains at least one Lower case letter.\n--Password must contains at least one number.");
                        }

                } else {

                        inputUsername.setError("Invalid username");
                        inputUsername.setError("Username  should contain atleast 6 characters");
                }

        });

    }
    private void toastMessage(){
        Toast.makeText(registerPage.this, "Registered Successfully!", Toast.LENGTH_LONG).show();
    }
}
