package com.example.barbershop_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Obtiene la referencia hacia los componentes graficos
    private EditText txtCortes;
    private EditText txtCeja;
    private EditText txtBarba;
    private EditText txtMascarilla;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();


        txtTotal=findViewById(R.id.txtTotal);
        txtCortes=findViewById(R.id.txtCortes);
        txtCeja=findViewById(R.id.txtCeja);
        txtBarba=findViewById(R.id.txtBarba);
        txtMascarilla=findViewById(R.id.txtMascarilla);
    }
    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText txtCortes = (EditText)
                        findViewById(R.id.txtCortes);
                String cortesStr = txtCortes.getText().toString();
                double cortes = Double.parseDouble(cortesStr);
                final EditText txtCeja = (EditText)
                        findViewById(R.id.txtCeja);
                String cejaStr = txtCeja.getText().toString();
                double ceja = Double.parseDouble(cejaStr);

                final EditText txtBarba = (EditText)
                        findViewById(R.id.txtBarba);
                String barbaStr = txtBarba.getText().toString();
                double barba = Double.parseDouble(barbaStr);
                final EditText txtMascarilla = (EditText)
                        findViewById(R.id.txtMascarilla);
                String mascarillaStr = txtMascarilla.getText().toString();
                double mascarilla = Double.parseDouble(mascarillaStr);



                Double totalCortes=100*cortes;
                Double totalCeja=20*ceja;
                Double totalBarba=40*barba;
                Double totalMascarilla=50*mascarilla;

                double TotalPago = totalCortes + totalCeja + totalBarba + totalMascarilla;
                final EditText txtTotal = (EditText)
                        findViewById(R.id.txtTotal);
                txtTotal.setText(Double.toString(TotalPago));
                

            }
        });
    }

    public void btnCalcularTotal(){
    Button btnCalcularTotalPago=findViewById(R.id.button);
    btnCalcularTotalPago.setOnClickListener(new BtnCalcularTotalEscuchador());
    }

    class BtnCalcularTotalEscuchador implements View.OnClickListener{
        public void onClick(View v){
            //Obtiene los valores capturado por el usuario en las cajas de texto
            String cortesStr=txtCortes.getText().toString();
            String cejaStr=txtCeja.getText().toString();
            String barbaStr=txtBarba.getText().toString();
            String mascarillaStr=txtMascarilla.getText().toString();

            //Convierte los valores leidos a double
            Double cortesDbl=Double.parseDouble(cortesStr);
            Double cejaDbl=Double.parseDouble(cejaStr);
            Double barbaDbl=Double.parseDouble(barbaStr);
            Double mascarillaDbl=Double.parseDouble(mascarillaStr);



            //Obtiene el total de lo que se realizo
            Double calcular = calcularTotal(cortesDbl, cejaDbl,barbaDbl,mascarillaDbl);
            //Asignan el resultado al componente de la vista
            txtTotal.setText(Double.toString(calcular));
        }
    }
    /**
     * Metodo que calcula el indice de masa corporal
     *
     * @param totalCortes    Numero de cortes de cabello
     * @param totalCeja Numero de corte y arreglo de ceja
     * @param totalBarba   Numero de cortes y arreglo de barba
     * @param totalMascarilla Numero de mascarillas aplicadas
     * @return Resultado final en formato double
     */
    private Double calcularTotal(Double totalCortes,Double totalCeja, Double totalBarba,Double totalMascarilla){
        double calcular= totalCortes+ totalCeja + totalBarba + totalMascarilla;
        return calcular;
    }
}