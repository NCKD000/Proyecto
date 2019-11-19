package cl.inacap.rca_apr.modelo;

import java.util.ArrayList;

public class ListaDePacientes {

    private static ListaDePacientes instancia=new ListaDePacientes();
    private ArrayList<Paciente> listaDePacientes;

    private ListaDePacientes(){
        listaDePacientes=new ArrayList<>();
    }

    public static ListaDePacientes getInstancia(){
        return instancia;
    }

    public void agregarPaciente(Paciente paciente){
        listaDePacientes.add(paciente);
    }

    public Paciente getPaciente(int id){
        return listaDePacientes.get(id);
    }

    public ArrayList<Paciente> getListaDePacientes(){
        return listaDePacientes;
    }

    public void eliminarPaciente(){
        for (int i=0; i<listaDePacientes.size();i++){
            if (!listaDePacientes.get(i).isEstado()){
                listaDePacientes.remove(i);
                i--;
            }
        }
    }
}


