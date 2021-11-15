package com.misterjackpot.cartorio.controller;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.service.CartorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class CartorioController {

    private final CartorioService service;

    @RequestMapping(value = "/cartorios", method = RequestMethod.GET)
    public String buscar(Model model) {
        List<CartorioDTO> cartorios = service.buscarCartorios();
        model.addAttribute("cartorios", cartorios);
        model.addAttribute("cartorioDTO", new CartorioDTO());
        return "cartorio";
    }

    @RequestMapping(value = "/cartorios", method = RequestMethod.POST)
    public String salvar(Model model, @ModelAttribute CartorioDTO cartorioDTO){

        service.salvarCartorio(cartorioDTO);

        return "redirect:/cartorios/";
    }

    @RequestMapping(value = "/cartorios/{id}", method = RequestMethod.DELETE)
    public String excluir(Model model, @PathVariable("id") Long id){

        service.excluirCartorio(id);

        return "redirect:/cartorios/";
    }
}
