package br.com.arieltintel.apibusca_endereco.service;

import br.com.arieltintel.apibusca_endereco.client.ViaCepClient;
import br.com.arieltintel.apibusca_endereco.dto.EnderecoResponseDTO;
import br.com.arieltintel.apibusca_endereco.dto.EnderecoViaCepResponseDTO;
import br.com.arieltintel.apibusca_endereco.exceptions.EnderecoBadRequestException;
import br.com.arieltintel.apibusca_endereco.exceptions.EnderecoNotFoundException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class EnderecoService {

    private final ViaCepClient viaCepClient;

    public EnderecoResponseDTO getEndereco(String cep) {
        try {
            EnderecoViaCepResponseDTO enderecoViaCepResponseDTO = viaCepClient.getEndereco(cep);
            if (ObjectUtils.isEmpty(enderecoViaCepResponseDTO) || enderecoViaCepResponseDTO.getCep() == null) {
                throw new EnderecoNotFoundException(cep);
            }
            return enderecoViaCepResponseDTO.to();
        } catch (FeignException.BadRequest badRequest) {
            log.error("error: " + badRequest.getMessage());
            throw new EnderecoBadRequestException(cep);
        }
    }

    public List<EnderecoResponseDTO> getEnderecoList(String uf, String cidade, String bairro) {
        try {
            List<EnderecoViaCepResponseDTO> enderecoViaCepResponseDTOList = viaCepClient.getEnderecoList(uf, cidade, bairro);
            if (CollectionUtils.isEmpty(enderecoViaCepResponseDTOList)) {
                throw new EnderecoNotFoundException(uf, cidade, bairro);
            }
            return new EnderecoViaCepResponseDTO().toList(enderecoViaCepResponseDTOList);
        } catch (FeignException.BadRequest badRequest) {
            log.error("error: " + badRequest.getMessage());
            throw new EnderecoBadRequestException(uf, cidade, bairro);
        }
    }

}
