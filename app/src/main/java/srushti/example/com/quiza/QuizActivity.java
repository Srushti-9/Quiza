package srushti.example.com.quiza;
//controller
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG ="QuizActivity" ;
    private static final String KEY_INDEX ="index" ;
    private TextView que;
    private Button TrueButton,FalseButton,NextButton;
    int index;
    private Question[] Que=new Question[]
            {
                    new Question(R.string.question,true),
                   new Question(R.string.q1,true),
                    new Question(R.string.q2,false),
                    new Question(R.string.q3,true),
                    new Question(R.string.q4,false)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState != null)
        {
            index=savedInstanceState.getInt(KEY_INDEX);//index=name of bundle object
        }

        Log.d(TAG,"OnCreate called");

        que=(TextView)findViewById(R.id.question);
        TrueButton=(Button)findViewById(R.id.T_button);
        FalseButton=(Button)findViewById(R.id.F_button);
        NextButton=(Button)findViewById(R.id.N_button);
        que.setText(Que[index].getTextResID());

        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(true);//checking the condition to go to next question
                //Toast.makeText(QuizActivity.this, "Answer is correct", Toast.LENGTH_SHORT).show();
            }
        });
        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(false);
                //Toast.makeText(QuizActivity.this, "Answer is wrong", Toast.LENGTH_SHORT).show();
            }
        });

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=(index+1) % Que.length;
                que.setText(Que[index].getTextResID());
                /*if(index<Que.length)
                {
                index++;
                }
                else
                {
                index=0;
                }
                 */
            }
        });

    }

    private void checkanswer(boolean b)
    {
        if(b==Que[index].isAnsTrue())
        {
            Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX,index);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"OnStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy called");
    }

}
