package cl.inacap.rca_apr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cl.inacap.rca_apr.modelo.ListaDePacientes;
import cl.inacap.rca_apr.modelo.Paciente;

public class NuevoPacienteActivity extends AppCompatActivity implements View.OnClickListener {

    Button IngresarFecha;
    EditText ingresarfecha;
    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_paciente);

        IngresarFecha=(Button)findViewById(R.id.IngresarFecha);
        ingresarfecha=(EditText)findViewById(R.id.ingresarfecha);
        IngresarFecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View vi) {

        if(vi==IngresarFecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthYear, int dayOfMonth){
                    ingresarfecha.setText(dayOfMonth+"/"+monthYear+"/"+year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }

    }

    public void ingresarPaciente(View view){
        ListaDePacientes listaDePacientes = ListaDePacientes.getInstancia();
        String nombre = ((TextView)findViewById(R.id.ingresarNombre)).getText().toString();
        String apellido = ((TextView)findViewById(R.id.ingresarApellido)).getText().toString();
        String edadStr = ((TextView)findViewById(R.id.ingresarEdad)).getText().toString();
        String diag = ((TextView)findViewById(R.id.ingresardiag)).getText().toString();
        String obs = ((TextView)findViewById(R.id.ingresarosb)).getText().toString();
        String fecha = ((TextView)findViewById(R.id.ingresarfecha)).getText().toString();

        int edad=0;
        try{
            edad = Integer.parseInt(edadStr);
        }catch (NumberFormatException ex){
            Toast.makeText(this,"Debe ingresar un número.",Toast.LENGTH_SHORT).show();
        }

        if (edad>0){
            Paciente paciente = new Paciente(nombre,apellido,edad,diag,obs,fecha);
            listaDePacientes.agregarPaciente(paciente);
            Toast.makeText(this,"Se ha ingresado el paciente correctamente",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this,"Ingrese una cantidad mayor a cero", Toast.LENGTH_SHORT).show();
        }
    }

}
