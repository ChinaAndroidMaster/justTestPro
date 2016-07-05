package com.ckx.checkcar.mvp.activity.welcome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.ckx.checkcar.R;
import com.github.paolorotolo.appintro.AppIntro2;

public final class WelcomeActivity extends AppIntro2
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro2_2));
        addSlide(SampleSlide.newInstance(R.layout.intro3_2));
    }

    private void loadMainActivity()
    {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment)
    {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed(Fragment currentFragment)
    {
        super.onDonePressed(currentFragment);

        loadMainActivity();
    }

    public void getStarted(View v){
        loadMainActivity();
    }
}
