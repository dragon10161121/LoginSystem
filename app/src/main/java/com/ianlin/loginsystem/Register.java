package com.ianlin.loginsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {


    SQLiteDataAdapter dataBaseHelper;
    Button register_button;
    EditText enter_username, enter_password, enter_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dataBaseHelper = new SQLiteDataAdapter(Register.this);
        enter_name = (EditText) findViewById(R.id.enter_name);
        enter_username = (EditText) findViewById(R.id.register_username);
        enter_password = (EditText) findViewById(R.id.register_password);
        register_button = (Button) findViewById(R.id.button_registered);


         /*
        for this it checks whether the data is already there, if not it lets the user sign up otherwise it prompts with please sign in message.
         */
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enter_name.getText().toString();
                String userName = enter_username.getText().toString();
                String password = enter_password.getText().toString();
                String userNameAndPassword = dataBaseHelper.validateEnteredInfoWhileSignUp(userName, password, name);
                //if not empty, means match with already entered data base values
                if (!(userNameAndPassword.isEmpty())) {
                    LogMessage.logInfo(Register.this, "You have already Signup, please login");

                    // if user didnt enter anything
                } else if (userName.isEmpty() || password.isEmpty()) {
                    LogMessage.logInfo(Register.this, "please enter the complete information");
                } else if (userNameAndPassword.isEmpty()) {

                    long id = dataBaseHelper.insertLoginData(userName, password, name);
                    // check id is less than one, not inserted
                    if (id < 0) {
                        LogMessage.logInfo(Register.this, "Unsuccessful insertion of a row");

                    } else {
                        LogMessage.logInfo(Register.this, "Successful insertion of a row");

                    }

                }
                Intent intentLogin = new Intent(Register.this, MainActivity.class);
                startActivity(intentLogin);
                finish();
            }

        });

    }
}
