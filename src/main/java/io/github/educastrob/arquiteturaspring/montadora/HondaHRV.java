package io.github.educastrob.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Carro {
    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HRV");
        setColor(Color.BLUE);
        setMontadora(Montadora.HONDA);
    }
}
