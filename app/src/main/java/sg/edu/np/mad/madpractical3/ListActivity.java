package sg.edu.np.mad.madpractical3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View closeButton = findViewById(R.id.imageView);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int random = new Random().nextInt(999999);
        String profilename = "MAD " + random;

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                builder.setMessage("MADness")
                        .setTitle("Profile")
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                intent.putExtra("profilename", profilename);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Close", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}