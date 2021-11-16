package com.misterjackpot.cartorio.controller;

import com.misterjackpot.cartorio.dto.CartorioDTO;
import com.misterjackpot.cartorio.dto.TipoCertidaoDTO;
import com.misterjackpot.cartorio.service.CartorioService;
import com.misterjackpot.cartorio.service.CertidaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class CartorioController {

    private final CartorioService service;
    private final CertidaoService certidaoService;

    @RequestMapping(value = "/cartorios", method = RequestMethod.GET)
    public String buscar(Model model) {
        List<CartorioDTO> cartorios = service.buscarCartorios();
        Map<Long, TipoCertidaoDTO> certidoes = certidaoService.buscarTiposCertidao().stream().collect(Collectors.toMap(TipoCertidaoDTO::getId, Function.identity()));

        model.addAttribute("cartorios", cartorios);
        model.addAttribute("cartorioDTO", new CartorioDTO());
        model.addAttribute("tiposCertidao", certidoes);

        return "cartorio";
    }

    @RequestMapping(value = "/cartorios", method = RequestMethod.POST)
    public String salvar(Model model, @ModelAttribute CartorioDTO cartorioDTO) {

        service.salvarCartorio(cartorioDTO);

        return "redirect:/cartorios/";
    }

    @RequestMapping(value = "/cartorios/{id}", method = RequestMethod.DELETE)
    public String excluir(Model model, @PathVariable("id") Long id) {

        service.excluirCartorio(id);

        return "redirect:/cartorios/";
    }

    @RequestMapping(value = "/cartorios/{id}", method = RequestMethod.PUT)
    public String atualizar(Model model, @ModelAttribute CartorioDTO cartorioDTO, @PathVariable("id") Long id) {

        service.atualizarCartorio(id, cartorioDTO);

        return "redirect:/cartorios/";
    }

    @RequestMapping(value = "/cartorios/{id}", method = RequestMethod.GET)
    public String telaEdicao(Model model, @PathVariable("id") Long id) {

        Map<Long, TipoCertidaoDTO> certidoes = certidaoService.buscarTiposCertidao().stream().collect(Collectors.toMap(TipoCertidaoDTO::getId, Function.identity()));

        model.addAttribute("cartorio", service.buscarCartorio(id));
        model.addAttribute("tiposCertidao", certidoes);

        return "cartorio-edit";
    }
}
