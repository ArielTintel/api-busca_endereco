package br.com.arieltintel.apibusca_endereco.client;

import br.com.arieltintel.apibusca_endereco.dto.EnderecoViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoViaCepResponseDTO getEndereco(@PathVariable String cep);

}
