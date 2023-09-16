package Robocop;

import robocode.*;
import java.awt.Color;

public class Robocop extends Robot {
    
    public void run() {
        // Configura a cor do robô
        setColors(Color.blue, Color.red, Color.green);

        while (true) {
            // Move-se aleatoriamente
            ahead(Math.random() * 100);
            turnRight(Math.random() * 90);

            // Procura inimigos
            scan();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        // Quando um inimigo é detectado, mira e atira
        double enemyDistance = e.getDistance();

        if (enemyDistance < 200) {
            fire(3); // Atira com alta potência a curta distância
        } else {
            fire(1); // Atira com potência mais baixa a longa distância
        }

        // Vira em direção ao inimigo
        turnRight(e.getBearing());
    }

    public void onHitWall(HitWallEvent e) {
        // Ao atingir a parede, vira na direção oposta
        turnRight(180);
    }

    public void onHitRobot(HitRobotEvent e) {
        // Ao colidir com outro robô, recua
        back(50);
    }
}
