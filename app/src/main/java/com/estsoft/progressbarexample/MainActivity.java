package com.estsoft.progressbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBarCircle;
    private ProgressBar progressBarHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS );
        requestWindowFeature(Window.FEATURE_PROGRESS );
        setContentView(R.layout.activity_main);

        setProgressBarIndeterminateVisibility( true );
        setProgressBarVisibility( true );

        progressBarCircle = (ProgressBar)findViewById( R.id.progressCircle );
        progressBarCircle.setProgress( 0 );

        progressBarHorizontal = (ProgressBar)findViewById( R.id.progressHorizontal );
        progressBarHorizontal.setProgress( 0 );
        progressBarHorizontal.setSecondaryProgress(0);
    }
    // 코드 짤 때는 setOnClickListener를 사용을 지향!
    public void onButtonClick( View view ) {
        switch(view.getId()) {
            case R.id.buttonToggleProgressCircle : {
                boolean isChecked = ((ToggleButton)view).isChecked();
                progressBarCircle.setVisibility(isChecked ? View.INVISIBLE : View.VISIBLE);
                break;
            }
            case R.id.buttonProgressBarPrimaryIncrease : {
                progressBarHorizontal.incrementProgressBy(10);
                break;
            }
            case R.id.buttonProgressBarPrimaryDecrease : {
                progressBarHorizontal.incrementProgressBy(-10); // 감소도 같은 increment로 하고 마이너스로 쓴다
                break;
            }
            case R.id.buttonProgressBarSecondaryIncrease : {
                progressBarHorizontal.incrementSecondaryProgressBy(10);
                break;
            }
            case R.id.buttonProgressBarSecondaryDecrease : {
                progressBarHorizontal.incrementSecondaryProgressBy(-10);
                break;
            }
            default :
                break;
        }
    }
}
