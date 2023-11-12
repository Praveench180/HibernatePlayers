/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.player.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.web.server.ResponseStatusException;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

import org.springframework.http.HttpStatus;
import com.example.player.model.Player;
import com.example.player.repository.*;

@Service
public class PlayerJpaService implements PlayerRepository {
    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> getPlayers = playerJpaRepository.findAll();
        ArrayList<Player> allPlayers = new ArrayList<>(getPlayers);
        return allPlayers;
    }

    @Override
    public Player getPlayerbyId(int playerId) {
        try {
            Player player = playerJpaRepository.findById(playerId).get();
            return player;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player player) {
        playerJpaRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        try {
            Player newplayer = playerJpaRepository.findById(playerId).get();
            if (player.getPlayerName() != null) {
                newplayer.setPlayerName(player.getPlayerName());
            }
            if (player.getJerseyNumber() != 0) {
                newplayer.setJerseyNumber(player.getJerseyNumber());
            }
            if (player.getRole() != null) {
                newplayer.setRole(player.getRole());
            }
            playerJpaRepository.save(newplayer);
            return newplayer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            playerJpaRepository.deleteById(playerId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}