package Cesar.Rotas.Caminhao.demo.dto;

import Cesar.Rotas.Caminhao.demo.model.caminhao.Caminhao;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaminhaoDto {
    @NotBlank
    private Boolean status ; 
    @Column(nullable = false, length = 5)
	private String location;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	// É comum que a classe CaminhaoDTO tenha um método toEntity() que converte os dados do DTO para
	//  uma instância da classe Caminhao. Isso é frequentemente usado para realizar a conversão entre 
	//  objetos DTO (usados para comunicação) e objetos de modelo de domínio (usados para persistência).
	public Caminhao toEntity() {
        return Caminhao.builder()
                .status(this.status)
                .location(this.location)
				.build();
                
    }
}   

