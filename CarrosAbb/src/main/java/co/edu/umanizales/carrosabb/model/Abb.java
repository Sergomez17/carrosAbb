package co.edu.umanizales.carrosabb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ABB {
    private Node root;
    private int size;

    public void add(Carro carro) {
        if (root == null) {
            root = new Node(carro);
        } else {
            root.add(carro);
        }
    }
    public String valExi(Carro carro) {
        return root.validateIdExist(carro);
    }

    public List<Integer> postOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.postOrder(listadoInicial);
            return listadoInicial;
        }
    }

    public int count(){
        return root == null ? 0 : root.count();
    }

    public int calculateHeight(){
        if (root == null) return 0;
        final var height = root.getHeight();
        return height;
    }

    public void prune(){
        if(root !=null){
            root.prune();
        }
    }

    public String leaf(){
        if (root == null) {
            return "No hay nada";
        }
        return "Es la raiz";
    }

    public List<Integer> inOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.inOrder(listadoInicial);
            return listadoInicial;
        }
    }

    public List<Integer> preOrder(){
        if(root ==null){
            return null;
        }
        else{
            List<Integer> listadoInicial = new ArrayList<>();
            root.preOrder(listadoInicial);
            return listadoInicial;
        }

    }
}