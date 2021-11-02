package com.santana.java.back.end.userapi.dto;

import com.santana.java.back.end.client.model.dto.UserDTO;
import com.santana.java.back.end.userapi.model.User;

public class DTOConverter {

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setDataCadastro(user.getDataCadastro());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setEmail(user.getEmail());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setNome(user.getNome());
        userDTO.setKey(user.getKey());
        return userDTO;
    }
}
