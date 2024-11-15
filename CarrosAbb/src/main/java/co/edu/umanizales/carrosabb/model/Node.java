package co.edu.umanizales.carrosabb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Node{
    private Carro data;
    private Node left;
    private Node right;
    private int cont;

    public Node(Carro data){
        this.data = data;
        this.cont = 1;
    }

    public boolean isLeaf(){
        if(left == null && right == null){
            return true;
        }
        else {
            return false;
        }
    }

    public int getHeight(){
        if (this == null){
            return -1;
        }
        else {
            return 1 + Math.max(left.getHeight(), right.getHeight());
        }
    }

    public boolean isComplete(){
        if(Math.pow(2, this.getHeight()) -1 == cont){
            return true;
        }
        else {
            return false;
        }
    }


    public void add(Carro carro){
        if (carro.getPlaca().toLowerCase().compareTo(this.getData().getPlaca().toLowerCase()) < 0){
            if (getLeft() == null){
                setLeft(new Node(carro));
            }
            else {
                getLeft().add(carro);
            }
        }
        else {
            if (getRight() == null){
                setRight(new Node(carro));
            }
            else {
                getRight().add(carro);
            }
        }
        cont++;
    }

    public void postOrder(List<Integer> listado){
        if (getLeft() != null){
            getLeft().postOrder(listado);
        }
        if (getRight() != null){
            getRight().postOrder(listado);
        }
        listado.add(Integer.valueOf(getData().getPlaca()));
    }

    public int count(){
        return 1 + (this.getLeft() != null ? this.getLeft().count() : 0) + (this.getRight() != null ? this.getRight().cont : 0);
    }
    public int getHeight(){
        if (isLeaf()){
            return 1;
        }
        else {
            int altizq = 1, altder = 1;
            if(this.getLeft() != null) {
                altizq = right.getHeight();
            }
        }
        if (this.right != null) {
            altder = right.getHeight();
        }
        return altizq > alter ? altizq + 1 : altder + 1;
    }

    public boolean hasCarro(){
        return getLeft() != null || getRight() != null;
    }

    public void prune(){
        if (getLeft() != null && getLeft().isLeaf().hasCarro()){
            getLeft().prune();
        }
        else{
            setLeft(null);
        }
        if(getRight() != null && getRight().hasCarro()){
            getRight().prune();
        }
        else {
            setRight(null);

        }
        cont = count();
    }
    public String validateIdExist(Carro carro) {
        if (carro.getPlaca() == this.data.getPlaca()) {
            return "El id ya existe";
        }

        if (carro.getPlaca().toLowerCase().compareTo(this.getData().getPlaca().toLowerCase()) < 0){
            return this.left.validateIdExist(carro);
        }

        if (carro.getPlaca() > this.data.getPlaca() && this.right != null) {
            return this.right.validateIdExist(carro);
        }
        return "Se agregó el id";
    }

    public void inOrder(List<Integer> listado){
        if(getLeft() != null){
            getLeft().inOrder(listado);
        }

        listado.add(getData().getPlaca());

        if(getRight() != null){
            getRight().inOrder(listado);
        }
    }

    public void preOrder(List<Integer> listado){
        if(getLeft() != null){
            listado.add(getData().getPlaca());
        }
        getLeft().preOrder(listado);

        if(getRight() != null){
            getRight().preOrder(listado);
        }
    }
}
