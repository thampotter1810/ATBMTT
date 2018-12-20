package com.example.thampotter.atbmtt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AfineActicity extends AppCompatActivity {

    int A[] = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25
    };
    char B[] = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    EditText edA, edB, edma;
    Button btnMa, btnGiai;
    TextView tvkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afine_acticity);

        anhXa();
        onClick();
    }

    private void onClick() {
        btnMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edA.getText().toString());
                int b = Integer.parseInt(edB.getText().toString());

                String kt = edma.getText().toString().toUpperCase();

                //String abc = kt.toLowerCase();
                char[] C = kt.toCharArray();

                String rs ="";
                for (int i = 0; i < C.length; i++){

                    int temp = viTriKt(B, C[i]);
                    Log.d("MANGGGGGG",C[0]+"");
                    Log.d("KTTTTTT",temp+"");
                    int x = A[temp];

                    // Log.e("AAAAA",x+"");

                    int KQ = ((a * x) + b) % 26;

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
                int a = Integer.parseInt(edA.getText().toString());
                int b = Integer.parseInt(edB.getText().toString());

                String kt = edma.getText().toString().toUpperCase();

                //String abc = kt.toLowerCase();
                char[] C = kt.toCharArray();

                String rs ="";
                for (int i = 0; i < C.length; i++){

                    int temp = viTriKt(B, C[i]);
                    Log.d("MANGGGGGG",C[0]+"");
                    Log.d("KTTTTTT",temp+"");
                    int x = A[temp];

                    // Log.e("AAAAA",x+"");
                    int KQ = 0;
                    int tam = 0;
                    if (a == 1 && x - b > 0){
                        KQ = (x - b) % 26;
                    }else if (a == 3  && x - b > 0){
                        KQ = 9 * (x - b) % 26;
                    }else if (a == 5  && x - b > 0){
                        KQ = 21 * (x - b) % 26;
                    }else if (a == 7 && x - b > 0){
                        KQ = 15 * (x - b) % 26;
                    }else if (a == 11 && x - b > 0){
                        KQ = 19 * (x - b) % 26;
                    }else if (a == 17 && x - b > 0){
                        KQ = 23 * (x - b) % 26;
                    }else if (a == 25 && x - b > 0){
                        KQ = 25 * (x - b) % 26;
                    }else if (a == 1 && x - b < 0){
                        tam = 26 + (x - b);
                        while (tam < 0){
                            KQ = tam % 26;

                        }
                        tam = 26 + tam;

                    }else if (a == 3 && x - b < 0){
                        tam =  26 + (9 * (x - b));
                        while (tam < 0){
                            tam = 26 + tam;

                        }
                        KQ = tam;
                    }else if (a == 5 && x - b < 0){
                        tam = 26 + (21 * (x - b));
                        while (tam < 0){
                            tam = 26 + tam;

                            Log.e("TAMMMMMMM",tam+"");
                        }
                        KQ = tam;
                    }else if (a == 7 && x - b < 0){
                        tam = 26 + (15 * (x - b));
                        Log.d("BIEN TAM",tam+"");
                        while (tam < 0){

                            tam = 26 + tam;

                            Log.e("TAMMMMMMM",tam+"");
                        }
                        KQ = tam;
                    }else if (a == 11 && x - b < 0){
                        tam = 26 + (19 * (x - b));
                        while (tam < 0){
                            tam = 26 + tam;

                            Log.e("TAMMMMMMM",tam+"");
                        }
                        KQ = tam;

                    }else if (a == 17 && x - b < 0){

                        tam = 26 + (23 * (x - b));
                        while (tam < 0){
                            tam = 26 + tam;

                            Log.e("TAMMMMMMM",tam+"");
                        }
                        KQ = tam;
                    }else{
                        tam = 26 + (25 * (x - b));
                        while (tam < 0){
                            tam = 26 + tam;

                            Log.e("TAMMMMMMM",tam+"");
                        }
                        KQ = tam;
                    }
                    Log.e("KQQQQQQQQQQQQQ",KQ+"");
                    int vt = viTriSo(A, KQ);
                    Log.e("BBBBBB",vt+"");
                    rs = rs + B[vt];

                }
                tvkq.setText(rs);
            }
        });
    }

    private void anhXa() {
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edma = findViewById(R.id.edchuoi);
        btnGiai = findViewById(R.id.btngiai);
        btnMa = findViewById(R.id.btnma);
        tvkq = findViewById(R.id.tvkqAff);
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
