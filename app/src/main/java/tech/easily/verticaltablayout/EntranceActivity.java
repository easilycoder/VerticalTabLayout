package tech.easily.verticaltablayout;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

/**
 * Created by lemon on 07/01/2018.
 */

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_entrance);
        findViewById(R.id.btn_recycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EntranceActivity.this,MainActivity.class);
                intent.putExtra("KEY","recycler");
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EntranceActivity.this,MainActivity.class);
                intent.putExtra("KEY","simple");
                startActivity(intent);
            }
        });
    }
}
