package br.com.arieltintel.apibusca_endereco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnderecoViaCepResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoResponseDTO to() {
        return EnderecoResponseDTO.builder()
                .cep(this.cep)
                .logradouro(this.logradouro)
                .complemento(this.complemento)
                .bairro(this.bairro)
                .cidade(this.localidade)
                .uf(this.uf)
                .build();
    }

    public List<EnderecoResponseDTO> toList(List<EnderecoViaCepResponseDTO> enderecoViaCepResponseDTOList){
        return enderecoViaCepResponseDTOList.stream()
                .map(EnderecoViaCepResponseDTO::to)
                .collect(Collectors.toList());
    }

}
