/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here

package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

@RestController
public class PlayerController {
    @Autowired
    private PlayerJpaService playerjpaservice;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerjpaservice.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerbyId(@PathVariable("playerId") int playerId) {
        return playerjpaservice.getPlayerbyId(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerjpaservice.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return playerjpaservice.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerjpaservice.deletePlayer(playerId);
    }
}