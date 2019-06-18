/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.daos;

import fr.epita.spfall.entities.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

/**
 *
 * @author ShzlAbbs
 */
public class PlayerDao implements XMLDao<Player> {

    private List<Player> players = new ArrayList<>();

    public PlayerDao() {
        //
    }

    @Override
    public Player get(String name) {
        try {
            Document document = XMLWorker.mainDocument();
            Node node = document.selectSingleNode("/root/players/name='" + name + "']");
            Player p = new Player(Integer.valueOf(node.selectSingleNode("").getText()), node.selectSingleNode("").getText());
            return p;
        } catch (DocumentException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Player> getAll() {
        try {
            players = new ArrayList();
            Document document = XMLWorker.mainDocument();
            List<Node> nodes = document.selectNodes("/root/players/player");
            nodes.forEach(n -> {
                players.add(new Player(Integer.valueOf(n.selectSingleNode("score").getText()),
                        n.selectSingleNode("name").getText()));
            });
            return players;
        } catch (DocumentException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }

    @Override
    public void save(Player t) {
        try {
            Document document = XMLWorker.mainDocument();
            Node node = document.selectSingleNode("/root/players");
            //XMLWorker.updateFile(node);
        } catch (DocumentException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Player t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Player t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
