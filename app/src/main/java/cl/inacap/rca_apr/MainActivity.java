package cl.inacap.rca_apr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.rca_apr.modelo.ListaDePacientes;
import cl.inacap.rca_apr.modelo.Paciente;

public class MainActivity extends AppCompatActivity {

    private ListaDePacientes lista = ListaDePacientes.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view){
        ArrayList<Paciente> pacientes = lista.getListaDePacientes();
        if (pacientes.size()>0){
            Intent intent = new Intent(this,ListaPacientesActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"La lista de pacientes esta vacia",Toast.LENGTH_SHORT).show();
        }
    }

    public void ingresarNuevo(View view){
        Intent intent = new Intent(this, NuevoPacienteActivity.class);
        startActivity(intent);
    }

    public void eliminarPaciente(View view){
        lista.eliminarPaciente();
        Toast.makeText(this,"Se han eliminado los pacientes.",Toast.LENGTH_SHORT).show();
    }
}
