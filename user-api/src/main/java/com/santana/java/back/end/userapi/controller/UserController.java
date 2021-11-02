package com.santana.java.back.end.userapi.controller;

import com.santana.java.back.end.client.model.dto.UserDTO;
import com.santana.java.back.end.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-1234");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("2341-1234");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping
    public String getMensagem(){
        return "Spring boot is working!";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDTO findByCpf(@RequestParam(name = "key", required = true) String key,@PathVariable String cpf){
        //for(UserDTO userFilter : usuarios){
        //    if(userFilter.getCpf().equals(cpf)){
        //        return userFilter;
        //    }
        //}
        return userService.findByCpf(cpf,key);
    }

    @PostMapping("/user")
    public UserDTO inserir(@RequestBody UserDTO userDTO){
        //userDTO.setDataCadastro(new Date());
        //usuarios.add(userDTO);
        return userService.save(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id) throws EntityNotFoundException {
        //for(UserDTO userFilter : usuarios){
        //    if(userFilter.getCpf().equals(cpf)){
        //        usuarios.remove(userFilter);
        //        return true;
        //    }
        //}
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome",required = true) String nome){
        return userService.queryByName(nome);
    }
}
