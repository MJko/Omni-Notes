package it.feio.android.omninotes;

import it.feio.android.omninotes.utils.Constants;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class PasswordActivity extends BaseActivity {

	private EditText passwordCheck;
	private EditText password;
	private Button confirm;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password);
	}



	private void initViews() {
		password = (EditText)findViewById(R.id.password);
		passwordCheck = (EditText)findViewById(R.id.password_check);
		confirm = (Button)findViewById(R.id.password_confirm);
		confirm.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (!password.getText().toString().equals(passwordCheck.getText().toString())){
					showToast(getString(R.string.settings_password_not_matching), Toast.LENGTH_SHORT);
				} else {
					prefs.edit().putString(Constants.PREF_PASSWORD, password.getText().toString());
					onBackPressed();
				}
			}
		});
	}

}