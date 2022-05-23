package comp3350.studymanager.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.studymanager.Object.User;
import comp3350.studymanager.Persistence.userPersistence;
import comp3350.studymanager.R;
import comp3350.studymanager.logic.AccessServices;
import comp3350.studymanager.logic.Main;


public class signInPage extends AppCompatActivity {

    private static boolean initial = false;
    EditText getUserName;
    private EditText getPass;
    private User newUser;
    private userPersistence check1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();

        getSupportActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in_page);


        getUserName = findViewById(R.id.input_userName);
        getPass = findViewById(R.id.input_Password);
        Button signButton = findViewById(R.id.signBtn);
        Button registerButton = findViewById(R.id.registerBtn);
        check1 = AccessServices.getRegisterInterface();

        Intent intent = getIntent();
        intent.getParcelableArrayListExtra("listofUser");


        signButton.setOnClickListener((View v) -> {
            String userSting = getUserName.getText().toString();
            String PasswordString = getPass.getText().toString();
            newUser = new User(userSting, PasswordString);
            boolean flag = check1.searchUser(newUser);

            if (!userSting.isEmpty() && !PasswordString.isEmpty()) {

                if (flag) {
                    Intent newIntent = new Intent(signInPage.this, institutionPage.class);
                    startActivity(newIntent);
                } else {
                    getUserName.setError("User does not exist please register first!");
                }

            } else {

                if (userSting.isEmpty()) {
                    getUserName.setError("Enter some character for user name");
                } else {
                    getPass.setError("Enter some character for password");
                }
            }

        });


        registerButton.setOnClickListener((View v) -> {

            Intent newIntent = new Intent(signInPage.this, registerPage.class);
            startActivity(newIntent);
            finish();
        });


    }


    private void copyDatabaseToDevice() {
        if(initial){
            return;
        }
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

            initial = true;
        } catch (final IOException ioe) {
            //Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
            System.out.println("Unable to access application data:" + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }


}






