package com.example.thampotter.atbmtt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VigenereActivity extends AppCompatActivity {

    int A[] = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25
    };
    char B[] = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    EditText edkvi, edmavi;
    TextView tvk, tvkqvi;
    Button btnmavi, btngiaivi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere);

        anhXa();
        onClick();

    }

    private void onClick() {
        btnmavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoik = edkvi.getText().toString().toUpperCase();
                char chuoikhoak[] = chuoik.toCharArray();
                int k[] = new int[100];
                String kt ="";
                for (int i = 0; i < chuoikhoak.length; i++){
                    int vt = viTriKt(B,chuoikhoak[i]);
                    k[i] = viTriSo(A,vt);
                    kt = kt + k[i]+",";
                }

                tvk.setText(kt);

                String chuoidich = edmavi.getText().toString().toUpperCase();
                char mangdich[] = chuoidich.toCharArray();
                int mangso[] = new int[mangdich.length];

                for (int i = 0; i < mangdich.length; i++){
                    int vt = viTriKt(B,mangdich[i]);
                    mangso[i]= viTriSo(A,vt);

                    //Toast.makeText(getApplicationContext(),mangso[i]+" ",Toast.LENGTH_SHORT).show();
                }
                String rs ="";
                int Kq = 0;
                int ketthucso = 0;
                int ketthuck = 0;
                while (ketthucso < mangso.length){
                    Kq = mangso[ketthucso] + k[ketthuck];

                    Log.e("MANGSO",mangso[ketthucso]+"");
                    Log.e("MANGK",k[ketthuck]+"");
                    Log.e("KQQQQQQQQQQq",Kq+"");
                    ketthucso++;
                    ketthuck++;
                    if (Kq > 26){
                        Kq = Kq % 26;
                    }
                    int a = viTriSo(A,Kq);
                    Log.e("AAAAAAAAAAA",a+"");

                    rs = rs + B[a];
                    if (ketthuck > k.length){
                        ketthuck = 0;
                    }
                }
                tvkqvi.setText(rs);

            }
        });

        btngiaivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoik = edkvi.getText().toString().toUpperCase();
                char chuoikhoak[] = chuoik.toCharArray();
                int k[] = new int[100];
                String kt ="";
                for (int i = 0; i < chuoikhoak.length; i++){
                    int vt = viTriKt(B,chuoikhoak[i]);
                    k[i] = viTriSo(A,vt);
                    kt = kt + k[i]+",";
                }

                tvk.setText(kt);

                String chuoidich = edmavi.getText().toString().toUpperCase();
                char mangdich[] = chuoidich.toCharArray();
                int mangso[] = new int[mangdich.length];

                for (int i = 0; i < mangdich.length; i++){
                    int vt = viTriKt(B,mangdich[i]);
                    mangso[i]= viTriSo(A,vt);

                    //Toast.makeText(getApplicationContext(),mangso[i]+" ",Toast.LENGTH_SHORT).show();
                }
                String rs ="";
                int Kq = 0;
                int ketthucso = 0;
                int ketthuck = 0;
                while (ketthucso < mangso.length){
                    Kq = mangso[ketthucso] - k[ketthuck];

                    Log.e("MANGSO",mangso[ketthucso]+"");
                    Log.e("MANGK",k[ketthuck]+"");
                    Log.e("KQQQQQQQQQQq",Kq+"");
                    ketthucso++;
                    ketthuck++;
                    if (Kq < 0){
                        Kq = 26 + Kq;
                    }
                    int a = viTriSo(A,Kq);
                    Log.e("AAAAAAAAAAA",a+"");

                    rs = rs + B[a];
                    if (ketthuck > k.length){
                        ketthuck = 0;
                    }
                }
                tvkqvi.setText(rs);

            }
        });
    }

    private void anhXa() {
        edkvi = findViewById(R.id.edkvi);
        edmavi = findViewById(R.id.edmavi);
        tvk = findViewById(R.id.tvk);
        tvkqvi = findViewById(R.id.tvkqvi);
        btngiaivi = findViewById(R.id.btngiaivi);
        btnmavi = findViewById(R.id.btnmavi);

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
