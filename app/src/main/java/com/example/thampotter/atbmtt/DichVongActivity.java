package com.example.thampotter.atbmtt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DichVongActivity extends AppCompatActivity {

    EditText edK, edKt;
    Button btnMa, btnGiai;
    TextView tvkq;

    int A[] = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25
    };
    char B[] = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vong);

        anhXa();
        onClick();
        //Toast.makeText(getApplicationContext(),A[]+"",Toast.LENGTH_SHORT).show();
    }

    private void onClick() {
        btnMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k = Integer.parseInt(edK.getText().toString());
                String kt = edKt.getText().toString().toUpperCase();
                //String abc = kt.toLowerCase();
                char[] C = kt.toCharArray();
                String rs ="";
                for (int i = 0; i < C.length; i++){
                    int temp = viTriKt(B, C[i]);
                    Log.d("MANGGGGGG",C[0]+"");
                    Log.d("KTTTTTT",temp+"");
                    int x = A[temp];

                    // Log.e("AAAAA",x+"");

                    int KQ = (x + k) % 26;

                    int vt = viTriSo(A, KQ);
                    //Log.e("BBBBBB",vt+"");
                     rs = rs + B[vt];

                }
                tvkq.setText(rs);

            }
        });

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k = Integer.parseInt(edK.getText().toString());
                String kt = edKt.getText().toString().toUpperCase();
                //String abc = kt.toLowerCase();
                char[] C = kt.toCharArray();
                String rs ="";
                for (int i = 0; i < C.length; i++){
                    int temp = viTriKt(B, C[i]);
                    Log.d("MANGGGGGG",C[0]+"");
                    Log.d("KTTTTTT",temp+"");
                    int x = A[temp];

                    // Log.e("AAAAA",x+"");
                    int KQ;
                    if (x - k < 0){
                        KQ = 26 + (x - k);
                    }else{
                        KQ = (x - k) % 26;
                    }

                    int vt = viTriSo(A, KQ);
                    Log.e("BBBBBB",KQ+"");
                    rs = rs + B[vt];

                }
                tvkq.setText(rs);
            }
        });
    }

    private void anhXa() {
        edK = findViewById(R.id.edK);
        edKt = findViewById(R.id.edkt);
        btnGiai = findViewById(R.id.btngiaima);
        btnMa = findViewById(R.id.btnmahoa);
        tvkq = findViewById(R.id.tvkq);
    }

    int viTriKt(char a[], char x) {

        int i;
        int vt = 0;
        for (i = 0; i < 26; i++) {

            if (a[i] == x) {

                vt = i;
                break;
            }

        }
        return vt;
    }

    int viTriSo(int a[], int x) {

        int i;
        int vt = 0;
        for (i = 0; i < 26; i++) {

            if (a[i] == x) {
                vt = i;
                break;
            }

        }
        return vt;
    }

}
