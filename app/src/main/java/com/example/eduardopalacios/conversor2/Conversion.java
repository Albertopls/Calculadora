package com.example.eduardopalacios.conversor2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by eduardopalacios on 15/02/18.
 */

public class Conversion {

    StringBuilder sb=new StringBuilder();
    int decimal;


    public void setBinario(String dec)
    {

        decimal=Integer.parseInt(dec);

        while (decimal>0){

            if(decimal%2==0)
            {
                sb.append("0");
            }
            else {
                sb.append("1");
            }

            decimal=decimal/2;
        }



    }

    public void setHexadecimal(String dec)
    {

        decimal=Integer.parseInt(dec);
        int producto=0;
        int resultado=0;
        int sobrante;
        int almacenarProducto=0;
        int valorAcomulable=0;


   do {


            while (resultado<=decimal)
            {
                almacenarProducto=producto;
                valorAcomulable=resultado;
                resultado=producto*16;

                producto++;
            }

            sobrante=decimal-valorAcomulable;
            evaluarCaracterHexadecimal(sobrante);

            almacenarProducto--;
            decimal=almacenarProducto;
            valorAcomulable=0;
            resultado=0;
            producto=0;

   }while (decimal>0);


    }

    public void setOctal(String dec)
    {
        int resultadoEntero;
        int resultadoOctal;
        Double reultadoDecimal;
        Double resto;

        decimal=Integer.parseInt(dec);

        while (decimal>=8)
        {
            resultadoEntero=decimal/8;
            reultadoDecimal=Double.parseDouble(String.valueOf(decimal))/8;
            resto=reultadoDecimal-resultadoEntero;

            resultadoOctal= (int) (resto*8);
            sb.append(resultadoOctal);
            decimal=resultadoEntero;

        }


        sb.append(decimal);


    }


    public String getBinario(){
        return sb.reverse().toString();
    }


    public String getHexadecimal()
    {
        return sb.reverse().toString();
    }


    public String getOctal()
    {
        return sb.reverse().toString();
    }

    public void evaluarCaracterHexadecimal(int numero)
    {
        //ITERANDO

        int num[]={10,11,12,13,14,15};
        String letras[]={"A","B","C","D","E","F"};

        for (int i=0;i<num.length;i++)
        {
            if(numero==num[i])
            {
                sb.append(letras[i]);
                return;
            }
        }
        //CON CONDICIONALES
       // if (numero==10)
        //{
          //  sb.append("A");
            //return;
        //}
        //if (numero==11)
        //{
          //  sb.append("B");
            //return;
        //}
        //if (numero==12)
        //{
          //  sb.append("C");
            //return;
        //}
        //if (numero==13)
        //{
          //  sb.append("D");
            //return;
        //}
        //if (numero==14)
        //{
          //  sb.append("E");
            //return;
        //}
        //if (numero==15)
        //{
          //  sb.append("F");
            //return;
        //}

        sb.append(String.valueOf(numero));
    }
}
