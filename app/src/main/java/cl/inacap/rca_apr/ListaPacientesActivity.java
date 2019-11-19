package cl.inacap.rca_apr;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.rca_apr.modelo.ListaDePacientes;
import cl.inacap.rca_apr.modelo.Paciente;

public class ListaPacientesActivity extends ListActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista(){
        lista = getListView();
        //
        List<Paciente> pacienteList = ListaDePacientes.getInstancia().getListaDePacientes();
        ArrayAdapter<Paciente> listaAdapter = new ArrayAdapter<Paciente>(this,android.R.layout.simple_expandable_list_item_1,pacienteList);
        lista.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id){
        Intent intent = new Intent(ListaPacientesActivity.this, DetallesPacientesActivity.class);
        intent.putExtra("idPaciente",(int)id);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resulCode, Intent data){
        super.onActivityResult(requestCode,resulCode,data);
        if (requestCode==1){
            if (resulCode==RESULT_OK){
                cargarLista();
            }
        }
    }
}
