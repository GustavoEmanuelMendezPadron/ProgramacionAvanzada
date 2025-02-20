package Crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Agregar eventos a los botones
        this.vista.getBtnCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setDato(vista.getTxtBuscar().getText());
                vista.getTxtArea().append("Creado: " + modelo.getDato() + "\n");
            }
        });

        this.vista.getBtnRead().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getTxtArea().append("Leyendo: " + modelo.getDato() + "\n");
            }
        });

        this.vista.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setDato(vista.getTxtBuscar().getText());
                vista.getTxtArea().append("Actualizado: " + modelo.getDato() + "\n");
            }
        });

        this.vista.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getTxtArea().append("Eliminado: " + modelo.getDato() + "\n");
                modelo.setDato("");
            }
        });
    }
}
