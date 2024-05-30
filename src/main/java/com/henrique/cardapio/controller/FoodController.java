package com.henrique.cardapio.controller;

import com.henrique.cardapio.food.Food;
import com.henrique.cardapio.food.FoodRepository;
import com.henrique.cardapio.food.FoodRequestDTO;
import com.henrique.cardapio.food.FoodResponseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodRepository.save(foodData);
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
