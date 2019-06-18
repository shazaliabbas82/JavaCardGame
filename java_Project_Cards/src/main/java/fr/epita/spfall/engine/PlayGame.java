/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.engine;

import com.jakewharton.fliptables.FlipTableConverters;
import fr.epita.spfall.daos.PlayerDao;
import fr.epita.spfall.daos.XMLWorker;
import fr.epita.spfall.entities.Card;
import fr.epita.spfall.entities.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ShzlAbbs
 */
public class PlayGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Game g = new Game();
        XMLWorker xmlw = new XMLWorker();
        PlayerDao pdao = new PlayerDao();
        Scanner sc = new Scanner(System.in);
        int cards_to_win = 0;
        g.initialize();
        //Displaying cards in order
        System.out.println(FlipTableConverters.fromIterable(g.getCards(), Card.class));
        //g.getCards().stream().forEach(c -> c.describe());
        System.out.println("How many players are going to play? ");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        int n = sc.nextInt();
        //sc.nextLine();
        System.out.println("How many rounds?");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        g.setRound(sc.nextInt());
        //sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter the player N°" + (i + 1));
            String name = sc.next();
            g.getPlayers().add(new Player(name));
        }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < g.getRound(); i++) {
            PlayGame.playRound(g, i, n, sc);
            //PlayGame.displayResults(g.getPlayers());
        }
        System.out.println("");
        System.out.println("********************  GAME END  *******************");
        System.out.println("");
        System.out.println("****************  DISPLAYING SCORES  ****************");
        PlayGame.displayResults(g.getPlayers());
        xmlw.create(g);

    }
    
    public static void startGame(){
        
    }

    public static void displayResults(List<Player> players) {
        System.out.println(FlipTableConverters.fromIterable(players, Player.class));
    }

    public static void playRound(Game g, int i, int n, Scanner sc) {
        System.out.println("******************** ROUND " + i + " START *******************");
        System.out.println("");
        g.shuffle();
        List<Integer> cartes = new ArrayList();

        g.getPlayers().forEach((Player p) -> {
            p.setChoice(100);
            System.out.println("-" + p.getName() + ": ");
            while (p.getChoice() > 52) {
                while (!sc.hasNextInt()) {
                    sc.next();
                }
                p.setChoice(sc.nextInt());
                System.err.println("card " + g.getCards().get(p.getChoice()).getType() + "-" + g.getCards().get(p.getChoice()).getValue());
            }
            cartes.add(g.getCards().get(p.getChoice()).getOrder());
        });

        int max = Collections.max(cartes);
        g.getPlayers().forEach((Player p) -> {
            if (g.getCards().get(p.getChoice()).getOrder() == max) {
                p.setCards(p.getCards() + n);
                p.setScore(p.getScore() + 1);
            }
        });
    }

}
