package co.edu.umanizales.carrosabb.service;

import co.edu.umanizales.carrosabb.model.ABB;
import co.edu.umanizales.carrosabb.model.Node;
import co.edu.umanizales.carrosabb.controller.Controller;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TreeService {
    private ABB ABB;
    private Node node;

    @PostConstruct
    public void init() {
        ABB = new ABB();
    }
    public Node vercarro() {
        return ABB.getRoot();
    }

}
