package com.example.eduardopalacios.conversor2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button  botones[]=new Button[10];
    Button Bin,Oct,Hex,Ce;
    String resultadoConversion="";
    Boolean hexadecimal=false;
    Boolean octal=false;
    Boolean binario=false;

    TextView dispaly;

    int idBotoenes[]={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,};
    StringBuilder sb=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dispaly=(TextView) findViewById(R.id.display);
        Bin=(Button)findViewById(R.id.bin);
        Oct=(Button)findViewById(R.id.oct);
        Hex=(Button)findViewById(R.id.hex);
        Ce=(Button)findViewById(R.id.btnce);

        Bin.setOnClickListener(this);
        Oct.setOnClickListener(this);
        Hex.setOnClickListener(this);
        Ce.setOnClickListener(this);


        for (int i=0;i<10;i++)
        {
            botones[i]=(Button)findViewById(idBotoenes[i]);

            final int finalI = i;
            botones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    //Toast.makeText(getApplicationContext(),botones[finalI].getText().toString(),Toast.LENGTH_SHORT).show();

                    sb.append(botones[finalI].getText().toString());
                    dispaly.setText(sb);
                }
            });

        }

    }

    @Override
    public void onClick(View view) {
         switch (view.getId())
         {
             case R.id.bin:

                 //Creando objeto de la clase Conversion
                 Conversion conversionBinario=new Conversion();

                 // colocando el valor del display al metodo que se encargara de realizar la conversion
                 conversionBinario.setBinario(dispaly.getText().toString());

                 //metodo que devuelve el resultado de la conversion
                 resultadoConversion= conversionBinario.getBinario();

                 //Se muestra el resultado en el display
                 dispaly.setText(resultadoConversion);

                 //se vacia el stringbuilder para volver a colocar valores en el display
                 sb.delete(0,sb.length());

                 binario=true;
                 break;

             case R.id.oct:
             {
                 //Creando objeto de la clase Conversion
                 Conversion conversionOctal=new Conversion();

                 // colocando el valor del display al metodo que se encargara de realizar la conversion
                 conversionOctal.setOctal(dispaly.getText().toString());

                 //metodo que devuelve el resultado de la conversion
                 resultadoConversion=conversionOctal.getOctal();

                 //Se muestra el resultado en el display
                 dispaly.setText(resultadoConversion);

                 //se vacia el stringbuilder para volver a colocar valores en el display
                 sb.delete(0,sb.length());
                 octal=true;
                 break;
             }

             case R.id.hex:


                 //Creando objeto de la clase Conversion
                 Conversion conversionHex=new Conversion();

                 // colocando el valor del display al metodo que se encargara de realizar la conversion
                 conversionHex.setHexadecimal(dispaly.getText().toString());

                 //metodo que devuelve el resultado de la conversion
                 resultadoConversion=conversionHex.getHexadecimal();

                 //Se muestra el resultado en el display
                 dispaly.setText(resultadoConversion);

                 //se vacia el stringbuilder para volver a colocar valores en el display
                 sb.delete(0,sb.length());

                 hexadecimal=true;

                 break;

             case R.id.btnce:

                 //Eliminamos valores del display para realizar una nueva conversion si es que anteriormente la conversion fue hexadecimal

                 if(hexadecimal)
                 {

                     resultadoConversion="";
                     dispaly.setText(resultadoConversion);
                     hexadecimal=false;
                     return;
                 }

                 //Eliminamos valores del display para realizar una nueva conversion si es que anteriormente la conversion fue octal
                 if (octal)
                 {
                     resultadoConversion="";
                     dispaly.setText(resultadoConversion);
                     octal=false;
                     return;
                 }

                 //Eliminamos valores del display para realizar una nueva conversion si es que anteriormente la conversion fue binario
                 if (binario)
                 {
                     resultadoConversion="";
                     dispaly.setText(resultadoConversion);
                     binario=false;
                     return;
                 }

                     int tamaño=sb.length()-1;
                     sb.deleteCharAt(tamaño);
                     dispaly.setText(sb);

                 break;
                 default:

                     break;
         }
    }
}
