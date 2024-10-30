package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import static org.junit.jupiter.api.Assertions.*;

public class AlertaManagementSteps {

    @Dado("que o usuário tem permissão para criar alertas")
    public void queOUsuarioTemPermissaoParaCriarAlertas() {
        // Código para garantir que o usuário tenha permissão
    }

    @Quando("ele envia uma requisição POST para \"/api/alertas\" com dados válidos do alerta")
    public void eleEnviaUmaRequisicaoPOSTParaApiAlertasComDadosValidosDoAlerta() {
        // Código para enviar a requisição POST com dados válidos
    }

    @Entao("o sistema deve responder com status 201")
    public void oSistemaDeveResponderComStatus201() {
        // Código para validar que o status é 201
    }

    @Entao("o corpo da resposta deve conter os detalhes do alerta criado")
    public void oCorpoDaRespostaDeveConterOsDetalhesDoAlertaCriado() {
        // Código para verificar que a resposta contém os detalhes do alerta
    }

    @Quando("o usuário envia uma requisição GET para \"/pacientes/{id_inexistente}\"")
    public void oUsuarioEnviaUmaRequisicaoGETParaPacientesIdInexistente() {
        // Código para enviar a requisição GET para um ID inexistente
    }

    @Entao("o sistema deve responder com status 404")
    public void oSistemaDeveResponderComStatus404() {
        // Código para verificar que o status é 404
    }
}
