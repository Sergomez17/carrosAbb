package co.edu.umanizales.carrosabb.controller;

import co.edu.umanizales.carrosabb.model.*;
import co.edu.umanizales.carrosabb.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
public class Controller {
    @Autowired
    private TreeService treeService;

    @GetMapping()
    public Node abb() {
        return treeService.vercarro();
    }

    @PostMapping("/add")
    public String add(@RequestBody Carro carro) {
        treeService.getAbb().add(carro);
        return"Se agrego biene el carro";
    }
    @GetMapping("/preorder")
    public List<Integer> postOrder(){
        return treeService.getAbb().postOrder();
    }
    @GetMapping("/count")
    public int count(){
        return treeService.getAbb().count();
    }
    @GetMapping("/height")
    public int calculateHeight(){
        return treeService.getAbb().calculateHeight();
    }
    @GetMapping("/prune")
    public String prune(){
        treeService.getAbb().prune();
        return "Se podo la rama";
    }
    @GetMapping("/isleaf")
    public String leaf(){
        return treeService.getAbb().leaf();
    }
    @GetMapping("/valexi")
    public String val(@RequestBody Carro carro){
        return treeService.getAbb().valExi(carro);
    }
    @GetMapping("/inorder")
    public List<Integer> inorder(){
        return treeService.getAbb().inOrder();
    }
