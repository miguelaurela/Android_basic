package com.example.parcial1miguelaurela;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller1miguelaurela.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    Button login;
    Button BtnNumber;
    EditText edtNumber;
    TextView txtNumbers;
    RadioGroup radioGroup;
    Button btnCalcular;
    RadioButton bt1,bt2,bt3,bt4;
    Button btnBorrar;
    TextView txtresult;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //usuario=findViewById(R.id.edtUser);
        //login =findViewById(R.id.btnlogin);
        BtnNumber=findViewById(R.id.btnGuardarNumero);
        edtNumber=findViewById(R.id.edtNumber);
        txtNumbers=findViewById(R.id.txtNumber);
          List<String> ListNumeros = new ArrayList<>();
         String num;
         radioGroup = findViewById(R.id.radiogruop);
         btnCalcular =findViewById(R.id.btnCalcular);
         bt1=findViewById(R.id.rbMayorValor);
        bt2=findViewById(R.id.rbMenorValor);
        bt3=findViewById(R.id.rbOdernarVector);
        bt4=findViewById(R.id.rbPromedio);
        btnBorrar=findViewById(R.id.btnBorrarVector);
        txtresult=findViewById(R.id.txtresult);
       // findViewById(R.id.rbMayorValor)
         btnCalcular.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Calcular(ListNumeros);

             }
         });

    btnBorrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            borrarVector(ListNumeros);
            txtNumbers.setText("");
            Toast.makeText(getApplicationContext(),"Vector Borrado",Toast.LENGTH_LONG).show();
        }
    });


        BtnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edtNumber.getText())){
                    añadirValorArray(ListNumeros, edtNumber.getText().toString());
                    Toast.makeText(getApplicationContext(),MostrarArray(ListNumeros),Toast.LENGTH_LONG).show();
                    txtNumbers.setText(MostrarArray(ListNumeros));
                    edtNumber.setText("");
            }else{
                    Toast.makeText(getApplicationContext(),"El campo numero está vacío ",Toast.LENGTH_LONG).show();

                }
            }

        });


    }
    private void Calcular(List<String> ListNumeros){
        String num,num2,num3,num4;
        if (!ListNumeros.isEmpty()) {
            if (bt1.isChecked()) {
                //Toast.makeText(getApplicationContext(), "Boton 1", Toast.LENGTH_LONG).show();
                num =NumeroMayor(ListNumeros);
                Toast.makeText(getApplicationContext(), num, Toast.LENGTH_LONG).show();
                txtresult.setText(num);
            } else if (bt2.isChecked()) {
                num2=NumeroMenor(ListNumeros);
                Toast.makeText(getApplicationContext(), num2, Toast.LENGTH_LONG).show();
                txtresult.setText(num2);
            } else if (bt3.isChecked()) {
                num3=OrdenarArray(ListNumeros);
                Toast.makeText(getApplicationContext(), num3, Toast.LENGTH_LONG).show();
                txtresult.setText(num3);
            } else if (bt4.isChecked()) {
                num4=PromedioArray(ListNumeros);
                Toast.makeText(getApplicationContext(), "boton 4", Toast.LENGTH_LONG).show();
                txtresult.setText(num4);
            }else{
                Toast.makeText(getApplicationContext(), "Debe seleccionar una de las opciones de la izquierda", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "No hay datos", Toast.LENGTH_LONG).show();

        }
    }

    private String PromedioArray(List<String> listNumeros) {
        long suma =0;
        int cont=0;
        for (int i=0; i<listNumeros.size() ;i++) {
            long finalValue=Integer.parseInt(listNumeros.get(i));
            suma+=finalValue;
            cont+=1;
        }
        return String.valueOf(suma/cont);
    }


    private  String NumeroMayor(List<String> listNumeros){
       long iNumeroMayor=0;
        for (int i=0; i<listNumeros.size() ;i++) {
            long finalValue=Long.parseLong(listNumeros.get(i));
            if (finalValue>iNumeroMayor) {
                iNumeroMayor = finalValue;
            }
        }
        return String.valueOf(iNumeroMayor);
    }
    private  String NumeroMenor(List<String> listNumeros){
        long iNumeroMenor=999999999;
        for (int i=0; i<listNumeros.size() ;i++) {
            long finalValue=Long.parseLong(listNumeros.get(i));
            if (finalValue<iNumeroMenor) {
                iNumeroMenor = finalValue;
            }
        }
        return String.valueOf(iNumeroMenor);
    }
    private  String OrdenarArray(List<String> listNumeros){
        ArrayList<Long> Listnum=new ArrayList<>();
        for (int i=0; i<listNumeros.size() ;i++) {
            long finalValue=Long.parseLong(listNumeros.get(i));
                Listnum.add(finalValue);
        }

        Collections.sort(Listnum);
        return String.valueOf(Listnum);
    }

    private void borrarVector(List<String> ListNumeros){
        ListNumeros.clear();
    }
    private  void añadirValorArray(List<String> ListNumeros, String num){
        ListNumeros.add(num);
    }
    private  String MostrarArray(List<String> ListNumeros){
        return ListNumeros.toString();
    }
}