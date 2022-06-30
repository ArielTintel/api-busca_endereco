package br.com.arieltintel.apibusca_endereco.service;

import br.com.arieltintel.apibusca_endereco.client.ViaCepClient;
import br.com.arieltintel.apibusca_endereco.dto.EnderecoResponseDTO;
import br.com.arieltintel.apibusca_endereco.dto.EnderecoViaCepResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final ViaCepClient viaCepClient;

    public EnderecoResponseDTO getEndereco(String cep) {
        EnderecoViaCepResponseDTO enderecoViaCepResponseDTO = viaCepClient.getEndereco(cep);
        return enderecoViaCepResponseDTO.to();
    }

}
